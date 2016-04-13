
package com.spring3x.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.spring3x.domain.User;

/**
 * @author victor
 *
 */
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName, String password){
		String sqlString="SELECT count(*) FROM t_user WHERE user_name=? and password=?";
		return jdbcTemplate.queryForObject(sqlString, new Object[]{userName, password}, Integer.class);
	}
	public User findUserByUserName(final String userName){
		final User user = new User();
		String sqlString = "SELECT user_id,user_name,credits FROM t_user WHERE user_name=?";
		jdbcTemplate.query(sqlString, new Object[]{userName},
				new RowCallbackHandler() {
					
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						user.setUserid(rs.getInt("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setCredits(rs.getInt("credits"));
					}
				});
		return user;
	}
	public void updateLoginInfo(User user){
		String sqlString = "UPDATE t_user SET last_visit?,last_ip=?,credits=? WHERE user_id=?";
		jdbcTemplate.update(sqlString, new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserid()});
	}
}
