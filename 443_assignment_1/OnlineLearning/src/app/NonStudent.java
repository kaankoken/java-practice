package app;

import java.util.*;
import app.Trainee;
public class NonStudent extends Trainee implements IPerformance {
    final float CREDIT = (float)0.4;
    private String job;
    private String position;
    /** */
    public NonStudent() {
        super();
        this.job = "";
        this.position = "";
    }
    /**
     * 
     * @param name
     * @param gender
     * @param age
     * @param email
     * @param password
     * @param premium
     * @param enrolled
     * @param job
     * @param position
     */
    public NonStudent(String name, char gender, int age, String email, String password,
            boolean premium, List<Course> enrolled, String job, String position) {
        super(name, gender, age, email, password, premium, enrolled);
        this.job = job;
        this.position = position;
    }
    /**
     * 
     * @param person
     * @return
     */
    public float credit(Trainee person) {
        int premiumCourseCount = 0;
        for (Course c: person.getCourses()){
            if (c.premium == true)
                premiumCourseCount++;
        }

        premiumCourseCount *= CREDIT;
        return (float) premiumCourseCount;
    }
    /**
     * 
     * @param person
     * @return
     */
    public float monthlyFee(Trainee person) {
        float credit = this.credit(person);
        int premiumCourseCount = 0;
        
        for (Course c: person.getCourses()){
            if (c.premium == true)
                premiumCourseCount++;
        }

        int a = premiumCourseCount * 10;
        float b = a - credit;
        return (a - b) * 2;
    }
    /**
     * 
     * @return
     */
    public String getJob() {
        return this.job;
    }
    /**
     * 
     * @return
     */
    public String getPosition() {
        return this.position;
    }
    /**
     * 
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }
    /**
     * 
     * @param pos
     */
    public void setPosition(String pos) {
        this.position = pos;
    }
}