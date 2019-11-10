package app;

public abstract class Person {
    private String name;
    private char gender;
    private int age;
    private String email;
    private String password;
    /** */
    public Person() {
        this.name = "";
        this.gender = '0';
        this.age = 0;
        this.email = "";
        this.password = "";
    }
    /**
     * 
     * @param n
     * @param g
     * @param a
     */
    public Person(String n, char g, int a) {
        this.name = n;
        this.gender = g;
        this.age = a;
    }
    /**
     * 
     * @param n
     * @param g
     * @param a
     * @param e
     * @param p
     */
    public Person(String n, char g, int a, String e, String p) {
        this.name = n;
        this.gender = g;
        this.age = a;
        this.email = e;
        this.password = p;
    }
    /**
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }
    /**
     * 
     * @return
     */
    public char getGender() {
        return this.gender;
    }
    /**
     * 
     * @return
     */
    public int getAge() {
        return this.age;
    }
    /**
     * 
     * @return
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * 
     * @return
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @param gend
     */
    public void setGender(char gend) {
        this.gender = gend;
    }
    /**
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @param pass
     */
    public void setPassword(String pass) {
        this.password = pass;
    }
} 