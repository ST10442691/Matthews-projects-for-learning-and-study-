/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

// LessonPricingTest.java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import musiclessonapp.LessonPricing;

public class LessonPricingTest {
    private LessonPricing model;

    @BeforeEach
    public void setup() {
        model = new LessonPricing();
    }

    @Test
    public void testGetPriceValid() {
        assertEquals(150, model.getPrice("Guitar", "Beginner"));
        assertEquals(232, model.getPrice("Piano", "Intermediate"));
        assertEquals(310, model.getPrice("Violin", "Advanced"));
    }

    @Test
    public void testGetPriceInvalid() {
        assertThrows(IllegalArgumentException.class, () -> model.getPrice("Sax", "Beginner"));
        assertThrows(IllegalArgumentException.class, () -> model.getPrice("Guitar", "Expert"));
    }

    @Test
    public void testAverages() {
        double beginnerAvg = model.getAverageForLevel("Beginner");
        // Beginner: (150 + 250 + 280) / 3 = 680 / 3 = 226.666...
        assertEquals(680.0 / 3.0, beginnerAvg, 1e-9);

        double overall = model.getOverallAverage();
        // compute by brute force
        double sum = 150 + 250 + 280 + 215 + 232 + 280 + 130 + 185 + 310;
        assertEquals(sum / 9.0, overall, 1e-9);
    }

    @Test
    public void testSaveSelectionCreatesFileAndContainsCsv() throws IOException {
        Path temp = Files.createTempFile("lessons", ".csv");
        File file = temp.toFile();
        // Ensure empty file removed, model will add header if new
        Files.deleteIfExists(temp);

        model.saveSelection(file, "Guitar", "Beginner");
        assertTrue(file.exists());
        String content = new String(Files.readAllBytes(file.toPath()), "UTF-8");
        assertTrue(content.contains("timestamp,instrument,level,price"));
        assertTrue(content.contains("Guitar,Beginner,150") || content.contains("Guitar,Beginner,150\n"));

        // Append another line and ensure two lines written (header + row + row)
        model.saveSelection(file, "Piano", "Advanced");
        String content2 = new String(Files.readAllBytes(file.toPath()), "UTF-8");
        // Count lines
        long lineCount = content2.lines().count();
        // header + at least 2 data lines
        assertTrue(lineCount >= 3);

        // cleanup
        file.delete();
    }

    @Test
    public void testSaveSelectionInvalid() {
        Path temp = null;
        try {
            temp = Files.createTempFile("test", ".csv");
            File file = temp.toFile();
            assertThrows(IllegalArgumentException.class, () -> model.saveSelection(file, "Sax", "Beginner"));
        } catch (IOException e) {
            fail("Unexpected IOException: " + e.getMessage());
        } finally {
            if (temp != null) temp.toFile().delete();
        }
    }
}
