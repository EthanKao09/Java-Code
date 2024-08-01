package Exam1.Problem1;

public class PokerOdds {
    long trials = 0;

    PokerOdds(){
        trials = 10000000;
    }
    
    PokerOdds(long trials){
        this.trials = trials;
    }
    
    public String toString(){
    	int RF = 0;
        int SF = 0;
        int FFK = 0;
        int FH = 0;
        int F = 0;
        int S = 0;
        int TOK = 0;
        int TP = 0;
        int OP = 0;
        int HC = 0;
        String result = "";
        long startTime = System.currentTimeMillis();
        for(int i =0; i< trials; i++){
            PokerValue pokerValue = new PokerValue();
            Object[] arr = pokerValue.toArray();
            switch((String)arr[0]){
                case "Royal_Flush": RF++; break;
                case "Straight_Flush": SF++; break;
                case "Four_of_Kind": FFK++; break;
                case "Full_House": FH++; break;
                case "Flush": F++; break;
                case "Straight": S++; break;
                case "Three_of_Kind": TOK++; break;
                case "Two_Pair": TP++; break;
                case "One_Pair": OP++; break;
                default: HC++; break;
            }
        }
        
        
        long timeElapsed = System.currentTimeMillis()- startTime;

        result = result + "Royal Flush\t" + RF + "\t" + "(" + String.format("%.4f",(double)(RF*100)/trials) + "%)\n";
        result = result + "Straight Flush\t" + SF + "\t" + "(" + String.format("%.4f",(double)(SF*100)/trials) + "%)\n";
        result = result + "Four Of A Kind\t" + FFK + "\t" + "(" + String.format("%.4f",(double)(FFK*100)/trials) + "%)\n";
        result = result + "Full House\t" + FH + "\t" + "(" + String.format("%.4f",(double)(FH*100)/trials) + "%)\n";
        result = result + "Flush\t" + F + "\t" + "(" + String.format("%.4f",(double)(F*100)/trials) + "%)\n";
        result = result + "Straight\t" + S + "\t" + "(" + String.format("%.4f",(double)(S*100)/trials) + "%)\n";
        result = result + "Three Of A Kind\t" + TOK + "\t" + "(" + String.format("%.4f",(double)(TOK*100)/trials) + "%)\n";
        result = result + "Two Pair\t" + TP + "\t" + "(" + String.format("%.4f",(double)(TP*100)/trials) + "%)\n";
        result = result + "One Pair\t" + OP + "\t" + "(" + String.format("%.4f",(double)(OP*100)/trials) + "%)\n";
        result = result + "High Card\t" + HC + "\t" + "(" + String.format("%.4f",(double)(HC*100)/trials) + "%)\n";
        result = result + "This simulation took " + timeElapsed/1000.0 + " seconds.";
        return result;
    }
    
    public static void main(String args[]) {
        PokerOdds po = new PokerOdds(10000000);
        System.out.println(po);
    }
}