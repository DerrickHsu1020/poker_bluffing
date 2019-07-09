package poker_blufffing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class rank {

/*	private boolean ROYAL_FLUSH=false;
	private boolean STRAIGHT_FLUSH=false;
	private boolean STRAIGHT_FLUSH_WHEEL=false;
	private boolean FOUR_OF_A_KIND=false;
	private boolean FULL_HOUSE=false;
	private boolean FLUSH=false;
	private boolean STRAIGHT=false;
	private boolean WHEEL=false;
	private boolean SET=false;
	private boolean TWO_PAIR=false;
	private boolean PAIR=false;*/
	private int r=1;
	private HashSet<String> card = new HashSet<>();
	
	

	public rank(String s) {
		putcard(s);
		straightflush(this.card);
		fourofakind(this.card);
		straightflushwheel(this.card);
		royalflush(this.card);
		straightwheel(this.card);
	}
	
	
	public void putcard(String s) {
		for (int i=0;i<s.length();i++) {
			char c=s.charAt(i);
        	if ((c=='s')||(c=='d')||(c=='c')||(c=='h')) {
        		String h=""+s.charAt(i-1)+c;
        		card.add(h);
        	}
		}
	}
	
	public void royalflush(HashSet<String> card) {
		if (card.contains("Ac")&&card.contains("Kc")&&card.contains("Qc")&&card.contains("Jc")&&card.contains("Tc")) {
			this.r=12;
		}else if (card.contains("Ad")&&card.contains("Kd")&&card.contains("Qd")&&card.contains("Jd")&&card.contains("Td")) {
			this.r=12;
		}else if (card.contains("Ah")&&card.contains("Kh")&&card.contains("Qh")&&card.contains("Jh")&&card.contains("Th")) {
			this.r=12;
		}else if (card.contains("As")&&card.contains("Ks")&&card.contains("Qs")&&card.contains("Js")&&card.contains("Ts")) {
			this.r=12;
		}
	}
	public void straightflush(HashSet<String> card) {
		HashMap <Character,ArrayList<Integer>> map=new HashMap<>();
		for (String s:card) {
			char c=s.charAt(1);
			int i=0;
			if (Character.isDigit(s.charAt(0))){
				i=Character.getNumericValue(s.charAt(0));
			}else {
				char n=s.charAt(0);
				if (n=='T') {
					i=10;
				}else if(n=='J') {
					i=11;
				}else if(n=='Q') {
					i=12;		
				}else if(n=='K') {
					i=13;
				}else if(n=='A') {
					i=14;
				}					
			}
			if (!map.containsKey(c)){
				ArrayList <Integer> list=new ArrayList<>();
				list.add(i);
				map.put(c, list);
			}else {
				map.get(c).add(i);
			}
		}
		ArrayList<Integer> straight = new ArrayList<Integer>();
		for (ArrayList<Integer> list : map.values()) {
			if (list.size()>=5) {
				Collections.sort(list);
				int j=list.get(list.size()-1);
				int k=1;
				for (int i=list.size()-2;i>=0;i--) {
					if (list.get(i)+1==list.get(i+1)) {
						k++;
					}
					if (k==4) {
						this.r=11; //StraightFlush
						break;
					}
				}
				this.r=this.r>7? r:7; //Flush
				break;
			}else {
				for (int i:list) {
					if (!straight.contains(i)) {
						straight.add(i);
					}
					int k=1;
					System.out.println(straight.toString());
					if (straight.size()>=5) {
						for (int l=straight.size()-2;l>=0;l--) {
							if (straight.get(l)+1==straight.get(l+1)) {
								k++;
							}
							if (k==4) {
								this.r=this.r>6? r:6; //Straight
								break;
							}
						}
					}
				}
			}
		}
	}
	public void straightflushwheel(HashSet<String> card) {
		if (card.contains("Ac")&&card.contains("2c")&&card.contains("3c")&&card.contains("4c")&&card.contains("5c")) {
			this.r=10; //straightflushwheel
		}else if (card.contains("Ad")&&card.contains("2d")&&card.contains("3d")&&card.contains("4d")&&card.contains("5d")) {
			this.r=10; //straightflushwheel
		}else if (card.contains("Ah")&&card.contains("2h")&&card.contains("3h")&&card.contains("4h")&&card.contains("5h")) {
			this.r=10; //straightflushwheel
		}else if (card.contains("As")&&card.contains("2s")&&card.contains("3s")&&card.contains("4s")&&card.contains("5s")) {
			this.r=10; //straightflushwheel
		}
	}
    public void fourofakind(HashSet<String> card) {
    	HashMap <Character,Integer> map =new HashMap<Character,Integer>();
    	for (String s:card) {
			char c=s.charAt(0);
			System.out.print(s);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				map.replace(c, map.get(c)+1);
				if (map.get(c)==4) {
					this.r=9; //Four Of A Kind
					break;
				}
			}
			if (map.containsValue(3)&&map.containsValue(2)) {
				this.r=this.r>8? r:8; //Full House
			}else if(map.containsValue(3)){
				this.r=this.r>4? r:4; //Set
			}else if(map.containsValue(2)) {
				int count=0;
				for (int j: map.values()) {
					if (j==2) {
						count++;
					}
				}
				if (count>=2) {
					this.r=this.r>3? r:3; //Two Pairs
				}else if(count ==1) {
					this.r=this.r>2? r:2; //One Pair
				}
			}
    	}
    }
    public void straightwheel(HashSet<String> card) {
    	if (card.contains("Ac")||card.contains("Ad")||card.contains("Ah")||card.contains("As")) {
    		HashSet <Character> straight=new HashSet<>();
    		for (String s:card) {
    			char c=s.charAt(1);
    			straight.add(c);
    		}
    		if (straight.contains('A')&&straight.contains('2')&&straight.contains('3')&&straight.contains('4')&&straight.contains('5')) {
    			this.r=this.r>5? r:5;
    		}
    	}
    }
    
	public int getrank() {
        return this.r;
    }
    
}
