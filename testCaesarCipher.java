package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of testCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testCaesarCipher {
    public int[] countLetters(String message){
        //StringBuilder messageSB = new StringBuilder(message);
        int[] counts = new int[26];
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        for (int k = 0; k < message.length(); k++){
            //for each letter,find index in alpha
            //convert to lowercase
            char ch = Character.toLowerCase(message.charAt(k));
            int charIndex = alpha.indexOf(ch);
            //test if character is in alphabet
            if (charIndex != -1){
                //add a count to counts[index]
                counts[charIndex] +=1;
            }
            
        }
        return counts;
    }
    
    public int maxIndex(int[] values){
        //create index
        int maxIndex = -1;
        int maxValue = -1;
        //for each element in the array, compare value to the maxvalue
        for (int k = 0; k < values.length; k++){
            if (maxIndex == -1){
                maxIndex = k;
                maxValue = values[k];
            }
            
            if (maxValue < values[k]){
                maxValue = values[k];
                maxIndex = k;            
            }
            
        }
        //return max value
        return maxIndex;
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("The original message is "+message);
        
        newCaesarCipher cc = new newCaesarCipher(18);
        String encrypted = cc.encrypt(message);
        System.out.println("The encrypted message is "+encrypted);
        
        int key = breakCaesarCipher(encrypted);
        newCaesarCipher nc = new newCaesarCipher(key);        
        String decrypted = nc.decrypt(encrypted);
        System.out.println("The decrypted message is "+decrypted);      
    
    }
    
    public int breakCaesarCipher(String input){
        //find the most common letter in ecrypted String
        int[] counts = countLetters(input);
        int maxIndex = maxIndex(counts);        
        //compare common letter with "e" to find decryption key
        int decryptKey = maxIndex - 4;
        // if maxIndex is smaller than 4
        if (maxIndex <4){
            decryptKey = 26 - (4-maxIndex);
        }
        //decryption key
        return decryptKey;       
    }
}
