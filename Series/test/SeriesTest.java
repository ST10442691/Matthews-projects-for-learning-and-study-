/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import main.Series;
import main.SeriesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Series logic class.
 * Tests map to the required tests from Section B of the assignment.
 */
public class SeriesTest {
    private Series series;

    @BeforeEach
    public void setup() {
        series = new Series();
        // add a sample series for testing
        SeriesModel sample = new SeriesModel("S001", "Sample Show", "12", "10");
        series.addSeries(sample);
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel found = series.searchSeries("S001");
        assertNotNull(found);
        assertEquals("Sample Show", found.SeriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel found = series.searchSeries("NOT_EXIST");
        assertNull(found);
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = series.updateSeries("S001", "Updated Show", "14", "12");
        assertTrue(updated);
        SeriesModel found = series.searchSeries("S001");
        assertEquals("Updated Show", found.SeriesName);
        assertEquals("14", found.SeriesAge);
        assertEquals("12", found.SeriesNumberOfEpisodes);
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = series.deleteSeries("S001");
        assertTrue(deleted);
        assertNull(series.searchSeries("S001"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = series.deleteSeries("NOPE");
        assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(Series.isValidAge("2"));
        assertTrue(Series.isValidAge("10"));
        assertTrue(Series.isValidAge("18"));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(Series.isValidAge("1"));   // below lower bound
        assertFalse(Series.isValidAge("19"));  // above upper bound
        assertFalse(Series.isValidAge("abc")); // non-numeric
        assertFalse(Series.isValidAge(""));    // empty
        assertFalse(Series.isValidAge(null));  // null
    }
}
