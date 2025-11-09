/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musiclessonapp;

/**
 *
 * @author lab_services_student
 */
// LessonPricing.java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;
import java.text.NumberFormat;

public class LessonPricing implements IMovieTickets {
    private final String[] instruments = {"Guitar", "Piano", "Violin"};
    private final String[] levels = {"Beginner", "Intermediate", "Advanced"};

    // [levelIndex][instrumentIndex]
    private final int[][] prices = {
        {150, 250, 280}, // Beginner
        {215, 232, 280}, // Intermediate
        {130, 185, 310}  // Advanced
    };

    @Override
    public int getPrice(String instrument, String level) {
        int i = indexOf(instruments, instrument);
        int l = indexOf(levels, level);
        if (i < 0 || l < 0) {
            throw new IllegalArgumentException("Invalid instrument or level.");
        }
        return prices[l][i];
    }

    @Override
    public double getAverageForLevel(String level) {
        int l = indexOf(levels, level);
        if (l < 0) throw new IllegalArgumentException("Invalid level: " + level);
        int sum = 0;
        for (int j = 0; j < instruments.length; j++) sum += prices[l][j];
        return sum / (double) instruments.length;
    }

    @Override
    public double getOverallAverage() {
        int sum = 0;
        int count = 0;
        for (int l = 0; l < levels.length; l++) {
            for (int j = 0; j < instruments.length; j++) {
                sum += prices[l][j];
                count++;
            }
        }
        return sum / (double) count;
    }

    @Override
    public String[] getInstruments() {
        return Arrays.copyOf(instruments, instruments.length);
    }

    @Override
    public String[] getLevels() {
        return Arrays.copyOf(levels, levels.length);
    }

    @Override
    public void saveSelection(File file, String instrument, String level) throws IOException {
        int price = getPrice(instrument, level); // will validate inputs
        boolean newFile = !file.exists();
        try (FileWriter fw = new FileWriter(file, true)) {
            if (newFile) {
                // header
                fw.write("timestamp,instrument,level,price\n");
            }
            String timestamp = Instant.now().toString();
            fw.write(String.format("%s,%s,%s,%d\n", timestamp, instrument, level, price));
            fw.flush();
        }
    }

    private int indexOf(String[] arr, String key) {
        if (key == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(key)) return i;
        }
        return -1;
    }

    /**
     * Utility to format price in South African-style currency with R prefix.
     */
    public static String formatRand(int amount) {
        // Using NumberFormat for better grouping
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));
        // nf returns ZAR symbol "R" in many locales; but to be safe, we'll replace if necessary:
        String formatted = nf.format(amount);
        // Some locales might produce "ZAR" or "R". Ensure 'R' prefix without decimals:
        // Remove decimals (we work with whole units) and ensure "R" prefix.
        if (formatted.contains(".")) {
            formatted = formatted.substring(0, formatted.indexOf('.'));
        }
        if (!formatted.startsWith("R")) {
            formatted = "R" + formatted.replaceAll("[^0-9,\\s]", "");
        }
        return formatted;
    }
}
