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
	    Jatekosok[0] = new Jatekos(0, false); //nem gépi játékos
	    
	    for(int i = 1; i < 4; i++) {
	    	Jatekosok[i] = new Jatekos(i, true); //gépi játékosok
	    }
	     
	    for(int i = 0; i < 4; i++) {
	    	for(int j = 0; j < 7; j++) {
	    		Jatekosok[i].lapotKap(azAsztal.oszt());
	    	}
	    }
	    
	    while (azAsztal.darab > 0) {
	    	for(int i = 0; i < 4; i++) {
	    		// lapot kérünk valakitõl, de kitõl?
    			do {
    				if (Jatekosok[i].getGepiJatekos()) {
    					//gépi játékos
    					n = (int)((4) * Math.random());
    					
	    		    } else {
	    		    	Scanner input = new Scanner(System.in);
	    		    	System.out.println("Jelenlegi kártyáink:");
	    		    	Jatekosok[i].printPakli();
	    		    	System.out.println("Melyik játékostól kérünk lapot: (1-3) ");
	    		    	n = 1;
	    		    	if(input.hasNextInt()) {
	    		    	    n = input.nextInt();
	    		    	}
	    		    	//input.close();
	    		    }

	    		} while (n == i);
    			
    			if (Jatekosok[i].getGepiJatekos()) {
    				//gépi játékos lapot kért
    				System.out.println(i+" játékos lapot kér "+n+" játékostól");
    			}
	    		//milyen lapot kérünk?
    			lapertek = Jatekosok[i].lapotKer();
    			
    			//System.out.println("Megkérdezett játékos:");
    			//Jatekosok[n].printPakli();
    			
    			lapok = Jatekosok[n].lapotLead(lapertek);
    			
    			//System.out.println("Leadott lapokkal:");
    			//Jatekosok[n].printPakli();
    			
    			if (lapok != null) {
    				//a kért játékosnál volt ilyan lap
    				System.out.println("A kapott lapok:");
    				for(int j = 0; lapok[j] != null; j++) {
    					 lapok[j].printLap(false);
      				     Jatekosok[i].lapotKap(lapok[j]);
    				}
    			} else {
    				huzottLap = azAsztal.oszt();
    				if(huzottLap == null) {
    					System.out.println("Játék vége...");
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
	    
	    System.out.println("A nyertes játékos: "+Jatekosok[x].getJatekosSzam());
	    System.out.println("Az összegyûjtött sorok");
	    Jatekosok[x].teljesSorozatDb(true);
	    
	    System.out.println("Játékosok kártyái:");
	    for(int i = 0; i < 4; i++) {
	    	System.out.println("Játékos "+i);
	    	Jatekosok[i].printPakli();
	    }
	    
	}
	
	public static void main(String[] args) {
       (new Vezerlo()).indit();       
	}

}
