package com.pi;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        first();
        second();
        third();
    }

    public static void first(){
        System.out.println("Enter a sentence of five words");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Longest word in the sentence: " + longestWord);
        System.out.println("Length of its letters: " + longestWord.length());

        StringBuilder builder = new StringBuilder(words[1]).reverse();
        System.out.println("Second word in reverse order: " + builder);
    }

    public static void second(){
        System.out.println("\nEnter a sentence that contains the words between more than one space: ");
        String sentence = sc.nextLine();
        sentence = sentence.replaceAll(" +", " ");
        System.out.println("Your sentence : " + sentence);
    }

    public static void third(){
        System.out.println("Enter 5 numbers in different lines:");
        String[] numbersWithPattern =  new String[5];
        for(int i = 0; i < numbersWithPattern.length; i++){
            float value = sc.nextFloat();
            numbersWithPattern[i] = "$" + String.format("%.2f",value);
        }

        for (String line :
                numbersWithPattern) {
            System.out.println(line.replace(",","."));
        }
    }
}
