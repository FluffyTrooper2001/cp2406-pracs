// Got it right first test. :)

package practicals;
import java.util.*;
import java.lang.*;

public class ExerciseFour {
    private final static Scanner stdin = new Scanner(System.in);
    public static class fourPointOne {
        public static void main() {
            printCapitalized(ExerciseFour.stdin.nextLine());
            System.out.println();
        }
        public static void printCapitalized(String s) {
            char prev=' ',pprev=' ';
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(!(Character.isLetter(prev)||(prev=='\''&&Character.isLetter(pprev)))&&Character.isLetter(c)){
                    System.out.print(Character.toUpperCase(c));
                }
                if(prev!=' '){System.out.print(c);}
                pprev=prev;
                prev=c;
            }
        }
    }
    public static void main(String[]args) {
        System.out.println("4.1");
        fourPointOne.main();
        System.out.println("4.2");
        fourPointTwo();
        System.out.println("4.3");
        fourPointThree();
        System.out.println("4.4");
        fourPointFour();
    }

    public static int hexValue(char c){
        return switch (Character.toUpperCase(c)) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'A' -> 10;
            case 'B' -> 11;
            case 'C' -> 12;
            case 'D' -> 13;
            case 'E' -> 14;
            case 'F' -> 16;
            default  -> -1;
        };
    }

    public static void fourPointTwo() {
        String input = stdin.nextLine();
        int value = 0,output;
        for (int i=0;i<input.length();i++){
            output = hexValue(input.charAt(i));
            assert output>-1;
            value = value*16 + output;
        }
        System.out.println(value);
    }

    private static int numRolls(int n) throws IllegalArgumentException{
        if (n<2||n>12){
            throw new IllegalArgumentException("Invalid argument "+n);
        }
        int roll,count=0;
        do{
            roll=2+(int)(Math.random()*6)+(int)(Math.random()*6); // two dice rolls
            count+=1;
        }
        while(roll!=n);
        return count;
    }

    public static void fourPointThree() {
        int roll, count = 0;
        System.out.printf("It takes %d rolls to get snake eyes.\n",numRolls(2));
    }

    public static void fourPointFour() {
        int total,i;
        double avg;
        System.out.println("Total on Dice    \tAverage Number of Rolls");
        System.out.println("-------------    \t-----------------------");
        for(total=2;total<=12;total++){
            avg=0.0;//this number will have no effect as i starts at 0
            System.out.printf("       %d    \t      ",total);
            for(i=0;i<10000;i++){
                avg*=i;//translate to summation
                avg+=numRolls(total);//include next number
                avg/=i+1;//divide by no. of elements.
            }
            System.out.println(avg);
        }
    }
}
