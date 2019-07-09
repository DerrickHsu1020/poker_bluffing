package poker_blufffing;
import java.util.ArrayList;
import java.util.HashSet;
public class Deck {
	private HashSet<String> deck = new HashSet<>();
	private static String colour[] = {"s", "h", "d", "c"};
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
	
	public double bluffing(ArrayList <String> range, String community) {
		int bluffing=0;
		int total=0;
		ArrayList <String> totalrange;
		rank com=new rank(community);
		for (int i=0;i<range.size();i++) {
			String s = range.get(i);
			if (s.charAt(0)==s.charAt(1)) {
				char c=s.charAt(0);
				ArrayList <String> combination = new ArrayList<>();
				for (int j=0;j<colour.length;j++) {
					String card=c+colour[j];
					if (deck.contains(card)) {
						combination.add(card);
					}
				}
				if (combination.size()>1) {
					for (int j=0;j<combination.size()-1;j++) {
						for (int k=0;k<combination.size();k++) {
							String hand=combination.get(j)+combination.get(k);
							rank r=new rank(hand+community);
							if (com.getrank()==r.getrank()&&com.getrank()<5) {
								bluffing++;
								total++;
							}else {
								total++;
							}
						}
					}
				}
			}else if(s.charAt(2)=='s') {
				char c1=s.charAt(0);
				char c2=s.charAt(1);
				for (int j=0;j<colour.length;j++) {
					String card =""+c1+colour[j];
					String card2=""+c2+colour[j];
					if (deck.contains(card)&&deck.contains(card2)) {
						String hand=card+card2;
						rank r=new rank(hand+community);
						if (com.getrank()==r.getrank()&&com.getrank()<5) {
							bluffing++;
							total++;
						}else {
							total++;
						}
					}
				}
			}else if(s.charAt(2)=='o') {
				char c1=s.charAt(0);
				char c2=s.charAt(1);
				ArrayList <String> combination = new ArrayList<>();
				for (int j=0;j<colour.length;j++) {
					String card =""+c1+colour[j];
					String card2=""+c2+colour[j];
					if (deck.contains(card)) 
						combination.add(card);
					if (deck.contains(card2))
						combination.add(card2);
				}
				if (combination.size()>1) {
					for (int j=0;j<combination.size()-1;j++) {
						for (int k=0;k<combination.size();k++) {
							String card=combination.get(j);
							String card2=combination.get(k);
							if (card.charAt(1)!=card2.charAt(1)) {
								String hand=card+card2;
								rank r=new rank(hand+community);
								if (com.getrank()==r.getrank()&&com.getrank()<5) {
									bluffing++;
									total++;
								}else {
									total++;
								}
							}
						}
					}
				}
			}
		}
		return (double) bluffing*100/total;
	}
}
