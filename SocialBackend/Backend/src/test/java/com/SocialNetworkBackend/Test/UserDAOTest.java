package com.SocialNetworkBackend.Test;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.SocialNetworkBackEnd.Config.DBConfig;
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.User;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes={DBConfig.class})
@WebAppConfiguration
@Transactional
public class UserDAOTest {
  
   @Autowired
  UserDao userdao;
	@Autowired
    public User user;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Ignore
	@Test
	public void addTest()
	{
		//UserDao userdao=new UserDaoImpl(sessionFactory);
		User user=new User();
		user.setUserId(12);
		user.setUsername("abc");
		user.setRole("user");
		user.setEmailId("abc@gmail.com");
		user.setIsOnline("N");
		user.setPassword("aabb");
		System.out.println("check1");
		System.out.println(userdao);
		assertTrue("Problem in Inserting User",userdao.addUser(user));
		System.out.println("check2");
		System.out.println("EmailID:"+user.getEmailId());
		System.out.println("UserName:"+user.getUsername());
	}
}
