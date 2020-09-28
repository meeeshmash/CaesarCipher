package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of Ex1Caesar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ex1Caesar {
    
    public boolean isVowel(char ch){
       char lowerCH = Character.toLowerCase(ch);
       if (lowerCH == 'a' || lowerCH == 'e' || lowerCH == 'i' || lowerCH == 'o' || lowerCH == 'u'){
        return true;    
        }else{
        return false;
        }
    
    }
    
    public String replaceVowels(String phrase, char ch){
     StringBuilder newPhrase = new StringBuilder(phrase);
     //for each character of the phrase, determine if it is a vowel
     
     for(int k = 0; k < newPhrase.length(); k +=1){
        char currentCH = newPhrase.charAt(k);
        //if it is a vowel, use ch in the same index of new string
        if (isVowel(currentCH)){
            newPhrase.setCharAt(k,ch);        
        }else{
            //if it is not a vowel, use original character of same index
            newPhrase.setCharAt(k,currentCH);        
        }
        
        }
     //return newString
     return newPhrase.toString();
    
    }
    
   public String emphasize(String phrase, char ch){
       //Create a StringBuilder based on input phrase
       StringBuilder newPhrase = new StringBuilder(phrase);
       //for each character of the phrase, determine if it is ch
       for (int k = 0; k < newPhrase.length(); k+=1){
       //if it is ch && index is odd number, replace with * because position is an even number
       char currentCH = newPhrase.charAt(k);
       if (currentCH == ch && k%2 != 0){
           newPhrase.setCharAt(k,'+');
        }else if(currentCH == ch && k%2 == 0){
            //else if it is ch && index is an even number, replace with + because position is an odd number
           newPhrase.setCharAt(k,'*');
        }else{
            // else use original char
           newPhrase.setCharAt(k,currentCH);
       }
     }
       //return the new string
       return newPhrase.toString();
    }
    
   public void testIsVowel(){
       boolean answer = isVowel('a');
       System.out.println(answer);    
    }
    
   public void testReplaceVowel(){
       String phrase = "Hello World";
       char ch = '*';
       String newS = replaceVowels(phrase,ch);
       System.out.println(newS);
    
    }
   
   public void testEmphasize(){
       String phrase = "dna ctgaaactga";
       char ch = 'a';
       String newS = emphasize(phrase,ch);
       System.out.println(newS);
    
    
    }
}
