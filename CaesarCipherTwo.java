package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int keyA;
    private int keyB;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Create newAlphabet String with shift in key 1
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        keyA = key1;
        keyB = key2;
    }
    
    public String encrypt(String input){
        //newCaesarCipher instance
        newCaesarCipher cc1 = new newCaesarCipher(keyA);
        newCaesarCipher cc2 = new newCaesarCipher(keyB);
        //Create twp strings based on key 1 and key 2
        String first = cc1.encrypt(input);
        String second = cc2.encrypt(input);
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
    
    public String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26-keyA, 26-keyB);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
    
    
}
