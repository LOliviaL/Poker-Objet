import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Player {

//Prendre le nom du joueur
    private String nom;
    public Player (String unNom){
        this.nom= unNom;
      
    }

//Distribuer les cartes du joueur
    Card [] MyCards = new Card [5];
    public void setHand (Card[] cartes ){
        System.out.println("\nLes cartes de " + nom + " sont :");
        for (int i=0; i<cartes.length; i++){
            MyCards[i]= cartes[i];
            System.out.println(MyCards[i]);
        }
        

    }

    
//Demande quels cartes échanger, les affiche et les replace par null
    public Card[] getCardsToDiscard(){
        System.out.println("\n \n"+nom + ",  vos cartes sont : ");
        
        System.out.println(getHandString());
        
        int number;
        Scanner obj=new Scanner(System.in);  
        System.out.print("Entre 0 et 4, combien de cartes voulez-vous échanger : ");    
        number=obj.nextInt();
        Card[] array = new Card[number];
        if (number<=4 ){
            for(int i=0; i<number; i++){
                System.out.print("Quel est la position de la " + (i+1) + "eme carte que vous supprime (0-4): ");
                int val=obj.nextInt();

                for(int y=0;y<5;y++){
                    if(y+1==val){
                       
                        array[i]= new Card(MyCards[y+1].getValeur(),MyCards[y+1].getCouleur());
         
                    }
                }
                
                int v = val;
                MyCards[v]=null;
               
            }
        }        
            
        else{ System.out.println("Chance perdu : Vous ne pouvez pas changer autant !");}
        return array;
    }
 


    //prend une liste card et les mets dans les cartes du joueur s'il en manque 
    public void addCard(Card[] plusCarte){
        int val = 0;
            for (int y=0; y<MyCards.length; y++){
                if(MyCards[y]==null){
                        
                        MyCards[y]= plusCarte[val];
                        val=val+1;
                        
                        
                    
                }
            } 
        System.out.println( "\n"+"Maintenant, vos cartes sont : " + getHandString());
        
    }


    //Affiche les cartes du joueur
    public String getHandString(){
        return Arrays.toString(MyCards);
    }

   
    // Calcul le nombre max de VALEUR dans le packet de carte 
  public int Calcul(){
    int countMax = 1;
            String cardMax = null;
            
            for (int i = 0; i < MyCards.length; i++) {
                int count = 1;
                for (int j = i + 1; j < MyCards.length; j++) {
                    if (i == j) {
                        continue;
                    } 
                    else if ((MyCards[i].getValeur()).equals((MyCards[j]).getValeur())) {
                        count++;
                    }
                    if (count > countMax) {
                        countMax = count;
                        cardMax = MyCards[i].getValeur();
                    }
                }

            }
        return countMax;
     } 


    //Calcul qui a gagner en comparant le nb max de valeur entre deux joueurs
     public boolean beats(Player x){
            
        if (Calcul()>x.Calcul()){
            return true;
        }
        else{return false;}
    }
  
}