package gofish;

public class Lap {
	private int szin; // 100 = PIKK, 200 = K�R, 300 = K�R�, 400 = TREFF
	private int ertek; // 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 = BUBI, 12 = D�MA, 13 = KIR�LY, 14 = �SZ
	
	public Lap(int szin, int ertek) {
		this.szin = szin;
		this.ertek = ertek;
	}
	
	public int getSzin() {
		return this.szin;
	}
	
	public int getErtek() {
		return this.ertek;
	}
	
	public void printLap(Boolean hosszu) {
		
		String lapStr = hosszu ? "A k�rtya sz�ne: " : "";
		
		if (szin < 200) {
			lapStr += hosszu ? "PIKK �rt�ke:" : "PI" ;
		} else if (szin < 300) {
			lapStr += hosszu ? "K�R �rt�ke:" : "K�" ;
		} else if (szin < 400) {
			lapStr += hosszu ? "K�R� �rt�ke:" : "K�" ;
		} else lapStr += hosszu ? "TREFF �rt�ke:" : "TR" ;
		
		switch (ertek) {
		case 11: lapStr += " BUBI" ;
		         break;
		case 12: lapStr += " D�MA" ;
                 break;
		case 13: lapStr += " KIR�LY" ;
                 break;	
		case 14: lapStr += " �SZ" ;
                 break;    
        default: lapStr += " " + ertek ;
        }
		
		System.out.println(lapStr);
	}

}
