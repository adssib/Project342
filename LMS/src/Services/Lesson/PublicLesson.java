package Services.Lesson;

import Geography.Location;

public class PublicLesson extends Lesson{

    private int size;

    public PublicLesson(int LessongId, Location l, String description, int size){
        this.size = size;
        this.location = l ;
        this.LessonId = LessongId;
        this.TypeOfLesson = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
