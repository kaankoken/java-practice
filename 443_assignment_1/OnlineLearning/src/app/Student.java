package app;

import java.util.*;
import app.Trainee;
public class Student extends Trainee implements IPerformance{
    final float CREDIT = (float)0.8;
    private String institution;
    /** */
    public Student() {
        super();
        this.institution = "";
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
     * @param institution
     */
    public Student(String name, char gender, int age, String email, String password,
        boolean premium, List<Course> enrolled, String institution) {
        super(name, gender, age, email, password, premium, enrolled);
        this.institution = institution;
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
        return premiumCourseCount;
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
        return (a - b);
    }
    /**
     * 
     * @return
     */
    public String getInstitution() {
        return this.institution;
    }
    /**
     * 
     * @param inst
     */
    public void setInstitution(String inst) {
        this.institution = inst;
    }
}