package Services.Lesson;

import Geography.Location;

public class PublicLesson extends Lesson{

    public PublicLesson(int LessonId, Location l, String description, int size){
        this.size = size;
        this.location = l ;
        this.LessonId = LessonId;
        this.TypeOfLesson = description;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
