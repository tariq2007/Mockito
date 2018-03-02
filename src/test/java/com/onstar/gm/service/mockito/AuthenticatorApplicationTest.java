package com.onstar.gm.service.mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class AuthenticatorApplicationTest {
	
	AuthenticatorInterface authenticatorMock;
	AuthenticatorApplication authenticatorApplication;

	private static final String userName = "admin";
	private static final String password = "adminpwd";
	
	@Before
	public void setUp() throws EmptyCredentialsException {
		System.out.println("In setup");
		authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
		
		authenticatorApplication = new AuthenticatorApplication(authenticatorMock);
		when(authenticatorApplication.authenticate(userName, password)).thenReturn(Boolean.TRUE);
	}
	
	@Test
	public void testAuthenticate() throws EmptyCredentialsException {
		boolean actualCall = authenticatorApplication.authenticate(userName, password);
		assertTrue(actualCall);		
	}	
	
	
	@Test
	public void testVerify() throws EmptyCredentialsException {
		boolean actualCall = authenticatorApplication.authenticate(userName, password);
		assertTrue(actualCall);	
		
		//Verify that method has been called with certain parameters
		verify(authenticatorMock).authenticateUser(userName, password);
		
		//Verify that method has been called n times
		verify(authenticatorMock,times(1)).authenticateUser(userName, password);
		verify(authenticatorMock,atLeastOnce()).authenticateUser(userName, password);
		verify(authenticatorMock,atLeast(1)).authenticateUser(userName, password);
		verify(authenticatorMock,atMost(1)).authenticateUser("aa", "test");		
	}
	
	@Test(expected = EmptyCredentialsException.class)
	public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
		
		when(authenticatorApplication.authenticate("", "")).thenThrow(new EmptyCredentialsException());
		authenticatorApplication.authenticate("", "");
	}
}
