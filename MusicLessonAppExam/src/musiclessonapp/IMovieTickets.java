/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musiclessonapp;

/**
 *
 * @author lab_services_student
 */
// IMovieTickets.java
public interface IMovieTickets {
    /**
     * Returns the price in whole currency units for the given instrument and level.
     * @throws IllegalArgumentException when instrument or level is invalid.
     */
    int getPrice(String instrument, String level) throws IllegalArgumentException;

    /**
     * Returns the average price for a level (double).
     * @throws IllegalArgumentException when level is invalid.
     */
    double getAverageForLevel(String level) throws IllegalArgumentException;

    /**
     * Returns the overall average price across all levels and instruments.
     */
    double getOverallAverage();

    /**
     * Returns a copy of available instruments.
     */
    String[] getInstruments();

    /**
     * Returns a copy of available levels.
     */
    String[] getLevels();

    /**
     * Append a single selection to a CSV file. The CSV will have columns:
     * timestamp,instrument,level,price
     *
     * @param file destination file (will be created if doesn't exist)
     * @param instrument selected instrument
     * @param level selected level
     * @throws java.io.IOException on write errors
     * @throws IllegalArgumentException when inputs are invalid
     */
    void saveSelection(java.io.File file, String instrument, String level) throws java.io.IOException;
}
