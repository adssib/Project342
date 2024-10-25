package Services.Lesson;

import Geography.Location;

public abstract class Lesson {

    protected String TypeOfLesson ;
    protected Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTypeOfLesson() {
        return TypeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        TypeOfLesson = typeOfLesson;
    }
}
