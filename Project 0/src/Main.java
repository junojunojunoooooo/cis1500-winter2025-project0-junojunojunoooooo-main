import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // sets up scanner as well as the variable holding the user's pay for the week
        Scanner keyboard = new Scanner(System.in);
        double pay;

        // asks for and stores the user's hourly wage
        System.out.println("What's your hourly wage?");
        double wage = Double.parseDouble(keyboard.nextLine());

        // asks for and stores the user's hours worked
        System.out.println("How many hours did you work this week?");
        double hours = Double.parseDouble(keyboard.nextLine());

        // checks if the user receives overtime or not and performs the appropriate calculations
        if (hours <= 40) { //user has not worked enough for overtime
            pay = hours*wage;
        } else { // user has worked enough for overtime
            /* pay is calculated by applying regular wage to the first 40 hours,
            then adding the overtime pay increase to every hour above 40 */
            pay = (40 * wage) + (1.5 * wage * (hours - 40));
        }

        // rounds "pay" up to the nearest hundredth
        // multiplying pay by 100 keeps any number after the hundredths place after the decimal point
        // Math.ceil rounds up, removing any number after the decimal point (after the hundredths place)
        // dividing by 100 again turns pay back to its regular value, but now it's rounded up
        pay = Math.ceil(pay * 100) / 100;

        // prints the user's pay
        System.out.println("Your pay this week is $" + pay + ".");
    }
}