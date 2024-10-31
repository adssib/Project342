package Geography;

import Services.Lesson.Lesson;
import TimeManagement.Schedule;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Schedule> schedules;
    private City city;
    private List<Lesson> lessons;
    private int LocationID;

    public Location(int locationId, City city) {
        this.LocationID = locationId;
        this.city = city;
        this.lessons = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public void setLocationID(int locationID) {
        LocationID = locationID;
    }

    public int getLocationID() {
        return LocationID;
    }

    public void addSchedule(Schedule schedule) {
        if (this.schedules == null) {
            this.schedules = new ArrayList<>();
        }
        this.schedules.add(schedule);
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Location{" +
                "ID=" + getLocationID() +
                ", City=" + (city != null ? city.getCityName() : "Not assigned") +
                '}';
    }
}
