package poker_blufffing;

import java.awt.EventQueue;
import java.awt.Font;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class Pokerbluffing {
	private static String rank[] = {"A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"};
	JFrame frmPokerbluffing;
	private JToggleButton range;
	private JTextField textField, player, board;
	public ArrayList <String> s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokerbluffing window = new Pokerbluffing();
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
	public Pokerbluffing() {
		frmPokerbluffing = new JFrame();
		frmPokerbluffing.setTitle("PokerBluffing");
		frmPokerbluffing.setBounds(100, 100, 450, 300);
		frmPokerbluffing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokerbluffing.getContentPane().setLayout(new BorderLayout(0, 0));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel panel = new JPanel();
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(new GridLayout(13, 13, 1, 1));
		panel.setMaximumSize(new Dimension ((int) 50, (int) 50));
		frmPokerbluffing.getContentPane().add(panel, BorderLayout.CENTER);
		JPanel bottom = new JPanel();  
		bottom.setLayout(new GridLayout(0, 1, 0, 0));	
		textField = new JTextField();
		textField.setColumns(10);
		bottom.add(textField);
		frmPokerbluffing.getContentPane().add(bottom, BorderLayout.SOUTH);
		String name;
		String style;
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
					range.setBackground(Color.white);
				}else if(style=="s") {
					range.setBackground(Color.cyan);
				}else if(style=="o") {
					range.setBackground(Color.magenta);
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
				
				panel.add(range);
				}
		}

		JPanel east = new JPanel();
		frmPokerbluffing.getContentPane().add(east, BorderLayout.EAST);
		east.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel playercard = new JLabel("ENTER YOUR CARD HERE");
		playercard.setFont(font1);
		playercard.setHorizontalAlignment(SwingConstants.CENTER);
		east.add(playercard);
		JTextField player= new JTextField();
		player.setFont(font1);
		east.add(player);
		player.setColumns(10);
		  
		  JLabel community = new JLabel("ENTER THE COMMUNITY CARD HERE");
		  community.setHorizontalAlignment(SwingConstants.CENTER);
		  community.setFont(font1);
		  east.add(community);
		  JTextField board = new JTextField();
		  board.setFont(font1);
		  east.add(board);
		  board.setColumns(10);
		  JLabel result = new JLabel("");
		  result.setFont(font1);
		  east.add(result);
		  JButton enter = new JButton("ENTER");
		  enter.setFont(font1);
		  enter.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) {
					//returns();
					Deck deck=new Deck();
					String playercard=player.getText();
					String community =board.getText();
					deck.remove(playercard);
					deck.remove(community);
					double answer=deck.bluffing(s, community);
					result.setText("<html>The cold bluffing percentage is: <br>"+Double.toString(answer)+" %</html>");
			  }
		  });
		  bottom.add(enter);
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
}

