package app;

import java.util.*;
import app.Trainee;
public class NonStudent extends Trainee implements IPerformance {
    final float creditMultiplier= (float)0.4;
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
    /** */
    public float credit() {
        return (float)1;
    }
    /**  */
    public float monthlyFee() {
        return (float)1;
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