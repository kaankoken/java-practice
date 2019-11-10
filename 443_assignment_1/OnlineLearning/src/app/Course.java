package app;
import app.Instructor;
public class Course {
    public Instructor instructor;
    public String courseName;
    public float duration;
    public boolean premium;
    /** It is the base constructor. It does not take any value */
    public Course() {
        this.instructor =  new Instructor();
        this.courseName = "";
        this.duration = (float)1;
        this.premium = false;
    }
    /**
     * It is constructor that takes parameters accourding to its parameters
     * @param instructor Instructor: object of course
     * @param courseName String: name of course 
     * @param duration Float: duration of course
     * @param premium Boolean: premium status of course
     */
    public Course (Instructor instructor, String courseName, float duration, boolean premium) {
        this.courseName = courseName;
        this.duration = duration;
        this.premium = premium;
        this.instructor= instructor;
    }
}