import java.util.Scanner;

/* Assume this is a rectangular fence

ask for the length and the width of their fenced area

ask them how far apart do they want their posts to be

we need to check to ensure that the distance is evenly divisible by the post distance
(if it's not, please display an error message and tell them to run the program again)

calculate the number of posts we need to buy

then, ask the user how long of a board they want to buy

if the board length is less than the post distance, tell them they can't do that and to try and run the program again.

calculate the number of boards needed to build the fence with a single board across

then ask the user how many boards they want to run across each post

ask the user how much each post costs

ask the user how much each board costs

output the total # of posts required

the total # of boards required

the total cost of each, and the grand total for the project */

public class Main {
    public static void main(String[] args) {
        // sets up scanner
        Scanner keyboard = new Scanner(System.in);

        // asks for and stores and length and width of the area being fenced
        System.out.println("What is the length of the area you want to fence?");
        int length = Integer.parseInt(keyboard.nextLine());

        System.out.println("How about the width?");
        int width = Integer.parseInt(keyboard.nextLine());

        // asks for and stores distance between posts
        System.out.println("How far apart do you want your posts to be?");
        int postDistance = Integer.parseInt(keyboard.nextLine());

        // checks if the fence's dimensions are divisible by the distance between posts
        // terminates the program with a message if the values are divisible
        if (length % postDistance != 0) {
            System.out.println("The distance between posts isn't divisible by your area's length! Please run the program again.");
            System.exit(0);
        } else if (width % postDistance != 0) {
            System.out.println("The distance between posts isn't divisible by your area's width! Please run the program again.");
            System.exit(0);
        }

        // calculates the number of posts needed
        int totalPosts = 2 * (length / postDistance) + 2 * (width / postDistance);

        // asks for and stores board length
        System.out.println("How long are the boards you'd like to use for your fence?");
        int boardLength = Integer.parseInt(keyboard.nextLine());

        // terminates the program with a message if board length is less than post distance
        if (boardLength < postDistance) {
            System.out.println("Your boards can't be shorter than the distance between your posts! Please run the program again.");
            System.exit(0);
        }

        // finds the number of boards needed to go around with one board across by dividing perimeter by board length and rounding up
        int totalBoards = (int) Math.ceil((2 * (width + length)) / boardLength);

        // asks for number of boards across each post and multiplies it by the number of boards needed to find the total boards needed
        System.out.println("How many boards do you want to run across each post?");
        totalBoards = totalBoards * Integer.parseInt(keyboard.nextLine());

        // finds the cost of each post and boards as well as the total costs for each
        System.out.println("How much does each post cost?");
        double postCost = Double.parseDouble(keyboard.nextLine());
        double totalPostCost = postCost * totalPosts;

        System.out.println("How much does each board cost?");
        double boardCost = Double.parseDouble(keyboard.nextLine());
        double totalBoardCost = boardCost * totalBoards;

        // calculates the total cost to build the fence
        double totalCost = totalBoardCost + totalPostCost;

        // prints the materials needed and the cost to buy them
        System.out.println("You will need " + totalPosts + " posts, which will cost $" + totalPostCost + ".");
        System.out.println("You will need " + totalBoards + " boards, which will cost $" + totalBoardCost + ".");
        System.out.println("You will need $" + totalCost + " to build this fence.");
    }
}