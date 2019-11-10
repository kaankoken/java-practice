package app;

import java.util.*;
import app.Course;
import app.Person;
public class Trainee extends Person {
    private List<Course> enrolled;
    private boolean premium;
    /**It is the base constructor witout any parameters */
    public Trainee() {
        super();
        this.enrolled = new ArrayList<Course>();
        this.premium = false;
    }
    /**
     * It is a constructor takes 5 parameters
     * @param name String
     * @param gender Char
     * @param age Integer
     * @param email String
     * @param password String
     */
    public Trainee(String name, char gender, int age,
        String email, String password) {
            super(name, gender, age, email, password);
            this.enrolled =  new ArrayList<>();
            this.premium = false;
    }
    /**
     * It is a constructor takes 7 parameters
     * @param name String
     * @param gender Char
     * @param age Integer
     * @param email String
     * @param password String 
     * @param premium Boolean
     * @param enrolled List<Course>
     */
    public Trainee(String name, char gender, int age, String email,
        String password, boolean premium, List<Course> enrolled) {
            super(name, gender, age, email, password);
            this.enrolled = enrolled;
            this.premium = premium;
    }
    /**
     * It gets list of enrolled courses
     * @return List<Course>
     */
    public List<Course> getCourses() {
        return this.enrolled;
    }
    /**
     * It gets premium status
     * @return boolean
     */
    public boolean getPremium() {
        return this.premium;
    }
    /**
     * It sets courses to enrolled courses
     * @param c Course: course to be added to entrolled list
     */
    public void setCourses(Course c) {
        this.enrolled.add(c);
    }
    /**
     * It sets premium status
     * @param pre Boolean: premium status
     */
    public void setPremium(boolean pre) {
        this.premium = pre;
    }
    
}