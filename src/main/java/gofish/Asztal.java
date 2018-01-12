package gofish;

public class Asztal extends Pakli {
	
	// constructor
	public Asztal() {
	
		for(int i = 1; i <= 4; i++) {
			for(int j = 2; j <= 14; j++) {
				lapok[darab++] = new Lap(i * 100, j);
			}
		}
			
	}

	public Lap oszt() {
		if (darab > 0) {
			return lapok[--darab];
		} else {
			System.out.println("A pakli üres!");
			return null;
		}
		
	}
	
    public void kever() {
    	int n; 
    	
    	for(int i = 0; i < 51; i++) {
    		n = (int)((52) * Math.random());
    		Lap tempLap = lapok[n];
    		lapok[n] = lapok[i];
    		lapok[i] = tempLap;
    	}
    }

}
