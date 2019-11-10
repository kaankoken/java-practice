package app;

import java.util.*;
import app.Trainee;
public class Student extends Trainee implements IPerformance{
    final float CREDIT = (float)0.8;
    private String institution;
    /**It is the base constructor without any parameters */
    public Student() {
        super();
        this.institution = "";
    }
    /**
     * It is the second constructor with full parameters
     * @param name String
     * @param gender Char
     * @param age Integer
     * @param email String
     * @param password String
     * @param premium Boolean
     * @param enrolled List<Course>
     * @param institution String
     */
    public Student(String name, char gender, int age, String email, String password,
        boolean premium, List<Course> enrolled, String institution) {
        super(name, gender, age, email, password, premium, enrolled);
        this.institution = institution;
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
        return premiumCourseCount;
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
        return (a - b);
    }
    /**
     * get institution variable
     * @return String
     */
    public String getInstitution() {
        return this.institution;
    }
    /**
     * set institution variable
     * @param inst String: institution
     */
    public void setInstitution(String inst) {
        this.institution = inst;
    }
}