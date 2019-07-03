package poker_blufffing;
import java.util.HashSet;
public class Deck {
	private HashSet<String> deck = new HashSet<>();
		
	public Deck(){
			deck.add("As"); deck.add("Ac"); deck.add("Ad"); deck.add("Ah"); 
			deck.add("Ks"); deck.add("Kc"); deck.add("Kd"); deck.add("Kh");
			deck.add("Qs"); deck.add("Qc"); deck.add("Qd"); deck.add("Qh");
			deck.add("Js"); deck.add("Jc"); deck.add("Jd"); deck.add("Jh");
			deck.add("Ts"); deck.add("Tc"); deck.add("Td"); deck.add("Th");
			deck.add("9s"); deck.add("9c"); deck.add("9d"); deck.add("9h");
			deck.add("8s"); deck.add("8c"); deck.add("8d"); deck.add("8h");
			deck.add("7s"); deck.add("7c"); deck.add("7d"); deck.add("7h");
			deck.add("6s"); deck.add("6c"); deck.add("6d"); deck.add("6h");
			deck.add("5s"); deck.add("5c"); deck.add("5d"); deck.add("5h");
			deck.add("4s"); deck.add("4c"); deck.add("4d"); deck.add("4h");
			deck.add("3s"); deck.add("3c"); deck.add("3d"); deck.add("3h");
			deck.add("2s"); deck.add("2c"); deck.add("2d"); deck.add("2h");
		}
	public void remove(String s) {
		String card="";
		for(int i=0; i<s.length();i++) {
	       	char c=s.charAt(i);
	       	if ((c=='s')||(c=='d')||(c=='c')||(c=='h')) {
	       		card=card+s.charAt(i-1)+c;
	       		if (deck.contains(card)) {
	       			deck.remove(card);
	       			card="";
	       		}
	       	}
	    }
		 
	}
	public String getdeck() {
		return deck.toString();
	}
}
