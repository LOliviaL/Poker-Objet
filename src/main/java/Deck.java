import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;


public class Deck {

    //Prend 5 cartes au hazard et return une taable de 5 cartes 
    public static Card[] newRandomHand(){
        Card[] c = new Card[5];
        Random rd = new Random();
        Integer[] cartes= new Integer[5];
        
        for(int a=0; a<5; a++){
            cartes[a]=rd.nextInt(26);
            c[a]= (Card.setPioche())[cartes[a]];
        }
        return c;
    }

    //Prendre une carte au hazard dans la pioche et la met dans une tab
    public static Card[] getRandomCards(Integer x){
        Card[] cr = new Card[x];
        Integer[] cartes= new Integer[x];
        Random rd = new Random();
        if(x<=4){           
        for(int i = 0; i<x; i++){
            cartes[i]=rd.nextInt(26);
            cr[i]= (Card.setPioche())[cartes[i]];
            System.out.println( "La carte pris dans la pioche est : " + cr[i]);
            }
        } 
        return cr;
    
    }
   
}