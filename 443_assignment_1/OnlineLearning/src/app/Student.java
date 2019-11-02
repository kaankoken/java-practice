package app;

import java.util.*;
import app.Trainee;
public class Student extends Trainee implements IPerformance{
    final float creditMultiplier = (float)0.8;
    private String institution;

    public Student() {
        super();
        this.institution = "";
    }

    public Student(String name, char gender, int age, String email, String password,
        boolean premium, List<Course> enrolled, String institution) {
        super(name, gender, age, email, password, premium, enrolled);
        this.institution = institution;
    }

    public float credit() {
        //count the number of premium courses
        return (float)1;
    }

    public float monthlyFee() {
        return (float)1;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String inst) {
        this.institution = inst;
    }
}