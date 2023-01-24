import java.util.Scanner;

public class PersonalData {
    public static void main (String[] args){
        System.out.println("what is your name?");
        Scanner scanner = new Scanner(System.in);

        String PlayerName = scanner.nextLine();


        System.out.println("How old are you?");
        int PlayerAge = scanner.nextInt();
        scanner.nextLine();


        System.out.println("What is your favorite color?");
        String FavoriteColor = scanner.nextLine();




        System.out.println("Hello "  + PlayerName  +  " you have "  + PlayerAge + " and your favorite color is " + FavoriteColor);

    }
}
