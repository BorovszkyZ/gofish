package gofish;

public class Pakli {
	protected Lap[] lapok = new Lap[52];
	
	protected int darab = 0;
		
	public void printPakli() {
		for(int i = 0; i < darab ; i++) {
			lapok[i].printLap(false);
		}
	}
	
    public Lap printNextLap() {
    	lapok[darab-1].printLap(false);
    	return lapok[darab-1];
    }
    
    public int teljesSorozatDb(boolean kiir) {
    	int[] lapdb = sorozat();
    	int teljesdb = 0;
    	String ertek;
    	
    	for(int i = 0; i < 13; i++) {
    		teljesdb += lapdb[i] == 4 ? 1 : 0;
    		if (kiir && lapdb[i] == 4) {
    			switch (i+2) {
    			case 11: 
    				ertek = "BUBI";
                    break;
    			case 12:
    				ertek = "DÁMA";
    				break;
    			case 13:
    				ertek = "KIRÁLY";
    				break;
    			case 14:
    				ertek = "ÁSZ";
    				break;
    			default:
    				ertek = "" + (i+2);
    			}
    			System.out.println(ertek);
    		}
    	}
    		    	
    	return teljesdb;
    }
    
    public int[] sorozat() {
    	int[] ertekek = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    	
    	for(int i = 0; i < darab; i++) {
    		ertekek[lapok[i].getErtek() % 100 - 2]++;
    	}
    		    	
    	return ertekek;
    }
    
}
