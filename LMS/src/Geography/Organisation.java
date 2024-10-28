package Geography;

import Services.Offering;
import UserManagment.Instructor;

import java.util.ArrayList;

public class Organisation {
    private final String name;

    //This should be Spaces not Locations
    private ArrayList<Space> Spaces;

    private ArrayList<Instructor> instructors;
    private ArrayList<Offering> offerings;

    public Organisation(String name) {
        this.name = name;
        this.Spaces=new ArrayList<Space>();
    }

    public String getName() {
        return name;
    }
    public ArrayList<Space> getLocations() {
        return Spaces;
    }
    public void addLocation(Space space) {
        Spaces.add(space);
    }
    public void setLocations(ArrayList<Space> loc){
        this.Spaces=loc;
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
