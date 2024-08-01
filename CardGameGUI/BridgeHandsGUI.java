package Homework4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;


public class BridgeHandsGUI {
    final static int NUM_HANDS = 4;
    final static int HAND_SIZE = 13;
    static JFrame a;
    static JLabel b;
  
    public static void main(String[] args) {

        CardDeck deck = new CardDeck();
        deck.shuffle();
        a = new JFrame("label");
        b = new JLabel();
        
        SortedABList<Card> player1 = new SortedABList<Card>(Card.bridgeComparator());
        SortedABList<Card> player2 = new SortedABList<Card>(Card.bridgeComparator());
        SortedABList<Card> player3 = new SortedABList<Card>(Card.bridgeComparator());
        SortedABList<Card> player4 = new SortedABList<Card>(Card.bridgeComparator());

        
        for(int index = 0; index < 13; index ++){
            player1.add(deck.nextCard());
            player2.add(deck.nextCard());
            player3.add(deck.nextCard());
            player4.add(deck.nextCard());
        }

          showAsCLI(player1,player2,player3,player4);
          showAsGUI(player1,player2,player3,player4);
   
    }
  
  private static void showAsCLI(SortedABList<Card> player1,
                           SortedABList<Card> player2,
                           SortedABList<Card> player3,
                           SortedABList<Card> player4){
    
        for(int index = 12; index >=0; index --){
       
            System.out.println(player1.get(index) + "	" + player2.get(index) + "	" + player3.get(index) + "	" + player4.get(index));

        }
  }
   static void showAsGUI(SortedABList<Card> player1,
                           SortedABList<Card> player2,
                           SortedABList<Card> player3,
                           SortedABList<Card> player4){
	 
        JFrame frame = new JFrame("Bridge");
        JPanel panel = new JPanel(new GridLayout(0, HAND_SIZE+1));
        
        a = new JFrame("label");
        b = new JLabel();
        panel.add(b);
        int sum = 0;
        int heartCount = 0;
        int spadeCount = 0;
        int diamondCount = 0;
        int clubsCount = 0;
        for(int index = 12; index >=0; index --){
            Card card = player1.get(index);
            ImageIcon imageIcon = card.getImage();
			Image image = imageIcon.getImage(); 
			Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);  
			imageIcon = new ImageIcon(newimg);    
            JLabel label = new JLabel(imageIcon);
            panel.add(label);
            if(card.getSuit() == card.suit.Heart) {
            	heartCount++;
            }
            else if(card.getSuit() == card.suit.Spade) {
            	spadeCount++;
            } 
            else if(card.getSuit() == card.suit.Diamond) {
            	diamondCount++;
            }
            else  {
            	clubsCount++;
            }
            int value = (card.getRank().ordinal() - Card.Rank.Ten.ordinal());
            if ( value <0) {
        	   value =0;
            }
            sum = sum + value;
        	} 
        	if (heartCount - 4 > 0) {
        		sum = sum + heartCount -4;
        	}
        	if (spadeCount - 4 > 0) {
        		sum = sum + spadeCount -4;
        	}
        	if (diamondCount - 4 > 0) {
        		sum = sum + diamondCount -4;
        	}
        	if (clubsCount - 4 > 0) {
        		sum = sum + clubsCount -4;
        	}
        	b.setText(sum + "");
         
        a = new JFrame("label");
        b = new JLabel();
        panel.add(b);
        sum = 0;
        heartCount = 0;
        spadeCount = 0;
        diamondCount = 0;
        clubsCount = 0;      
        for(int index = 12; index >=0; index --){
            Card card = player2.get(index);
            ImageIcon imageIcon = card.getImage();
			Image image = imageIcon.getImage(); 
			Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); 
			imageIcon = new ImageIcon(newimg); 
            JLabel label = new JLabel(imageIcon);
            panel.add(label);
            if(card.getSuit() == card.suit.Heart) {
            	heartCount++;
            }
            else if(card.getSuit() == card.suit.Spade) {
            	spadeCount++;
            } 
            else if(card.getSuit() == card.suit.Diamond) {
            	diamondCount++;
            }
            else  {
            	clubsCount++;
            }
            int value = (card.getRank().ordinal() - Card.Rank.Ten.ordinal());
            if ( value <0) {
        	   value =0;
            }
            sum = sum + value;
        	} 
        	if (heartCount - 4 > 0) {
        		sum = sum + heartCount -4;
        	}
        	if (spadeCount - 4 > 0) {
        		sum = sum + spadeCount -4;
        	}
        	if (diamondCount - 4 > 0) {
        		sum = sum + diamondCount -4;
        	}
        	if (clubsCount - 4 > 0) {
        		sum = sum + clubsCount -4;
        	}
        	b.setText(sum + "");
  
        a = new JFrame("label");
        b = new JLabel();
        panel.add(b);
        sum = 0;
        heartCount = 0;
        spadeCount = 0;
        diamondCount = 0;
        clubsCount = 0;
        for(int index = 12; index >=0; index --){
            Card card = player3.get(index);
            ImageIcon imageIcon = card.getImage();
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); 
			imageIcon = new ImageIcon(newimg);  
            JLabel label = new JLabel(imageIcon);
            panel.add(label);
            if(card.getSuit() == card.suit.Heart) {
            	heartCount++;
            }
            else if(card.getSuit() == card.suit.Spade) {
            	spadeCount++;
            } 
            else if(card.getSuit() == card.suit.Diamond) {
            	diamondCount++;
            }
            else  {
            	clubsCount++;
            }
            int value = (card.getRank().ordinal() - Card.Rank.Ten.ordinal());
            if ( value <0) {
        	   value =0;
            }
            sum = sum + value;
        	} 
        	if (heartCount - 4 > 0) {
        		sum = sum + heartCount -4;
        	}
        	if (spadeCount - 4 > 0) {
        		sum = sum + spadeCount -4;
        	}
        	if (diamondCount - 4 > 0) {
        		sum = sum + diamondCount -4;
        	}
        	if (clubsCount - 4 > 0) {
        		sum = sum + clubsCount -4;
        	}
        	b.setText(sum + "");
 
        a = new JFrame("label");
        b = new JLabel();
        panel.add(b);
        sum = 0;
        heartCount = 0;
        spadeCount = 0;
        diamondCount = 0;
        clubsCount = 0;
        for(int index = 12; index >=0; index --){
            Card card = player4.get(index);
            ImageIcon imageIcon = card.getImage();
			Image image = imageIcon.getImage();  
			Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);   
			imageIcon = new ImageIcon(newimg);  
            JLabel label = new JLabel(imageIcon);
            panel.add(label);
            if(card.getSuit() == card.suit.Heart) {
            	heartCount++;
            }
            else if(card.getSuit() == card.suit.Spade) {
            	spadeCount++;
            } 
            else if(card.getSuit() == card.suit.Diamond) {
            	diamondCount++;
            }
            else  {
            	clubsCount++;
            }
            int value = (card.getRank().ordinal() - Card.Rank.Ten.ordinal());
            if ( value <0) {
        	   value =0;
            }
            sum = sum + value;
        	} 
        	if (heartCount - 4 > 0) {
        		sum = sum + heartCount -4;
        	}
        	if (spadeCount - 4 > 0) {
        		sum = sum + spadeCount -4;
        	}
        	if (diamondCount - 4 > 0) {
        		sum = sum + diamondCount -4;
        	}
        	if (clubsCount - 4 > 0) {
        		sum = sum + clubsCount -4;
        	}
        	b.setText(sum + "");
       
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
  }
}