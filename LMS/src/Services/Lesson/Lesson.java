package Services.Lesson;

import Geography.Location;

public abstract class Lesson {
    protected int LessonId ;
    protected String TypeOfLesson ; //Swimming, Ping Pong, ..... etc
    protected int size;

    public String getTypeOfLesson() {
        return TypeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        TypeOfLesson = typeOfLesson;
    }

    public int getLessonId() {
        return LessonId;
    }

    public void setLessonId(int lessonId) {
        LessonId = lessonId;
    }

    public int getSize() {
        return size;
    }
}
