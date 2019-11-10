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
     * @param id Integer: id of instructor
     * @param n String: name of instructor
     * @param g Char: gender of instructor
     * @param a Integer: age of instructor
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
     * @param id Integer: Id of instructor
     */
    public void setId(int id) {
        this.ID = id;
    }
}