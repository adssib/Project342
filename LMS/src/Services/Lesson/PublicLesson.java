package Services.Lesson;

public class PublicLesson {

    private int size ;
    private Boolean isFull ;

    public PublicLesson(int size, Boolean isFull) {
        this.size = size;
        this.isFull = isFull;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Boolean getIsFull() {
        return isFull;
    }
    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }
}
