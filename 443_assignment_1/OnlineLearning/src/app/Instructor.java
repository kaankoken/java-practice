package app;
import app.Person;
public class Instructor extends Person {
    public int ID;
    /** It is a base constructor without any parameters*/
    public Instructor() {
        super();
        this.ID = 0;
    }
    /**
     * As a parameter it takes id, name, gender and age
     * @param id
     * @param n
     * @param g
     * @param a
     */
    public Instructor(int id, String n, char g, int a) {
        super(n, g, a);
        this.ID = id;
    }
    /**
     * It returns id of instructor
     * @return int
     */
    public int getId() {
        return this.ID;
    }
    /**
     * it sets id
     * @param id
     */
    public void setId(int id) {
        this.ID = id;
    }
}