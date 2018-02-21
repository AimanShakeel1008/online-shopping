package net.aiman.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.aiman.shoppingbackend.dao.CategoryDAO;
import net.aiman.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.aiman.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category=new Category();
//		category.setName("Refrigerator");
//		category.setDescription("This is some description for Refrigerator");
//		category.setImageURL("CAT_4.png"); 
//		
//		assertEquals("Successfully added a category in table",true,categoryDAO.add(category));
//	}
	
	
//	@Test
//	public void testGetCategory() {
//		category=categoryDAO.get(3);
//		assertEquals("Successfull fetched a single category from table","Laptop",category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category=categoryDAO.get(3);
//		category.setName("Lappy");
//		assertEquals("Successfull updated name of a single category in the table",true,categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category=categoryDAO.get(3);
//		assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		category=categoryDAO.get(3);
//		assertEquals("Successfully fetched the list of categories from the table",3,categoryDAO.list().size());
//	}
	
	@Test
	public void testCRUDCategory() {
		
		//add operation
		category=new Category();
		category.setName("Television");
		category.setDescription("This is some description for Television");
		category.setImageURL("CAT_1.png"); 
		assertEquals("Successfully added a category in table",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_2.png"); 
		assertEquals("Successfully added a category in table",true,categoryDAO.add(category));
		
		//fetching and updating category
		category=categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully updated name of a single category in the table",true,categoryDAO.update(category));
		
		
		//deleting category
		category=categoryDAO.get(2);
		assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
		
		//listing category
		
		assertEquals("Successfully fetched the list of categories from the table",1,categoryDAO.list().size());
		
		
		
	}
	
	
	
	

}
