package com.SocialNetworkBackEnd.Dao;

import com.SocialNetworkBackEnd.Model.User;

public interface UserDao {

	 public boolean addUser(User user);
	 public boolean updateOnlineStatus(String status,User user);
		User getUser (String username);
		
}
