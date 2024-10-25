package Geography;

public class Space {

    private Location locationOfSpace;
    private String Description;

    public Space(String description, Location locationOfSpace) {
        this.Description = description;
        this.locationOfSpace = locationOfSpace;
    }

    public Location getLocationOfSpace() {
        return locationOfSpace;
    }

    public void setLocationOfSpace(Location locationOfSpace) {
        this.locationOfSpace = locationOfSpace;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
