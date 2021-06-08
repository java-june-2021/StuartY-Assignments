import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
    // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. 
    // Print the sum of all numbers in the array. Also have the function return 
    // an array that only includes numbers that are greater than 10 
    // (e.g. when you pass the array above, it should return an array with the values of 13,25,32)

    public static ArrayList sumAndGreaterThan10(){
        int[] myArray = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        for(int i : myArray){
            sum += i;
            if(i > 10){
                myArrayList.add(i);
            }
        }
        System.out.println(sum);
        return myArrayList;
    }


    // Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, 
    // Ishikawa. Shuffle the array and print the name of each person. Have the method also 
    // return an array with names that are longer than 5 characters.

    public ArrayList nameShuffle(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        ArrayList<String> longNames = new ArrayList<String>();
        Collections.shuffle(names);
        for(String i : names){
            System.out.println(i);
            if(i.length()>5){
                longNames.add(i);
            }
        }
        return longNames;
    }

    // Create an array that contains all 26 letters of the alphabet (this array must have 26 values). 
    // Shuffle the array and, after shuffling, display the last letter from the array. 
    // Have it also display the first letter of the array. If the first letter in the array is a vowel, 
    // have it display a message.

    public ArrayList cookAlphabetSoup(){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char l = 'a'; l <= 'z'; l++){
            alphabet.add(l);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet.get(25));
        System.out.println(alphabet.get(0));
        if((alphabet.get(0) == 'a') || (alphabet.get(0) == 'e') || (alphabet.get(0) == 'i') || (alphabet.get(0) == 'o') || (alphabet.get(0) == 'u')){
            System.out.println("Nice! You got a vowel!");
        }
        return alphabet;
    }

    // Generate and return an array with 10 random numbers between 55-100.

    public ArrayList getTenRandom(){
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        Random dice = new Random();
        for(int i = 1; i < 11; i++){
            randoms.add(dice.nextInt(46)+55);
        }
        return randoms;
    }

    // Generate and return an array with 10 random numbers between 55-100 and have it be sorted 
    // (showing the smallest number in the beginning). Display all the numbers in the array. 
    // Next, display the minimum value in the array as well as the maximum value.


    public ArrayList sortTenRandom(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr = getTenRandom();
        Collections.sort(arr);
        int min = arr.get(0);
        int max = arr.get(0);
        for(int i : arr){
            if(i < min){
                min = i;
            }
            else if(i > max){
                max = i;
            }
        }
        System.out.println(arr);
        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
        return arr;
    }

    // Create a random string that is 5 characters long.

    public String getRandomString(){
        Random dice = new Random();
        String randString = null;
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch <= 'z'; ch++){
            alphabet.add(ch);
        }
        // System.out.println(alphabet.get(dice.nextInt(27)).charValue());
        // randString = alphabet.get(dice.nextInt(27)).charValue();
        randString = String.valueOf(alphabet.get(dice.nextInt(26))) + String.valueOf(alphabet.get(dice.nextInt(26))) + String.valueOf(alphabet.get(dice.nextInt(26))) + String.valueOf(alphabet.get(dice.nextInt(26))) + String.valueOf(alphabet.get(dice.nextInt(26)));
        return randString;
    }

    // Generate an array with 10 random strings that are each 5 characters long

    public ArrayList getTenRandomStrings(){
        ArrayList<String> strings = new ArrayList<String>();
        for(int i = 0; i < 10; i++){
            strings.add(getRandomString());
        }
        return strings;
    }
}