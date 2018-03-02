package com.onstar.gm.service.mockito;

public interface AuthenticatorInterface {

	public boolean authenticateUser(String userName, String password) throws EmptyCredentialsException;
	
}
