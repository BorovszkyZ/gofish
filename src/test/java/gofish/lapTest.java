package gofish;

import static org.junit.Assert.*;

import org.junit.Test;

public class lapTest {

	@Test
	public void test() {
		Lap lap1 = new Lap(200, 14);
	
		assertEquals(214, lap1.getSzin() + lap1.getErtek());
		
		lap1.printLap(true);
	}

}
