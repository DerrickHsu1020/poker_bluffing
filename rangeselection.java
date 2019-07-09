package poker_blufffing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class rangeselection {
	private static String rank[] = {"A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"};
	JFrame frmPokerbluffing;
	private JToggleButton range;
	private HashMap<String, JToggleButton> pbByName = new HashMap<String, JToggleButton>();
	private JTextField textField, player, board;
	public ArrayList <String> s;
	private JLabel result;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rangeselection window = new rangeselection();
					window.frmPokerbluffing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rangeselection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokerbluffing = new JFrame();
		frmPokerbluffing.setTitle("PokerBluffing");
		frmPokerbluffing.setBounds(100, 100, 450, 300);
		frmPokerbluffing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokerbluffing.getContentPane().setLayout(new BorderLayout(0, 0));
		//creategrid();
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(new GridLayout(13, 13, 1, 1));
		panel.setMaximumSize(new Dimension ((int) 50, (int) 50));
		JPanel panel_1 = new JPanel();
		  
		String name;
		String style;
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		ArrayList <String> s=new ArrayList<>();
		for ( int i = 0; i < rank.length; i++ ) {
			for ( int j = 0; j < rank.length; j++ ) {
				if ( i == j ) {
					name = rank[i] + rank[j];
		    		style = "pair";
				} else if ( i < j ) {
					name = rank[i] + rank[j] + "s";
					style = "s";
				} else { // if ( i > j ) 
					name = rank[j] + rank[i] + "o";
					style = "o";
				}
				range = new JToggleButton(name);
				if (style == "pair") {
				}
				ItemListener itemListener = new ItemListener() { 
					  
			            // itemStateChanged() method is nvoked automatically 
			            // whenever you click or unlick on the Button. 
					public void itemStateChanged(ItemEvent itemEvent) { 
			  
			                // event is generated in button 
						int state = itemEvent.getStateChange(); 
			  
			                // if selected print selected in console 
						if (state == ItemEvent.SELECTED) { 
							String r=((AbstractButton) itemEvent.getSource()).getLabel();
			          		s.add(r);
			          		textField.setText(s.toString());
						} else { 
			                String r=((AbstractButton) itemEvent.getSource()).getLabel();
			               	s.remove(s.indexOf(r));			                	
			               	textField.setText(s.toString());
						} 
					} 
				}; 
				range.addItemListener(itemListener);
				pbByName.put(name, range);
				panel.add(range);
				}
		}
		frmPokerbluffing.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		frmPokerbluffing.getContentPane().add(panel, BorderLayout.CENTER);
		JPanel panel_2 = new JPanel();
		frmPokerbluffing.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel playercard = new JLabel("ENTER YOUR CARD HERE");
		playercard.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(playercard);
		JTextField player= new JTextField();
		panel_2.add(player);
		player.setColumns(10);
		  
		  JLabel community = new JLabel("ENTER THE COMMUNITY CARD HERE");
		  community.setHorizontalAlignment(SwingConstants.CENTER);
		  panel_2.add(community);
		  
		  JTextField board = new JTextField();
		  panel_2.add(board);
		  board.setColumns(10);
		  
		  JLabel result = new JLabel("");
		  panel_2.add(result);
		  JButton enter = new JButton("ENTER");
		  enter.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) {
					//returns();
					Deck deck=new Deck();
					String playercard=player.getText();
					String community =board.getText();
					deck.remove(playercard);
					deck.remove(community);
					double answer=deck.bluffing(s, community);
					result.setText("The bluffing percentage of opponent is: "+Double.toString(answer)+" %");
			  }
		  });
		  panel_1.add(enter);
	}
	private void creategrid() {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(new GridLayout(13, 13, 1, 1));
		panel.setMaximumSize(new Dimension ((int) 50, (int) 50));
		JPanel panel_1 = new JPanel();
		  
		String name;
		String style;
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		ArrayList <String> s=new ArrayList<>();
		for ( int i = 0; i < rank.length; i++ ) {
			for ( int j = 0; j < rank.length; j++ ) {
				if ( i == j ) {
					name = rank[i] + rank[j];
		    		style = "pair";
				} else if ( i < j ) {
					name = rank[i] + rank[j] + "s";
					style = "s";
				} else { // if ( i > j ) 
					name = rank[j] + rank[i] + "o";
					style = "o";
				}
				range = new JToggleButton(name);
				if (style == "pair") {
				}
				ItemListener itemListener = new ItemListener() { 
					  
			            // itemStateChanged() method is nvoked automatically 
			            // whenever you click or unlick on the Button. 
					public void itemStateChanged(ItemEvent itemEvent) { 
			  
			                // event is generated in button 
						int state = itemEvent.getStateChange(); 
			  
			                // if selected print selected in console 
						if (state == ItemEvent.SELECTED) { 
							String r=((AbstractButton) itemEvent.getSource()).getLabel();
			          		s.add(r);
			          		textField.setText(s.toString());
						} else { 
			                String r=((AbstractButton) itemEvent.getSource()).getLabel();
			               	s.remove(s.indexOf(r));			                	
			               	textField.setText(s.toString());
						} 
					} 
				}; 
				range.addItemListener(itemListener);
				pbByName.put(name, range);
				panel.add(range);
				}
		}
		frmPokerbluffing.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		JButton enter = new JButton("ENTER");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//returns();
				Deck deck=new Deck();
				String playercard =player.getText();
				String community =board.getText();
				System.out.println(playercard);
				System.out.println(community);
				deck.remove(playercard);
				deck.remove(community);
				double answer=deck.bluffing(s, community);
			}
		});
		panel_1.add(enter);
		frmPokerbluffing.getContentPane().add(panel, BorderLayout.CENTER);
		JPanel panel_2 = new JPanel();
		frmPokerbluffing.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel playercard = new JLabel("ENTER YOUR CARD HERE");
		playercard.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(playercard);
		JTextField player= new JTextField();
		panel_2.add(player);
		player.setColumns(10);
		  
		  JLabel community = new JLabel("ENTER THE COMMUNITY CARD HERE");
		  community.setHorizontalAlignment(SwingConstants.CENTER);
		  panel_2.add(community);
		  
		  JTextField board = new JTextField();
		  panel_2.add(board);
		  board.setColumns(10);
		  
		  JLabel result = new JLabel("");
		  panel_2.add(result);
	}
/*  	public void itemStateChanged(ItemEvent arg0) {
  		int state = arg0.getStateChange();
  		if (state == ItemEvent.SELECTED) { 
  			String r=range.getLabel()+",";
  			s.add(r);
  			textField.setText(s.toString());
        } 
        else {
        	String r=range.getLabel()+",";
        	s.remove(s.indexOf(r));
        	textField.setText(s.toString());
        } 
  	}*/
  	
	private void determineRanges() {
		  String res = "";
		  JToggleButton tb;
		  String       name;

		  // Get pairs
		  boolean active         = false;
		  String  activeName     = null;
		  String  lastActiveName = null;
		  boolean endSignal      = false;
		  for ( int i = 0; i < rank.length; i++ ) {
			  name = rank[i] + rank[i];
			  tb = pbByName.get(name);
			  if ( tb.isEnabled() ) {
				  if (!active) {
					  active = true;
					  activeName = name;
				  } 
				  lastActiveName = name;
			  } else {
				  endSignal = true;
			  }
			  if ( i == rank.length-1 )
				  endSignal = true;

			  if (endSignal && active) { 
				  if ( activeName.equals(lastActiveName) ) {
					  res += "," + activeName;
				  } else if ( activeName.equals("AA")) {
					  res += "," + lastActiveName + "+";
				  } else {
					  res += "," + activeName + "-" + lastActiveName;
				  }
				  active         = false;
				  activeName     = null;
				  lastActiveName = null;
			  }
			  endSignal      = false;
		  }
	}
	public void returns() {
		Deck deck=new Deck();
		String playercard =player.getText();
		String community =board.getText();
		System.out.println(playercard);
		System.out.println(community);
		deck.remove(playercard);
		deck.remove(community);
		double answer=deck.bluffing(s, community);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

