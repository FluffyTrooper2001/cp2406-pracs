package practicals;
import java.util.*;

public class ExerciseTwo {
    private static final Scanner stdin = new Scanner(System.in);
    public static void main(String[]args) {
        System.out.println("2.1");
        exerciseTwoPoint1();
        System.out.println("\n2.2");
        exerciseTwoPoint2();
        System.out.println("\n2.3");
        exerciseTwoPoint3();
        System.out.println("\n2.4");
        exerciseTwoPoint4();
        System.out.println("\n2.5");
        exerciseTwoPoint5();
    }
    public static void exerciseTwoPoint1() {
        String[]initials=new String[]{
                "    *     *      ***   ****",
                "   * *   * *      *    *   *",
                "  *   * *   *     *    ****",
                " *     *     *    *    *  *",
                "*             *  ***   *   *"
        }; // suggested solution makes me cringe
        for(String line:initials) {System.out.println(line);}
    }
    private static int rand() {return(int)(Math.random()*6)+1;}
    public static void exerciseTwoPoint2() {
        int first = rand();
        int second = rand();
        System.out.println("The first die comes up "+first);
        System.out.println("The second die comes up "+second);
        System.out.println("Your total roll is "+(first+second));
    }
    public static void exerciseTwoPoint3() {
        System.out.print("What is your name? ");
        String name = stdin.nextLine().toUpperCase();
        System.out.println("Hello, "+name+", nice to meet you");
    }
    public static void exerciseTwoPoint4() {
        int cents = 0;
        System.out.println("How many quarters? ");
        cents += stdin.nextInt()*25;
        stdin.nextLine();
        System.out.println("How many dimes?    ");
        cents += stdin.nextInt()*10;
        stdin.nextLine();
        System.out.println("How many nickels?  ");
        cents += stdin.nextInt()*5;
        stdin.nextLine();
        System.out.println("How many pennies?  ");
        cents += stdin.nextInt();
        stdin.nextLine();
        double dolla = cents/100.0;
        System.out.printf("You have $%.2f\n",dolla);
    }
    public static void exerciseTwoPoint5() {
        System.out.print("How many eggs? ");
        int eggs = stdin.nextInt();
        int gross = eggs/144;
        eggs %= 144;
        int dozen = eggs/12;
        eggs %= 12;
        System.out.printf("You have %d gross, %d dozen and %d eggs", gross, dozen, eggs);
    }
}
