package app;

import java.util.*;
import app.Course;
import app.Person;
public class Trainee extends Person {
    private List<Course> enrolled;
    private Boolean premium;

    public Trainee() {
        super();
        this.enrolled = new ArrayList<Course>();
        this.premium = false;
    }

    public Trainee(String name, char gender, int age, String email,
        String password, Boolean premium, List<Course> enrolled) {
        super(name, gender, age, email, password);
        this.enrolled = enrolled;
        this.premium = premium;
    }

    public List<Course> getCourses() {
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