package practicals;

import java.lang.reflect.Array;
import java.util.*;

public class ExerciseThree {
    public static void echo(String arg){
        System.out.println(arg);
    }
    public static void main(String[]args){
        echo("3.1");
        threePointOne();
        echo("3.2");
        threePointTwo();
        echo("3.4");
        threePointFour();
        echo("3.6");
        threePointSix();
    }
    public static void threePointOne() {
        int count = 0, roll1, roll2;
        do{
            roll1 = (int)(Math.random() * 6) + 1;
            roll2 = (int)(Math.random() * 6) + 1;
            ++count;
        }while(roll1 != 1 || roll2 != 1);
        System.out.printf("It takes %s rolls to get snek eyes\n", count);
    }
    public static void threePointTwo() {
        int max_divisors = 0;
        int max_divisorer = 1;
        int count, i, j;
        final int limit = 10000;
        for (i = 1; i <= limit; i++) {
            count = 0;
            for (j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > max_divisors) {
                max_divisorer = i;
                max_divisors = count;
            }
        }
        System.out.printf("The number %d has the max divisors, at %d divisors.\n", max_divisorer, max_divisors);
    }
    public static void threePointFour(){
        Scanner stdin = new Scanner(System.in);
        char letter=' ',previous=' ',next;
        String word="",line=stdin.nextLine();
        next=line.charAt(0);
        line=line.substring(1);
        try {
            do {
                previous = letter;
                letter = next;
                next = line.charAt(0);
                line = line.substring(1);
                if (Character.isLetter(letter) || (Character.isLetter(previous) && Character.isLetter(next) && letter == '\'')) {
                    word = word + letter;
                } else {
                    if(word.length()>0){System.out.println(word);}
                    word = "";
                }
            } while (true);
        }catch(Exception e){
            if(Character.isLetter(letter)||(Character.isLetter(previous)&&Character.isLetter(next)&&letter=='\'')){
                word=word+letter;
            }
            System.out.println(word);
        }
    }
    public static void threePointSix(){
        int max_divisors = 0;
        int count, i, j;
        int[]victims={1};
        final int limit = 10000;
        for (i = 1; i <= limit; i++) {
            count = 0;
            for (j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > max_divisors) {
                victims=new int[]{i};
                max_divisors = count;
            }
            else{
                if(count==max_divisors){
                    int[]temp=victims.clone();
                    victims=new int[victims.length+1];
                    victims[victims.length-1]=i;
                    System.arraycopy(temp,0,victims,0,temp.length);
                }
            }
        }
        System.out.println("Among integers between 1 and 10000");
        System.out.printf("The maximum number of divisors was %d\n",max_divisors);
        System.out.println("Numbers with that many divisors include:");
        for(int victim:victims){
            System.out.printf("\t%d\n",victim);
        }
    }
}