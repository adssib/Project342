package Geography;

public class City {
    private int CityID;
    String CityName;

    public City(String CityName) {
        this.CityName = CityName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

}
