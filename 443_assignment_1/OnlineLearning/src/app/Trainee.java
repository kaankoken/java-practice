package app;
import java.util.ArrayList;
import app.Course;

public class Trainee {
    private ArrayList<Course> enrolled;
    private Boolean premium;

    public Trainee() {
        this.enrolled = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return this.enrolled;
    }

    public Boolean getPremium() {
        return this.premium;
    }

    public void setCourses(Course c) {
        this.enrolled.add(c);
    }

    public void setPremium(Boolean pre) {
        this.premium = pre;
    }
    
}