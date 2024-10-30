package Geography;

import Services.Lesson.Lesson;
import TimeManagement.Schedule;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Schedule> schedules;
    private City city;
    private Lesson lesson ; //Can this be List of lessons?
    private int LessonId ;

    public Location(int lessonId, City city, Lesson lesson) {
        this.city = city;
        this.lesson = lesson;
        this.schedules = new ArrayList<>();
        this.LessonId = lessonId;
    }

    public City getCity() {
        return city;
    }

    public Lesson getLesson() {
        return lesson;
    }


    public void setCity(City city) {
        this.city = city;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setLessonId(int lessonId) {
        LessonId = lessonId;
    }

    public int getLessonId() {
        return LessonId;
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
}
