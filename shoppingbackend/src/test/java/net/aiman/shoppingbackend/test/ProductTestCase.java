package net.aiman.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
import net.aiman.shoppingbackend.dao.ProductDAO;
import net.aiman.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.aiman.shoppingbackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDproduct() {
//		product=new Product();
//		product.setName("Oppo Selfie S53");
//		product.setBrand("Oppo");
//		product.setDescription("This is some description for oppo mobile phones");
//		product.setUnit_price(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		assertEquals("Something went wrong while inserting a new product",true,productDAO.add(product));
//		
//		product=productDAO.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Something went wrong while updating the existing products",true,productDAO.update(product));
//		
//		assertEquals("Something went wrong while deleting the existing record",true,productDAO.delete(product));
//		
//		
//		assertEquals("Something went wrong while fetching the list of products",6,productDAO.list().size());
//		
//		
//		
//	}
//	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong bwhile fetching the list of products",5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products",3,productDAO.listActiveProductByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products",2,productDAO.listActiveProductByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products",3,productDAO.getLatestActiveProduct(3).size());
		
	}
	

}
