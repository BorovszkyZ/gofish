package gofish;

//import static org.junit.Assert.*;

import org.junit.Test;

public class AsztalTeszt {

	@Test
	public void test() {
		Asztal azAsztal = new Asztal(); 
		
		System.out.println("Az asztal tartalma:");
		azAsztal.printPakli();
		
		azAsztal.kever();
		System.out.println("\nAz asztal keverve:");
		azAsztal.printPakli();
		
		Lap egyLap = azAsztal.oszt();
		System.out.println("\nOsztott lap:");
		egyLap.printLap(false);
		
		System.out.println("\nOsztás után az asztal:");
		azAsztal.printPakli();
		
	}

}
