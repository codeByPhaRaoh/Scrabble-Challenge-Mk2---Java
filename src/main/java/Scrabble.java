import java.util.*;

public class Scrabble {
    String word;
    boolean isD;
    boolean isT;
    Character[] dLetter;
    Character[] tLetter;

    HashMap<Character, Integer> letterVal = new HashMap<Character, Integer>(){
        {
            put('A', 1);
            put('E', 1);
            put('I', 1);
            put('O', 1);
            put('U', 1);
            put('L', 1);
            put('N', 1);
            put('R', 1);
            put('S', 1);
            put('T', 1);
            put('D', 2);
            put('G', 2);
            put('B', 3);
            put('C', 3);
            put('M', 3);
            put('P', 3);
            put('F', 4);
            put('H', 4);
            put('V', 4);
            put('W', 4);
            put('Y', 4);
            put('K', 5);
            put('J', 8);
            put('X', 8);
            put('Q', 10);
            put('Z', 10);
        }
    };

    public Scrabble(String word){
        this.word = word != null ? word.toUpperCase() : "";
    }

    public Scrabble(String word, Character[] dLetter, Character[] tLetter, boolean dWord, boolean tWord){
        this.word = word != null ? word.toUpperCase() : "";
        this.isD = dWord;
        this.isT = tWord;
        this.dLetter = dLetter;
        this.tLetter = tLetter;
    }

    public int sTotal(){
        int points = 0;
        char[] letterArray = this.word.toCharArray(); 
        for(char letter : letterArray){ 
            points += letterVal.get(letter);
        }
        return points;
    }

    public int dOrT(int points){
        if(isD){
            return points * 2;
        }else if(isT){
            return points * 3;
        }
        return points;
    }

    public int dTotal(){
        int points = 0;
        if(dLetter == null) return points; 
        for(char letter : dLetter){ 
            points += letterVal.get(letter); 
        }
        return points;
    }

    public int tTotal(){
        int points = 0;
        if(tLetter == null) return points; 
        for(char letter : tLetter){ 
            points += (letterVal.get(letter) * 2); 
        }
        return points;
    }



    public int score(){
        return dOrT(sTotal()) + dTotal() + tTotal();
    }


}
