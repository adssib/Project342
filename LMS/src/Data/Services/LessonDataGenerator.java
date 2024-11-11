//package Data.Services;
//
//import Services.Lesson.*;
//
//import java.util.ArrayList;
//
//public class LessonDataGenerator {
//    private static int lessonIdCounter = 1;
//
//    public static ArrayList<Lesson> generateLessons() {
//        ArrayList<Lesson> lessons = new ArrayList<>();
//        lessons.add(new PublicLesson(lessonIdCounter++, "Swimming", 10));
//        lessons.add(new PrivateLesson(lessonIdCounter++, "Yoga"));
//        lessons.add(new PublicLesson(lessonIdCounter++, "Judo", 15));
//        // Add more lessons as needed
//        return lessons;
//    }
//}