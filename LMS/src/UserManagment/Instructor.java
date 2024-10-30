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

    public boolean takeOffering(Offering offering) {
        if (this.Available.contains(offering.getLocation().getCity()) &&
                this.Specialisation.equals(offering.getLesson().getTypeOfLesson())) {
            offering.setInstructor(this);
            this.TakenOfferings.add(offering);
            return true;
        }
        return false;
    }
}