/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author lab_services_student
 */
/**
 * SeriesModel - matches the model in the assignment
 * Fields kept public to mirror the spec, but we also provide constructors/toString.
 */
public class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    public SeriesModel() { }

    public SeriesModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.SeriesId = seriesId;
        this.SeriesName = seriesName;
        this.SeriesAge = seriesAge;
        this.SeriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    @Override
    public String toString() {
        return "SeriesModel{" +
                "SeriesId='" + SeriesId + '\'' +
                ", SeriesName='" + SeriesName + '\'' +
                ", SeriesAge='" + SeriesAge + '\'' +
                ", SeriesNumberOfEpisodes='" + SeriesNumberOfEpisodes + '\'' +
                '}';
    }
}
