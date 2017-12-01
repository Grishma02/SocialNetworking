package com.SocialNetworkBackEnd.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.SocialNetworkBackEnd.Model.Job;

public class JobDAOImpl implements JobDAO{

	@Autowired
	private SessionFactory SessionFactory;
	public boolean addJob(Job job) {
	try {
	SessionFactory.getCurrentSession().save(job);
	return true;
	} catch (Exception e) {
	e.printStackTrace();
	return false;
	}
	}


	public boolean updateJob(Job job) {
	try{
	SessionFactory.getCurrentSession().saveOrUpdate(job);
	return true;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	return false;
	}
	}

	public boolean deleteJob(Job job) {
	try{
	SessionFactory.getCurrentSession().delete(job);
	return true;
	}
	catch(Exception e)
	{
	System.out.println("Exception Occured"+e);
	return false;
	}
	}


	public Job getJob(int jobId) {
	Session session = SessionFactory.openSession();
	Job job = session.get(Job.class, jobId);
	session.close();
	return job;

	}



	



	}




