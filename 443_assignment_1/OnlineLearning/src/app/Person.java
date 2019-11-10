package app;

public abstract class Person {
    private String name;
    private char gender;
    private int age;
    private String email;
    private String password;

    /** It is the base constructor without any parameters*/
    public Person() {
        this.name = "";
        this.gender = '0';
        this.age = 0;
        this.email = "";
        this.password = "";
    }
    /**
     * It is constructor with 3 variable
     * It sets name, gender age
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
     * It is constructor with full parameters
     * it sets name, gender, age, email and password
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
     * it gets name variable
     * @return String
     */
    public String getName() {
        return this.name;
    }
    /**
     * it gets gender variable
     * @return char
     */
    public char getGender() {
        return this.gender;
    }
    /**
     * it gets age variable
     * @return int
     */
    public int getAge() {
        return this.age;
    }
    /**
     * It gets email variable
     * @return String
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * it gets password variable
     * @return String
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * it sets name variable
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * it set gender variable
     * @param gend
     */
    public void setGender(char gend) {
        this.gender = gend;
    }
    /**
     * it sets age variable
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * It sets email variable
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * it sets password variable
     * @param pass
     */
    public void setPassword(String pass) {
        this.password = pass;
    }
} 