/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salessorter;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;

public class SalesSorter {

    /**
     * @param args the command line arguments
     */
    


    static class Product {
        String name;
        int quantity;

        Product(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
    }

    // Quick Sort algorithm (descending order)
    public static void quickSort(Product[] products, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(products, low, high);
            quickSort(products, low, pivotIndex - 1);
            quickSort(products, pivotIndex + 1, high);
        }
    }

    public static int partition(Product[] products, int low, int high) {
        int pivot = products[high].quantity;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (products[j].quantity > pivot) { // Descending order
                i++;
                Product temp = products[i];
                products[i] = products[j];
                products[j] = temp;
            }
        }
        Product temp = products[i + 1];
        products[i + 1] = products[high];
        products[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name: ");
            String name = sc.nextLine();
            System.out.print("Enter quantity sold: ");
            int qty = sc.nextInt();
            sc.nextLine();
            products[i] = new Product(name, qty);
        }

        quickSort(products, 0, products.length - 1);

        System.out.println("\nProducts sorted by sales (highest to lowest):");
        for (Product p : products) {
            System.out.println(p.name + " - " + p.quantity);
        }

        sc.close();
    }
}
