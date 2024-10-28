package Services;

import Geography.Location;
import Services.Lesson.Lesson;

import java.util.List;

public class Offering {

    private int OfferingId;
    private Lesson lesson;
    private Location location;
    private List<Offering> AllOfferings ;
    private List<Offering> PublicOfferings ;

    public Offering(int OfferingId, Lesson lesson, Location location) {
        this.OfferingId = OfferingId;
        this.lesson = lesson;
        this.location = location;
    }

    public int getOfferingId() {
        return OfferingId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Location getLocation() {
        return location;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
