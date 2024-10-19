package user;


import java.util.ArrayList;
import java.util.List;

import offering.OfferingItem;
import organisation.City;

public class Instructor implements User {
    private final String name;
    private String phone;
    private String speciality;
    private String password;

    private ArrayList<OfferingItem> offeringItems = new ArrayList<OfferingItem>();

    private List<City> availableCities = new ArrayList<City>();

    public Instructor(String name, String password, String phone, String speciality, List<City> availableCities) {
        this.name = name;
        this.phone = phone;
        this.speciality = speciality;
        this.password = password;
        this.availableCities = availableCities;
    }
    public String getName() {
        return name;
    }
    public void addOffering(OfferingItem offeringItem) {
        offeringItems.add(offeringItem);
    }



    public int login(String name,String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            return 1;
        } else {
            return 0;
        }
    }
    public void displayOfferingItems(){
        for(var o:offeringItems){
            System.out.println(o.toStringForInstructors());
        }
    }

    public String toString() {
        String availability="";
        int i=0;
        for(City city: availableCities){
            i++;
            availability+=city.getName();
            if(i>1 &&i<availableCities.size()-1){
                availability+=", ";
            } else if (i==availableCities.size()-1) {
                availability+=" and ";
            }
        }
        return  name + "(" + phone+ ")"+ "is a " + speciality+ " instructor, available to work in "+availability;
    }


    public String getSpeciality() {
        return speciality;
    }
}
