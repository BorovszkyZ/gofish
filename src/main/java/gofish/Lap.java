package gofish;

public class Lap {
	private int szin; // 100 = PIKK, 200 = KÖR, 300 = KÁRÓ, 400 = TREFF
	private int ertek; // 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 = BUBI, 12 = DÁMA, 13 = KIRÁLY, 14 = ÁSZ
	
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
		
		String lapStr = hosszu ? "A kártya színe: " : "";
		
		if (szin < 200) {
			lapStr += hosszu ? "PIKK értéke:" : "PI" ;
		} else if (szin < 300) {
			lapStr += hosszu ? "KÖR értéke:" : "KÖ" ;
		} else if (szin < 400) {
			lapStr += hosszu ? "KÁRÓ értéke:" : "KÁ" ;
		} else lapStr += hosszu ? "TREFF értéke:" : "TR" ;
		
		switch (ertek) {
		case 11: lapStr += " BUBI" ;
		         break;
		case 12: lapStr += " DÁMA" ;
                 break;
		case 13: lapStr += " KIRÁLY" ;
                 break;	
		case 14: lapStr += " ÁSZ" ;
                 break;    
        default: lapStr += " " + ertek ;
        }
		
		System.out.println(lapStr);
	}

}
