package app;
import app.Person;
public class Instructor extends Person {
    public int ID;
    /** */
    public Instructor() {
        super();
        this.ID = 0;
    }
    /**
     * 
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
     * 
     * @return
     */
    public int getId() {
        return this.ID;
    }
    /**
     * 
     * @param id
     */
    public void setId(int id) {
        this.ID = id;
    }
}