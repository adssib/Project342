package Geography;

import Services.Offering;
import UserManagment.Instructor;

import java.util.ArrayList;

public class Organisation {
    private final String name;

    //This should be Spaces not Locations
    private ArrayList<Location> locations;

    private ArrayList<Instructor> instructors;
    private ArrayList<Offering> offerings;

    public Organisation(String name) {
        this.name = name;
        this.locations=new ArrayList<Location>();
    }

    public String getName() {
        return name;
    }
    public ArrayList<Location> getLocations() {
        return locations;
    }
    public void addLocation(Location location) {
        locations.add(location);
    }
    public void setLocations(ArrayList<Location> loc){
        this.locations=loc;
    }
    public void setOfferings(ArrayList<Offering> offer){
        this.offerings=offer;
    }
    public void addOffering(Offering offer){
        this.offerings.add(offer);
    }
    public ArrayList<Offering> getOfferings() {
        return offerings;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<Instructor> getInstructors() {
        return this.instructors;
    }


}
