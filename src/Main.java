import java.util.Scanner;

public class Main {

    public static String[] products = { "Bread", "Buckwheat", "Eggs", "Ice Cream", "Rice", "Butter", "Cheese" };
    public static int[] prices = { 50, 135, 65, 53, 130, 120, 150 };

    // В стоимости этих товаров каждые три товара должны стоить как два:
    public static String[] productsOnSale = { "Bread", "Ice Cream", "Rice" };

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
            if (counts[i] != 0) {
                boolean isOnSale = false;
                for (String saleProduct : productsOnSale) {
                    if (products[i].equals(saleProduct)) {
                        isOnSale = true;
                    }
                }

                if (isOnSale) {
                    System.out.println("\t" + products[i] + " " + counts[i] + " pieces for " + (prices[i] * (counts[i] / 3 * 2 + counts[i] % 3)) + " rub. (Sale!)");
                    sum += prices[i] * (counts[i] / 3 * 2 + counts[i] % 3);
                } else {
                    System.out.println("\t" + products[i] + " " + counts[i] + " pieces for " + (prices[i] * counts[i]) + " rub.");
                    sum += prices[i] * counts[i];
                }
            }
        }
        System.out.println("Total: " + sum + " rub.");
    }

}
