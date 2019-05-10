package uroborosGameStudio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.ActorWrapper;

public class ActorWrapperTest {

	ActorWrapper actor;

	ActorWrapper pepe;
	
	@Before
	public void setUp() {
		this.actor = new ActorWrapper("Actor0", "kids.png", 12, 15, 59, 89);

		this.pepe = mock(ActorWrapper.class);
	}

	@Test
	public void testCreateActorWithName() 
	{
		assertEquals("Actor0", actor.getName());
	}

	@Test
	public void testEditedNameDoNothing() {
		doNothing().when(pepe).setName(isA(String.class));
		pepe.setName("pepe");
//		when(pepe.getName()).thenReturn("pepe");
		
		verify(pepe).setName("pepe");
		
		assertNotNull(pepe);
		assertEquals(null, this.pepe.getName());
//		assertTrue("      " == null); //no es lo mismo
	}
	
	@Test(expected = RuntimeException.class)
	public void testMockSetNameEmpty() {
		doThrow().when(pepe).setName(isA(String.class));
		
		pepe.setName("");
		assertEquals("qwqwfkejnrfkwejnf", this.pepe.getName());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetNameEmpty() {
		this.actor.setName("");
		
		assertEquals("qwdthrtewwewe", actor.getName());
	}
	
	@Test
	public void testSetNewNameDoAnswer() {
		doAnswer((i)->{
			assertTrue("Alan".equals(i.getArgument(0)));
			return null;
		}).when(pepe).setName(anyString());
		
		when(pepe.getName()).thenReturn("Alan");
		
		pepe.setName("Alan");
		assertEquals("Alan", pepe.getName());
	}
	
	@Test
	public void testSetPosition() {
		Point pino = new Point(45, 89);
		actor.setPosition(pino.x, pino.y);
		
		assertEquals(pino, actor.point);
	}
}
