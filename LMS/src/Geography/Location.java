package Geography;

import Services.Lesson.Lesson;
import TimeManagement.Scheduale;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Scheduale> schedualeList ;
    private City city;
    private Lesson lesson ;

    public Location(City city, Lesson lesson) {
        this.city = city;
        this.lesson = lesson;
        schedualeList = new ArrayList<>();
    }

    public City getCity() {
        return city;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public List<Scheduale> getSchedualeList() {
        return schedualeList;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setSchedualeList(List<Scheduale> schedualeList) {
        this.schedualeList = schedualeList;
    }
}
