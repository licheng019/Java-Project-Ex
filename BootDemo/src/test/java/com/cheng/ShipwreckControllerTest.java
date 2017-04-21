package com.cheng;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import com.cheng.controller.ShipwreckController;
import com.cheng.model.Shipwreck;
import com.cheng.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testShipwreckGet() {
		Shipwreck wreck = new Shipwreck();
		wreck.setId(2l);
		when(shipwreckRepository.saveAndFlush(wreck)).thenReturn(wreck);
		assertEquals(2l,wreck.getId().longValue());
		
	}
}
