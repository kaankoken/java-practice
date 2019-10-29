package app;

import app.Person;

public class Instructor extends Person {
    public int ID;
    
    public Instructor() {
        super();
        this.ID = 0;
    }

    public Instructor(int id, String n, char g, int a) {
        super(n, g, a);
        this.ID = id;
    }

    public int getId() {
        return this.ID;
    }

    public void setId(int id) {
        this.ID = id;
    }
    //getter setter ?
}