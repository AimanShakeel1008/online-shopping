package net.aiman.shoppingbackend.dao;

import java.util.List;

import net.aiman.shoppingbackend.dto.Address;
import net.aiman.shoppingbackend.dto.Cart;
import net.aiman.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	
	List<Address> listShippingAddresses(User user);
	
	boolean updateCart(Cart cart);

}
