package UserManagment;

public class Instructor extends User {

    public Instructor(int userId, String user, String password, String phoneNumber) {
        super(userId, user, password, phoneNumber);
    }

    /**
     * TODO:
     * + TakeOffering(OfferingId : int) : void
     * + viewOfferings() : void
     * + viewTakenOffering() : void
     * + getAvaibleCities() : List<City>
     * + setAvaibleCities( c : List<City>) : void
     * + getSpecfication() : String
     * + setSpecification( spec : String) : void
     * + Instructor(Username: String , password: String, phoneNumeber: String, spec: String , cities: List<City> )
     */
}
