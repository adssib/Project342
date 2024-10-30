package Data.Geography;

import Geography.City;

import java.util.ArrayList;

public class CityDataGenerator {
    public static ArrayList<City> generateCities() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Montreal"));
        cities.add(new City("Toronto"));
        cities.add(new City("Vancouver"));
        // Add more cities as needed
        return cities;
    }
}