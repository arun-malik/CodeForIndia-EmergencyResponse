package com.codeforindia.emrgncyres.service;

import java.util.List;

import com.codeforindia.emrgncyres.model.*;

public interface UserOperationService {
	
	public List<UserDetails> getUsers();
	public UserDetails getUser(String usernameOruserCode);
	public UserDetails getUser(Integer userDetailsKey);
	public UserDetails createUser(UserDetails user );
	public UserDetails updateUser(UserDetails user );
	public String deleteUser(UserDetails user );

}
