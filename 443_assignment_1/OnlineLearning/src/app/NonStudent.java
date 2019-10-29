package app;

import java.util.*;
import app.Trainee;
public class NonStudent extends Trainee implements IPerformance {   
    private String job;
    private String position;

    public NonStudent() {
        super();
        this.job = "";
        this.position = "";
    }

    public NonStudent(String name, char gender, int age, String email, String password,
            Boolean premium, List<Course> enrolled, String job, String position) {
        super(name, gender, age, email, password, premium, enrolled);
        this.job = job;
        this.position = position;
    }

    public float credit() {
        return (float)1;
    }

    public float monthlyFee() {
        return (float)1;
    }

    public String getJob() {
        return this.job;
    }

    public String getPosition() {
        return this.position;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }
}