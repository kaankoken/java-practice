package app;
import app.Instructor;
public class Course {
    public Instructor instructor;
    public String courseName;
    public float duration;
    public Boolean premium;

    public Course() {
        this.instructor =  new Instructor();
        this.courseName = "";
        this.duration = (float)1;
        this.premium = false;
    }

    public Course (Instructor instructor, String courseName, float duration, Boolean premium) {
        this.courseName = courseName;
        this.duration = duration;
        this.premium = premium;
        this.instructor= instructor;
    }
}