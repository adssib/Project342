package Services.Lesson;

public class PublicLesson extends Lesson{

    public PublicLesson(int LessonId, String description, int size){
        this.size = size;
        this.LessonId = LessonId;
        this.TypeOfLesson = description;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
