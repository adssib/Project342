package UserManagment;

import Geography.City;
import Services.Offering;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private List<City> Available;
    private List<Offering> TakenOfferings;
    private String Specialisation;

    public Instructor(int userId, String user, String password, String phoneNumber, String specialisation) {
        super(userId, user, password, phoneNumber);
        this.Specialisation = specialisation;
        this.Available = new ArrayList<City>();
        this.TakenOfferings = new ArrayList<Offering>();
    }

    public List<City> getAvailable() {
        return Available;
    }

    public void setAvailable(List<City> available) {
        Available = available;
    }

    public List<Offering> getTakenOfferings() {
        return TakenOfferings;
    }

    public void setTakenOfferings(List<Offering> takenOfferings) {
        TakenOfferings = takenOfferings;
    }

    public String getSpecialisation() {
        return Specialisation;
    }

    public void setSpecialisation(String specialisation) {
        Specialisation = specialisation;
    }

    public void TakeOffering(int OfferingId) {
        // Assuming we have access to all offerings
        List<Offering> allOfferings = Offering.getAllOfferings(); // This needs to be implemented in Offering class

        Offering offeringToTake = null;
        for (Offering offering : allOfferings) {
            if (offering.getOfferingId() == OfferingId) {
                offeringToTake = offering;
                break;
            }
        }

        if (offeringToTake != null) {
            TakenOfferings.add(offeringToTake);
            System.out.println("Offering " + OfferingId + " has been taken.");
        } else {
            System.out.println("Offering " + OfferingId + " not found.");
        }
    }
}