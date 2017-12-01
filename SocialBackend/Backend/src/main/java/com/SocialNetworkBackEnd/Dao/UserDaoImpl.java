package com.SocialNetworkBackEnd.Dao;

//import javax.persistence.Query;
import javax.transaction.Transactional;


import org.hibernate.Session;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.SocialNetworkBackEnd.Model.User;

@Repository

public class UserDaoImpl  implements UserDao{
    
	@Autowired
	public SessionFactory sessionfactory;
	
	public UserDaoImpl(SessionFactory sessionfactory) {
	 this.sessionfactory=sessionfactory;
	}

	/* (non-Javadoc)
	 * @see com.SocialNetworkBackEnd.Dao.UserDao#addUser(com.SocialNetworkBackEnd.Model.UserDetail)
	 */
	@Transactional
//	@Override
	public boolean addUser(User user) {
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin();
			session.save(user);
			transaction.commit();
			session.close();
			/*System.out.println("1");
		    System.out.println(sessionfactory);

			sessionfactory.getCurrentSession().save(user);*/
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
   
	


	public boolean updateOnlineStatus(String status, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
