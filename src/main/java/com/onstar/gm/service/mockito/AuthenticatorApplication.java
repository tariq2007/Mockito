package com.onstar.gm.service.mockito;

public class AuthenticatorApplication {
	
	private AuthenticatorInterface authenticator;

	public AuthenticatorApplication(AuthenticatorInterface authenticator) {
		super();
		this.authenticator = authenticator;
	}
	
	public boolean authenticate(String userName, String password) throws EmptyCredentialsException {
		System.out.println("Invocation count :1 " );
		return this.authenticator.authenticateUser(userName, password);
	}

}
