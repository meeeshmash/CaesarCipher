package CaesarCipher;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public int indexOfMax(int[] values){
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
    
    
    public void countWordLengths(FileResource resource, int[] counts){
        //Find array length and set as max length
        int maxLength = counts.length;
        //for String word: each word in file resource
        for (String word : resource.words()){
            // count the length of word
           int length = word.length();
           StringBuilder wordSB = new StringBuilder(word);
            //2 if loops to consider first & last character of word
            //if loop for the last character
           if(!Character.isLetter(wordSB.charAt(length-1))){
            length -= 1;         
            }
            // if loop for the first character
           if(!Character.isLetter(wordSB.charAt(0))){
            length -= 1;
            }
           //if it is not a character
           if (length < 0){
            continue;
            }
            //if final length is smaller than maxlength
            if (length < maxLength){
            //counts[length of word] +1
            counts[length] +=1;
            }else{
            //else +1 to counts[maxLength]
            counts[maxLength] +=1;
           }
        }
        //for each row of counts, print
        for (int k = 1; k < counts.length; k++){
            System.out.println("for count of "+k+" there are "+counts[k]+" number of words");
        }
        
        int maxIndex = indexOfMax(counts);
        System.out.println("The most common word length is "+ maxIndex);
    }
    
    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts = new int[100];
        countWordLengths(resource, counts);        
    
    }
}
