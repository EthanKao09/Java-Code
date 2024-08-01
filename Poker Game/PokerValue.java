package Exam1.Problem1;


import java.util.*;  

public class PokerValue{
    private String bestRank  = "High_Card";
    private ArrayList <Card> hand = new ArrayList<Card>();

    public PokerValue(){
        CardDeck cards = new CardDeck();
        cards.shuffle();
        for(int i = 0; i<5; i++)
            hand.add(cards.nextCard());
        Collections.sort(hand);  
        bestRank = findRank();
    }
    
    public PokerValue(Card[] cards){
        for(int i = 0; i< cards.length; i++)
            hand.add(cards[i]);
        Collections.sort(hand);  
        bestRank = findRank();
    } 
    
    public Object[] toArray(){
        Object[] result = new Object[6];
        result[0] = bestRank;
        for (int i = 0; i < hand.size(); i++){
            result[i+1] = hand.get(i);
        }
        return result;
    } 
    
    
    public String toString(){
        Object [] list = toArray();
        String result = list[0] + ":	";
        for(int i=1; i<list.length; i++)
            result =  result + list[i].toString() + "	";
        return result;
    }
    
    private String findRank(){
        boolean isFlush = true;
        boolean isStraight = true;
        int firstRepeated = 1;
        int secondRepeated = 0;
    
        Card previous = null;
        int size = hand.size();
        for (int i = 0; i < size; i++){
            Card value = hand.get(i);
            if(previous ==null){
                 previous = value;
                 continue;
            }
            
            int result = value.compareTo(previous);
            boolean sameSuit = previous.getSuit() == value.getSuit();
            previous = value;
            
            if(result==0){
                isStraight = false;
                isFlush = false;
                if(secondRepeated==0) firstRepeated++;
                else secondRepeated++;
                continue;
            }
            
            if(secondRepeated==0 && firstRepeated > 1)  secondRepeated = 1;
            
            isStraight = isStraight &&  (result==1 || (i==size-1 && result==9));
            
            isFlush = isFlush && sameSuit;
        }
        
        return getBestRank(isFlush, isStraight,firstRepeated, secondRepeated);
        
    }
    
    private String getBestRank (boolean isFlush, boolean isStraight, int firstRepeated, int secondRepeated){
        if(isStraight && isFlush){
            if(hand.get(0).getRank()==Card.Rank.Ten) 
                return "Royal_Flush";
            return "Straight_Flush";
        }
        
        if(isFlush) return "Flush";
        
        if(isStraight) return "Straight";
        
        if(firstRepeated==4) return "Four_of_Kind";
        
        if((firstRepeated==3  && secondRepeated==2) || (firstRepeated==2  && secondRepeated==3)) return "Full_House";

        if(firstRepeated==3 ) return "Three_of_Kind";


        if(firstRepeated==2) {
            if(secondRepeated==2)
                return "Two_Pair";
            return "One_Pair";
        }
        return "High_Card";
    }
    
    
    public static void main(String[] args){
        for(int i=0;i<1000;i++){
            PokerValue pv = new PokerValue();
            System.out.println(i + "\t" + pv);
        }
    }
}
