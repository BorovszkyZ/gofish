package gofish;

import java.util.Scanner;

public class Vezerlo {

	public void indit() {
		Asztal azAsztal = new Asztal();
	    Jatekos[] Jatekosok = new Jatekos[4];
	    Lap[] lapok = null;
	    Lap huzottLap;
	    int n = 0;
	    int lapertek;
	    int maxsor = 0;
	    int x = 0;
	    
	    azAsztal.kever();
	    Jatekosok[0] = new Jatekos(0, false); //nem g�pi j�t�kos
	    
	    for(int i = 1; i < 4; i++) {
	    	Jatekosok[i] = new Jatekos(i, true); //g�pi j�t�kosok
	    }
	     
	    for(int i = 0; i < 4; i++) {
	    	for(int j = 0; j < 7; j++) {
	    		Jatekosok[i].lapotKap(azAsztal.oszt());
	    	}
	    }
	    
	    while (azAsztal.darab > 0) {
	    	for(int i = 0; i < 4; i++) {
	    		// lapot k�r�nk valakit�l, de kit�l?
    			do {
    				if (Jatekosok[i].getGepiJatekos()) {
    					//g�pi j�t�kos
    					n = (int)((4) * Math.random());
    					
	    		    } else {
	    		    	Scanner input = new Scanner(System.in);
	    		    	System.out.println("Jelenlegi k�rty�ink:");
	    		    	Jatekosok[i].printPakli();
	    		    	System.out.println("Melyik j�t�kost�l k�r�nk lapot: (1-3) ");
	    		    	n = 1;
	    		    	if(input.hasNextInt()) {
	    		    	    n = input.nextInt();
	    		    	}
	    		    	//input.close();
	    		    }

	    		} while (n == i);
    			
    			if (Jatekosok[i].getGepiJatekos()) {
    				//g�pi j�t�kos lapot k�rt
    				System.out.println(i+" j�t�kos lapot k�r "+n+" j�t�kost�l");
    			}
	    		//milyen lapot k�r�nk?
    			lapertek = Jatekosok[i].lapotKer();
    			
    			//System.out.println("Megk�rdezett j�t�kos:");
    			//Jatekosok[n].printPakli();
    			
    			lapok = Jatekosok[n].lapotLead(lapertek);
    			
    			//System.out.println("Leadott lapokkal:");
    			//Jatekosok[n].printPakli();
    			
    			if (lapok != null) {
    				//a k�rt j�t�kosn�l volt ilyan lap
    				System.out.println("A kapott lapok:");
    				for(int j = 0; lapok[j] != null; j++) {
    					 lapok[j].printLap(false);
      				     Jatekosok[i].lapotKap(lapok[j]);
    				}
    			} else {
    				huzottLap = azAsztal.oszt();
    				if(huzottLap == null) {
    					System.out.println("J�t�k v�ge...");
    				} else {
    				    System.out.println("Huzott lap:");
    				    huzottLap.printLap(false);
    				    Jatekosok[i].lapotKap(huzottLap);
    				}
    			}
	    		
	    	}
	    }
	    
	    n = 0;
	    
	    for(int i = 0; i < 4; i++) {
	    	n = Jatekosok[i].teljesSorozatDb(false);
	    	if (n > maxsor) {
	    		maxsor = n;
	    		x = i;
	    	}
	    	//System.out.println(maxsor);
	    }
	    
	    System.out.println("A nyertes j�t�kos: "+Jatekosok[x].getJatekosSzam());
	    System.out.println("Az �sszegy�jt�tt sorok");
	    Jatekosok[x].teljesSorozatDb(true);
	    
	    System.out.println("J�t�kosok k�rty�i:");
	    for(int i = 0; i < 4; i++) {
	    	System.out.println("J�t�kos "+i);
	    	Jatekosok[i].printPakli();
	    }
	    
	}
	
	public static void main(String[] args) {
       (new Vezerlo()).indit();       
	}

}
