package gofish;

import java.util.Scanner;

public class Jatekos extends Pakli {

	private int JatekosSzam;
	private boolean GepiJatekos;
	
	public Jatekos(int szam, boolean gepi) {
		JatekosSzam = szam;
		GepiJatekos = gepi;
		darab = 0;
	}
	
	public int getJatekosSzam() {
		return JatekosSzam;
	}
	
	public boolean getGepiJatekos() {
		return GepiJatekos;
	}
	
	public void lapotKap(Lap ujLap) {
		if (ujLap != null) {
			lapok[darab++] = ujLap;
		}
		
	}
	
	private void lapotTorol(int index) {
		for(int i = index+1; i < darab; i++) {
			lapok[i-1]=lapok[i];
		}
	}
	
	public Lap[] lapotLead(int torlendoErtek) {
		Lap[] toroltLapok = new Lap[3];
		int i = 0;
		int db = -1;
		
		while (i < darab) {
			if (lapok[i].getErtek() == torlendoErtek) {
				db++;
				toroltLapok[db] = new Lap(lapok[i].getSzin(), torlendoErtek);
				lapotTorol(i);
				darab--;
			} else {
				i++;
			}
		}
		
		return db >= 0 ? toroltLapok : null;
	}
	
	public int lapotKer() {
		int kertLap = 0;
		int db = 0;
		int[] kartyak = new int[13];
    	
		if (GepiJatekos) {
			kartyak = sorozat();
			
	    	for(int i = 12 ; i >= 0; i--) {
	    		if (kartyak[i] > db && kartyak[i] < 4) {
	    			db = kartyak[i];
	    			kertLap = i + 2;
	    			//System.out.println("A kért lap(ok): "+(i+2));
	    		}
	    	}			
		} else {
			System.out.println("Milyen érékû lapot kérünk? (2-14, 14 = ÁSZ...)");
	        Scanner keyboard = new Scanner(System.in);

	        kertLap = keyboard.nextInt();

	        keyboard.nextLine();

			//keyboard.close();
		}

		System.out.println("A kért lap értéke: "+kertLap);
    	return kertLap;
	}
	
	public Lap xdikLap(int x) {
		return lapok[x];
	}
}
