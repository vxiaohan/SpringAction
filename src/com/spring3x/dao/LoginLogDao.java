package com.spring3x.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring3x.domain.LoginLog;

@Repository
public class LoginLogDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insertLoginLog(LoginLog loginLog){
		String sqlString = "INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?)";
		jdbcTemplate.update(sqlString, 
				new Object[]{loginLog.getUserId(),loginLog.getIpString(),loginLog.getLoginDate()});
	}
}
