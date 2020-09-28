package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of newCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class newCaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public newCaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input){
         //Create StringBuilder based on string input
        StringBuilder newPhrase = new StringBuilder(input);
        StringBuilder sbKey = new StringBuilder(shiftedAlphabet);
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
    
    public String decrypt(String input){
        newCaesarCipher cc = new newCaesarCipher(26-mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }

}
