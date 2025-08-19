/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Series - contains working methods for the application.
 * Methods:
 * - addSeries / CaptureSeries (we call it addSeries to accept a SeriesModel)
 * - searchSeries
 * - updateSeries
 * - deleteSeries
 * - seriesReport (get list)
 * - isValidAge - helper for validation
 *
 * This class contains logic separated from I/O so it can be unit tested.
 */
public class Series {
    private final List<SeriesModel> seriesList = new ArrayList<>();

    // Adds a new series if SeriesId is unique. Returns true if added.
    public boolean addSeries(SeriesModel model) {
        if (model == null || model.SeriesId == null || model.SeriesId.trim().isEmpty()) {
            return false;
        }
        if (searchSeries(model.SeriesId) != null) {
            // duplicate id
            return false;
        }
        seriesList.add(model);
        return true;
    }

    // Search for a series by id. Returns the model or null if not found.
    public SeriesModel searchSeries(String id) {
        if (id == null) return null;
        for (SeriesModel s : seriesList) {
            if (id.equalsIgnoreCase(s.SeriesId)) return s;
        }
        return null;
    }

    /**
     * Update a series fields. Any field that is null will not be updated.
     * Returns true if update succeeded (series found and new values valid).
     */
    public boolean updateSeries(String id, String newName, String newAge, String newNumberOfEpisodes) {
        SeriesModel found = searchSeries(id);
        if (found == null) return false;

        if (newName != null && !newName.trim().isEmpty()) {
            found.SeriesName = newName;
        }

        if (newAge != null && !newAge.trim().isEmpty()) {
            if (!isValidAge(newAge)) return false;
            found.SeriesAge = newAge;
        }

        if (newNumberOfEpisodes != null && !newNumberOfEpisodes.trim().isEmpty()) {
            // ensure episodes is numeric (integer >= 0)
            try {
                int eps = Integer.parseInt(newNumberOfEpisodes);
                if (eps < 0) return false;
                found.SeriesNumberOfEpisodes = newNumberOfEpisodes;
            } catch (NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }

    // Delete a series by id. Returns true if removed.
    public boolean deleteSeries(String id) {
        SeriesModel found = searchSeries(id);
        if (found == null) return false;
        return seriesList.remove(found);
    }

    // Return the full report (list) - used for display
    public List<SeriesModel> seriesReport() {
        return new ArrayList<>(seriesList); // return copy to prevent external modification
    }

    // Helper: validate the age string is numeric and between 2 and 18 inclusive
    public static boolean isValidAge(String ageStr) {
        if (ageStr == null) return false;
        ageStr = ageStr.trim();
        try {
            int age = Integer.parseInt(ageStr);
            return age >= 2 && age <= 18;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
