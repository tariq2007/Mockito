package com.onstar.gm.service.mockito;

import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoExample {

	@Test
	public void test() {
		List<String> mockList = Mockito.mock(List.class);
		mockList.add("First");
		
		System.out.println(mockList.get(0));
		mockList.add("First");
		when(mockList.get(0)).thenReturn("Mockito");
		when(mockList.get(1)).thenReturn("JCG");
		assertEquals("Mockito", mockList.get(0));
		assertEquals("JCG", mockList.get(1));
		
	}
}
