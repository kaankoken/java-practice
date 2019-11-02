package app;

import java.util.*;
import app.Course;
import app.Person;
public class Trainee extends Person {
    private List<Course> enrolled;
    private boolean premium;

    public Trainee() {
        super();
        this.enrolled = new ArrayList<Course>();
        this.premium = false;
    }

    public Trainee(String name, char gender, int age,
        String email, String password) {
            super(name, gender, age, email, password);
            this.enrolled =  new ArrayList<>();
            this.premium = false;
    }

    public Trainee(String name, char gender, int age, String email,
        String password, boolean premium, List<Course> enrolled) {
            super(name, gender, age, email, password);
            this.enrolled = enrolled;
            this.premium = premium;
    }

    public List<Course> getCourses() {
        return this.enrolled;
    }

    public boolean getPremium() {
        return this.premium;
    }

    public void setCourses(Course c) {
        this.enrolled.add(c);
    }

    public void setPremium(boolean pre) {
        this.premium = pre;
    }
    
}