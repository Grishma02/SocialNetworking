package com.SocialNetworkBackend.Test;


	import static org.junit.Assert.*;

	import java.util.List;

	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.SocialNetworkBackEnd.Dao.ForumDAO;
import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.Forum;

	import junit.framework.TestCase;

	public class ForumDAOTest {

	
	static ForumDAO forumDAO;
	@BeforeClass
	public static void initialize(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.SocialNetworkBackEnd");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
		
	}



		@Test
		public void  addBlogTest()
		{
			Forum forum=new Forum ();
			forum.setForumContent("ABC");
			forum .setForumName("Core Java");
			forum.setForumContent("It Is Based On Simple Java Concept");
			forum.setUsername("Grishma");
		    forum.setStatus("A");
		    forum.setLikes(3);
		    forum.setCreationDate(new java.util.Date());
		    assertTrue("Problem In Inserting Blog",forumDAO.addForum(forum));
		    
		}

		@Test
		public void getBlogTest()

		{
			Forum forum=forumDAO.getForum(1003);
			assertNotNull("Forum Not Found",forum);
			System.out.println("Forum Name:"+forum.getForumName());
		    System.out.println("Forum Content:"+forum.getForumContent());
		    
		}
		
		@Test
		public void getAllForumTest()
		{
			List<Forum> forumList=(List<Forum>)forumDAO.getAllForums();
			assertNotNull("Forum List not found",forumList.get(0));
			for(Forum forum:forumList)
			{
				System.out.println("Forum Id:"+ forum.getForumId()+":::"+ "Forum Name"+forum.getForumName());
			}
			


	@Test
	public void deleteForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(1002);
		assertTrue("Problem in deletion",forumDAO.deleteForum(forum));
	}




	@Test
	public void updateForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(1002);
		forum.setForumContent("OOPS-Exception-Thread-IO-NIO-Localization");
		forum.setForumName("Java");
		assertTrue("Problem in updating",forumDAO.updateForum(forum));
	}


	@Test
	public void approveForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(1001);
		assertTrue("Problem in approving",forumDAO.approveForum(forum));
	}


	@Test
	public void rejectForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(1001);
		assertTrue("Problem in approving", forumDAO.rejectForum(forum));
		
	}


	}


