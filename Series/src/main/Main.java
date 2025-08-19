/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author lab_services_student
 */

    
import java.util.List;
import java.util.Scanner;

/**
 * Main - runs the console application and provides the menu.
 */
public class Main {
    private static final Series seriesManager = new Series();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Select option (1-6): ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> captureSeries();
                case "2" -> searchSeries();
                case "3" -> updateSeries();
                case "4" -> deleteSeries();
                case "5" -> viewReport();
                case "6" -> {
                    exitApp();
                    running = false;
                }
                default -> System.out.println("Invalid option. Please select 1-6.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("====== TV SERIES MANAGEMENT ======");
        System.out.println("1. Capture New Series");
        System.out.println("2. Search Series by ID");
        System.out.println("3. Update Series");
        System.out.println("4. Delete Series");
        System.out.println("5. View Series Report");
        System.out.println("6. Exit");
        System.out.println("==================================");
    }

    private static void captureSeries() {
        System.out.println("--- Capture New Series ---");
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Series ID cannot be empty.");
            return;
        }
        if (seriesManager.searchSeries(id) != null) {
            System.out.println("A series with that ID already exists.");
            return;
        }

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine().trim();
        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2-18): ");
            age = scanner.nextLine().trim();
            if (Series.isValidAge(age)) break;
            System.out.println("Invalid age. Age must be a number between 2 and 18. Please re-enter.");
        }

        String episodes;
        while (true) {
            System.out.print("Enter Number Of Episodes (integer >= 0): ");
            episodes = scanner.nextLine().trim();
            try {
                int e = Integer.parseInt(episodes);
                if (e < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number of episodes. Enter a non-negative integer.");
            }
        }

        SeriesModel model = new SeriesModel(id, name, age, episodes);
        boolean added = seriesManager.addSeries(model);
        if (added) {
            System.out.println("Series details successfully saved.");
        } else {
            System.out.println("Failed to save series. (Possible duplicate ID)");
        }
    }

    private static void searchSeries() {
        System.out.println("--- Search Series ---");
        System.out.print("Enter Series ID to search: ");
        String id = scanner.nextLine().trim();
        SeriesModel found = seriesManager.searchSeries(id);
        if (found != null) {
            System.out.println("Series found:");
            System.out.println("ID: " + found.SeriesId);
            System.out.println("Name: " + found.SeriesName);
            System.out.println("Age Restriction: " + found.SeriesAge);
            System.out.println("Number Of Episodes: " + found.SeriesNumberOfEpisodes);
        } else {
            System.out.println("No series data could be found for ID: " + id);
        }
    }

    private static void updateSeries() {
        System.out.println("--- Update Series ---");
        System.out.print("Enter Series ID to update: ");
        String id = scanner.nextLine().trim();
        SeriesModel found = seriesManager.searchSeries(id);
        if (found == null) {
            System.out.println("Series not found.");
            return;
        }
        System.out.println("Leave an input empty to keep the current value.");
        System.out.println("Current Name: " + found.SeriesName);
        System.out.print("New Name: ");
        String newName = scanner.nextLine().trim();
        if (newName.isEmpty()) newName = null;

        System.out.println("Current Age Restriction: " + found.SeriesAge);
        String newAge = null;
        while (true) {
            System.out.print("New Age Restriction (2-18) (or press Enter to keep current): ");
            String tmp = scanner.nextLine().trim();
            if (tmp.isEmpty()) {
                newAge = null;
                break;
            }
            if (Series.isValidAge(tmp)) {
                newAge = tmp;
                break;
            } else {
                System.out.println("Invalid age. Must be numeric between 2 and 18.");
            }
        }

        System.out.println("Current Number Of Episodes: " + found.SeriesNumberOfEpisodes);
        String newEpisodes = null;
        while (true) {
            System.out.print("New Number Of Episodes (or press Enter to keep current): ");
            String tmp = scanner.nextLine().trim();
            if (tmp.isEmpty()) {
                newEpisodes = null;
                break;
            }
            try {
                int e = Integer.parseInt(tmp);
                if (e < 0) {
                    System.out.println("Cannot be negative.");
                } else {
                    newEpisodes = tmp;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Must be a whole number.");
            }
        }

        boolean ok = seriesManager.updateSeries(id, newName, newAge, newEpisodes);
        if (ok) System.out.println("Series successfully updated.");
        else System.out.println("Update failed (possibly invalid input).");
    }

    private static void deleteSeries() {
        System.out.println("--- Delete Series ---");
        System.out.print("Enter Series ID to delete: ");
        String id = scanner.nextLine().trim();
        SeriesModel found = seriesManager.searchSeries(id);
        if (found == null) {
            System.out.println("Series not found.");
            return;
        }
        System.out.println("Series found: " + found.SeriesName + " (ID: " + found.SeriesId + ")");
        System.out.print("Are you sure you want to delete this series? (Y/N): ");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("Y")) {
            boolean removed = seriesManager.deleteSeries(id);
            if (removed) System.out.println("Series successfully deleted.");
            else System.out.println("Failed to delete series.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    private static void viewReport() {
        System.out.println("--- Series Report ---");
        List<SeriesModel> list = seriesManager.seriesReport();
        if (list.isEmpty()) {
            System.out.println("No series to display.");
            return;
        }
        System.out.printf("%-10s %-30s %-5s %-10s%n", "SeriesID", "SeriesName", "Age", "Episodes");
        System.out.println("---------------------------------------------------------------------");
        for (SeriesModel s : list) {
            System.out.printf("%-10s %-30s %-5s %-10s%n",
                    s.SeriesId, s.SeriesName, s.SeriesAge, s.SeriesNumberOfEpisodes);
        }
    }

    private static void exitApp() {
        System.out.println("Exiting application. Goodbye!");
    }
}
