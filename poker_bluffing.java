package poker_blufffing;
import java.util.HashMap;
import java.util.Scanner;
public class poker_bluffing{

	public static void main(String[] args) {
		Deck deck=new Deck();
		String player = playercard(); 
		String community = community();
        player=player+community;
        deck.remove(player);
        rank players=new rank(player);
        System.out.println(players.getrank());
	}
	
	public static String playercard() {
		int card =2;
		String hand="";
        System.out.println("Please Enter Your Hand"); // String Format Example "As 8d"
    	String s=new Scanner(System.in).nextLine();
        boolean b=false;
        while (b==false) {       	
        	try {
        		if (s.length()<6){        			
        	        for(int i=0; i<s.length();i++) {
        	        	char c=s.charAt(i);
        	        	if ((c=='s')||(c=='d')||(c=='c')||(c=='h')) {
        	        		hand=hand+s.charAt(i-1)+c;
        	        	}
        	        }
        		}
        		b=true;
        	}catch(Exception e){
        		System.out.println("Please Enter Correct Format:");
        	}
        }
        return hand;
	}
	
	public static String community() {
		String hand="";
        System.out.println("Please Enter Community Cards"); // String Format Example "7d 8s 5c Ac Ks"
    	String s=new Scanner(System.in).nextLine();
        boolean b=false;
        while (b==false) {       	
        	try {
        		if (s.length()<16){        			
        	        for(int i=0; i<s.length();i++) {
        	        	char c=s.charAt(i);
        	        	if ((c=='s')||(c=='d')||(c=='c')||(c=='h')) {
        	        		hand=hand+s.charAt(i-1)+c;
        	        	}
        	        }
        	    	b=true;
        		}
        	}catch(Exception e){
        		System.out.println("Please Enter Correct Format:");
        	}
        }
        return hand;
	}
	

}
