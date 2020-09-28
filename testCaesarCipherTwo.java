package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of testCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testCaesarCipherTwo {
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
    
    public String halfOfString(String message, int start){
        String answer = "";        
        for (int k = start; k < message.length(); k += 2){
            //find char in first string with k index
            char newChar = message.charAt(k);
            answer = answer + newChar; 
            
        }
        return answer;
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
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println("The original message is "+message);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
        String encrypted = cc.encrypt(message);
        System.out.println("The encrypted message is "+encrypted);
        
        String first = halfOfString(encrypted,0);
        String second = halfOfString(encrypted,1);
        int key1 = breakCaesarCipher(first);
        int key2 = breakCaesarCipher(second);
        CaesarCipherTwo nc = new CaesarCipherTwo(key1,key2);        
        String decrypted = nc.decrypt(encrypted);
        System.out.println("The decrypted message is "+decrypted);     

        
    }
}
