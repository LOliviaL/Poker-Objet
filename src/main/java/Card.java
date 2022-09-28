import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

public class Card {
    //Initialisation
    private String valeur;
    private String couleur;
    
    final static String[] Valeur = {"ACE","KING","QUEEN","JACK","TEN","NINE","EIGHT","SEVEN","SIX","FIVE","FOUR","THREE","TWO"};
    final static String[] Couleur = {"Coeur", "Pique", "Carreau", "Trefle"};

    //Les Cartes ont chaqu'une : une valeur et une couleur 
    public Card (String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    //Récupérer une Valeur
    public String getValeur(){
       return this.valeur;

    }

    //Récupérer une Couleur
    public String getCouleur(){
        return this.couleur;

    }
    //Donner une valeur et une couleur
    public String toString() {
        return valeur + " " + couleur;
    }
    
    //Initialisiation de la pioche 
    public static Card[] setPioche(){
      Card[] mot = new Card[52];
      int i =0;
      for(int count = 0; count < Valeur.length; count++) {
         for (int b =0; b<Couleur.length; b++){
            mot[i] = new Card(Valeur[count],Couleur[b]);
            i++;
         }
      }

      return mot;

    }
}