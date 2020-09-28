package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key){
        //Create StringBuilder based on string input
        StringBuilder newPhrase = new StringBuilder(input);
        //Create alphabet String
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Create newAlphabet String with shift in key
        String newAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        StringBuilder sbKey = new StringBuilder(newAlphabet);
        //for each character in StringBuilder
        for (int k = 0; k < newPhrase.length(); k +=1){
            //find currentCharacter
            char currentCH = newPhrase.charAt(k);
            //set currentCH to uppercase
            char upperCurrCH = Character.toUpperCase(currentCH);
            //find alphabet index of current character
            int chIndex = alphabet.indexOf(upperCurrCH);
            //find newCharacter using alphabet index in newAlphabet String
            //if the index = -1, use the original character
            if (chIndex == -1){
                newPhrase.setCharAt(k,currentCH);            
             }else{
                //newCH in uppercase
                 char newCH = sbKey.charAt(chIndex);
                //Check whether original character is lowercase
                //Set character in StringBuilder to newCharacter
                if (Character.isLowerCase(currentCH)){
                    //if lowercase, make newCH lowercase before replace character in nePhrase
                    newCH = Character.toLowerCase(newCH);
                    newPhrase.setCharAt(k,newCH);
                }else{
                    newPhrase.setCharAt(k,newCH);
                
                }
                                    
           }
       }
        //return StringBuilder.toString()
       return newPhrase.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        //Create twp strings based on key 1 and key 2
        String first = encrypt(input,key1);
        String second = encrypt(input,key2);
        StringBuilder newPhrase = new StringBuilder(input);
        //build 2 for loops, one with k = 0 , one with k = 1
        for (int k = 0; k < newPhrase.length(); k += 2){
            // key 1 characters
            //find char in first string with k index
            char newChar = first.charAt(k);
            newPhrase.setCharAt(k, newChar);            
        }
        
        for (int k = 1; k < newPhrase.length(); k += 2){
            //key 2 characters
            char newChar2 = second.charAt(k);
            newPhrase.setCharAt(k, newChar2);        
        }
        
        return newPhrase.toString();
        
    }
    
    public void testEncrpyt(){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        int key = 15;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        
    }
    
    public void testEncrypt2Keys(){
        String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        int key1 = 26-14;
        int key2 = 26-24;
        String newString = encryptTwoKeys(message, key1, key2);
        System.out.println(newString);
        
    }
}
