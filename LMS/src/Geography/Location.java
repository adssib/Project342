package Geography;

import Services.Lesson.Lesson;
import TimeManagement.Schedule;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Schedule> scheduleList;
    private City city;
    private Lesson lesson ;

    public Location(City city, Lesson lesson) {
        this.city = city;
        this.lesson = lesson;
        scheduleList = new ArrayList<>();
    }

    public City getCity() {
        return city;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public List<Schedule> getSchedualeList() {
        return scheduleList;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setSchedualeList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
