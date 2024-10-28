package UserManagment;

import Geography.City;
import Services.Offering;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private List<City> Available ;
    private List<Offering> TakenOfferings ;
    private String Specialisation;

    public Instructor(int userId, String user, String password, String phoneNumber, String specialisation) {
        super(userId, user, password, phoneNumber);
        this.Specialisation = specialisation;
        this.Available = new ArrayList<City>();
        this.TakenOfferings = new ArrayList<Offering>() ;
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

    public void TakeOffering(int OfferingId){
        //Search for the correct offering
        //add it to the taken offerings Class
    }
    /**
     * TODO:
     * + TakeOffering(OfferingId : int) : void
     * + viewOfferings() : void
     * + viewTakenOffering() : void DONE
     * + getAvaibleCities() : List<City> DONE
     * + setAvaibleCities( c : List<City>) : void DONE
     * + getSpecfication() : String DONE
     * + setSpecification( spec : String) : void DONE
     * + Instructor(Username: String , password: String, phoneNumeber: String, spec: String , cities: List<City> ) DONE
     */
}
