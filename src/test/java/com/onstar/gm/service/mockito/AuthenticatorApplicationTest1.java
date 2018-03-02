package com.onstar.gm.service.mockito;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest1 {
	
	@Mock
	AuthenticatorInterface authenticatorMock;
	
	@InjectMocks
	AuthenticatorApplication authenticatorApplication;
	
	private static final String userName = "admin";
	private static final String password = "adminpwd";
	
	@Test
	public void testAuthenticateMockInjection() throws EmptyCredentialsException {
		when(authenticatorApplication.authenticate(userName, password)).thenReturn(Boolean.TRUE);
		
		boolean actualCall = authenticatorApplication.authenticate(userName, password);
	}
}
