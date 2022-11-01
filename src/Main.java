import java.util.Scanner;

public class Main {
    public static String[] products = { "Bread", "Buckwheat", "Eggs", "Ice Cream", "Rice", "Butter", "Cheese" };
    public static int[] prices = { 50, 135, 65, 53, 130, 120, 150 };
    public static int MIN_COST_FOR_BONUS = 1000;

    public static void main(String[] args) {
        System.out.println("Welcome!");
        System.out.println("We have:");
        for (int i = 0; i < products.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + products[i] + " for " + prices[i] + " for a piece. ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int[] counts = new int[products.length];

        while (true) {
            System.out.print("Input product number then quantity or end: ");
            String line = scanner.nextLine();

            if ("end".equals(line)) {
                break;
            }

            String[] parts = line.split(" ");
            int productNum = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);

            counts[productNum] += productCount;
        }

        System.out.println("Order list:");
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            sum += prices[i] * counts[i];
        }
        boolean doBonus = sum >= MIN_COST_FOR_BONUS;
        for (int i = 0; i < products.length; i++) {
            if (counts[i] != 0) {
                System.out.println("\t" + products[i] + " " + (doBonus ? counts[i] + 1 : counts[i]) + " pieces for " + (prices[i] * counts[i]) + " rub.");
            }
        }
        System.out.println("Total: " + sum + " rub.");
    }
}
