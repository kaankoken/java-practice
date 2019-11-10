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
     * @param instructor
     * @param courseName
     * @param duration
     * @param premium
     */
    public Course (Instructor instructor, String courseName, float duration, boolean premium) {
        this.courseName = courseName;
        this.duration = duration;
        this.premium = premium;
        this.instructor= instructor;
    }
}