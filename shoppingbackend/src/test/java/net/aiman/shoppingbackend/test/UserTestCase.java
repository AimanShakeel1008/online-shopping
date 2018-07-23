package net.aiman.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.aiman.shoppingbackend.dao.UserDAO;
import net.aiman.shoppingbackend.dto.Address;
import net.aiman.shoppingbackend.dto.Cart;
import net.aiman.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;;
	private User user=null;
	private Cart cart=null;
	private Address address;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.aiman.shoppingbackend");
		context.refresh();
		
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testAdd() {
//		user=new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234567890");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add user!",true,userDAO.addUser(user));
//		
//		address=new Address();
//		address.setAddressLineOne("101/8 JAdoo Society, Krish Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		address.setUserId(user.getId());
//		
//		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			//create cart for this user
//			cart=new Cart();
//			
//			cart.setUser(user);
//			
//			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));
//			
//			//add a shipping address
//			address=new Address();
//			address.setAddressLineOne("201/8 JAdoo Society, Krish Nagar");
//			address.setAddressLineTwo("Near Kaabil Store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			
//			address.setUserId(user.getId());
//			
//			assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
//			
//		}
//		
//		
//		
//		
//	}
	
//	@Test
//	public void testAdd() {
//		user=new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234567890");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		if(user.getRole().equals("USER")) {
//			//create cart for this user
//			cart=new Cart();
//			
//			cart.setUser(user);
//			//attach cart with the user
//			user.setCart(cart);
//		}
//		
//		assertEquals("Failed to add user!",true,userDAO.addUser(user));
//		
//		
//		
//		
//	}
	
//	@Test
//	public void testCaseForUpdateCart() {
//		user=userDAO.getByEmail("hr@gmail.com");
//		cart=user.getCart();
//		
//		cart.setGrandTotal(5555);
//		cart.setCartLine(2);
//		assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
//	}
	
//	@Test
//	public void testAddAddress() {
//		//we need to add an user
//		
//		user=new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234567890");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add user!",true,userDAO.addUser(user));
//		//we are going to add the address
//		
//		
//		address=new Address();
//		address.setAddressLineOne("101/8 JAdoo Society, Krish Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		//attache the user to address
//		
//		address.setUser(user);
//		assertEquals("Failed to add billing address!",true,userDAO.addAddress(address));
//		//we are going to add the shipping address
//		address=new Address();
//		address.setAddressLineOne("201/8 JAdoo Society, Krish Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
//		
//		}
	
//	@Test
//	public void testAddAddress() {
//		user=userDAO.getByEmail("hr@gmail.com");
//		
//		address=new Address();
//		address.setAddressLineOne("201/8 JAdoo Society, Krish Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Bangalore");
//		address.setState("Karnataka");
//		address.setCountry("India");
//		address.setPostalCode("689532");
//		address.setShipping(true);
//		address.setUser(user);
//		assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
//		
//	}
	
	@Test
	public void testGetAddresses() {
		user=userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("Failed to fetch the list",2,userDAO.listShippingAddresses(user).size());
	}
}
