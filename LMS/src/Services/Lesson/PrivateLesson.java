package Services.Lesson;

import Geography.Location;

public class PrivateLesson extends Lesson{

    private final int LessonSize = 1 ;

    public PrivateLesson(int LessonId, Location location, String TypeOfLesson) {
        this.location = location;
        this.LessonId = LessonId;
        this.TypeOfLesson = TypeOfLesson;
    }
}
