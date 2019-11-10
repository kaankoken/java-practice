package app;

import java.util.*;
import app.Trainee;
public class NonStudent extends Trainee implements IPerformance {
    final float CREDIT = (float)0.4;
    private String job;
    private String position;
    /**It is the base constructor without any parameters */
    public NonStudent() {
        super();
        this.job = "";
        this.position = "";
    }
    /**
     * It is the second constructor with full parameters
     * @param name String
     * @param gender Char
     * @param age Integer
     * @param email String
     * @param password String
     * @param premium Boolean 
     * @param enrolled List
     * @param job String
     * @param position String
     */
    public NonStudent(String name, char gender, int age, String email, String password,
            boolean premium, List<Course> enrolled, String job, String position) {
        super(name, gender, age, email, password, premium, enrolled);
        this.job = job;
        this.position = position;
    }
    /**
     * It is implemented based on IPerformance
     * Counts # of premium courses
     * and multiplies with CREDIT constant
     * @param person Trainee
     * @return float
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
     * According to given calculation, it counts
     * # of premium courses and multiplies with 10
     * then calls credit method for # of credits
     * @param person Trainee
     * @return float
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
     * returns job variable
     * @return String
     */
    public String getJob() {
        return this.job;
    }
    /**
     * returns position variable
     * @return String
     */
    public String getPosition() {
        return this.position;
    }
    /**
     * set job variable
     * @param job String 
     */
    public void setJob(String job) {
        this.job = job;
    }
    /**
     * set position variable
     * @param pos String
     */
    public void setPosition(String pos) {
        this.position = pos;
    }
}