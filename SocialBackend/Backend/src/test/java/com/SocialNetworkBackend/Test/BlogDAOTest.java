package com.SocialNetworkBackend.Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SocialNetworkBackEnd.Dao.BlogDAO;
import com.SocialNetworkBackEnd.Model.Blog;

public class BlogDAOTest  {
static BlogDAO blogDAO;

@BeforeClass
public static void initialize(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.SocialNetworkBackEnd");
	context.refresh();
	blogDAO=(BlogDAO)context.getBean("blogDAO");
	
}
@Test
public void addBlogTest()

{
	Blog blog= new Blog();
	blog.setBlogName("Devops");
	blog.setBlogContent("It is basic Java concept");
	blog.setUsername("User");
	blog.setStatus("A");
	blog.setLikes(5);
	blog.setCreationDate(new Date());
assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
}


@Test
public void getAllBlogTest()
{
	List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
	assertNotNull("Blog List not found",blogList.get(0));
	for(Blog blog:blogList)
	{
		System.out.println("Blog Id:"+ blog.getBlogId()+":::"+ "Blog Name"+blog.getBlogName());
	}
	
}
@Test
public void deleteBlogTest()
{
	Blog blog=(Blog)blogDAO.getBlog(1002);
	assertTrue("Problem in deletion", blogDAO.deleteBlog(blog));
}
@Test
public void UpdateBlogTest()
{
	Blog blog=(Blog)blogDAO.getBlog(1002);
	blog.setBlogContent("OOPS, Exception");
	blog.setBlogName("Java");
	assertTrue("Problem in updating", blogDAO.updateBlog(blog));
}
@Test 
public void approveBlog()
{
	Blog blog=(Blog)blogDAO.getBlog(1001);
	assertTrue("Problem in Approving", blogDAO.approveBlog(blog));
	
	}

}
