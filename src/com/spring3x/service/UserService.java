package com.spring3x.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring3x.dao.LoginLogDao;
import com.spring3x.dao.UserDao;
import com.spring3x.domain.LoginLog;
import com.spring3x.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatchUser(String userName,String password){
		int matchCount = userDao.getMatchCount(userName, password);
		if (matchCount==0) {
			return false;
		} else {
			return true;
		}
	}
	public User findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
	public void loginSuccess(User user){
		user.setCredits(5+user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserid());
		loginLog.setIpString(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}

}
