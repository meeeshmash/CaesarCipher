package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of DecryptCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecryptCaesarCipher {
    //create an array that counts the number of letters
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
    //find the letter with the max number
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
    //use the maxIndex letter and compare with "e"
    public String decrypt(String encrypted){
        //create CC object to call encryption method
        CaesarCipher cc = new CaesarCipher();
        //find the most common letter in ecrypted String
        int[] counts = countLetters(encrypted);
        int maxIndex = maxIndex(counts);        
        //compare common letter with "e" to find decryption key
        int decryptKey = maxIndex - 4;
        // if maxIndex is smaller than 4
        if (maxIndex <4){
            decryptKey = 26 - (4-maxIndex);
        }
        //call CC ecryption method with decryption key
        return cc.encrypt(encrypted,26-decryptKey);
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
    
    public int getKey(String encrypted){
        //find the most common letter in ecrypted String
        int[] counts = countLetters(encrypted);
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
    
    public String decryptTwoKeys(String encrypted){
        //create CC object to call encryption method
        CaesarCipher cc = new CaesarCipher();
        //Split encrypted string into two
        String first = halfOfString(encrypted,0);
        String second = halfOfString(encrypted,1);
        //find key for each half of encrypted string
        int firstKey = getKey(first);
        System.out.println("The first key is "+ (firstKey));
        int secondKey = getKey(second);
        System.out.println("The second key is "+ (secondKey));
        //use encrypt two keys method to decrypt String
        String decrypted = cc.encryptTwoKeys(encrypted, 26-firstKey,26-secondKey);
        return decrypted;      
    
    }
    
    public void testHalf(){
        String s = "Testing half of string";
        String newS = halfOfString(s,1);
        System.out.print(newS);
    
    }
    
    public void testdecrypt(){
        String message = "Yjhi p ithi higxcv lxiw adih du ttttttttttttttttth";
        String decrypted = decrypt(message);
        System.out.println("Encrypted message is "+message+" and decrypted message is "+decrypted);
    
    }
    
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decrypted = decryptTwoKeys(message);
        System.out.println("Encrypted message is "+message);
        System.out.println("Decrypted message is "+decrypted);
    
    }
}
