package Services.Lesson;

import Geography.Location;

public class PrivateLesson extends Lesson{

    public PrivateLesson(int LessonId, Location location, String TypeOfLesson) {
        this.location = location;
        this.LessonId = LessonId;
        this.TypeOfLesson = TypeOfLesson;
        this.size = 1 ;
    }

    private void setSize(int Size){
        throw new UnsupportedOperationException();
    }
}
