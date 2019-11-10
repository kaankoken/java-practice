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
     * @param n String: name
     * @param g Char: gender
     * @param a Integer: age
     */
    public Person(String n, char g, int a) {
        this.name = n;
        this.gender = g;
        this.age = a;
    }
    /**
     * It is constructor with full parameters
     * it sets name, gender, age, email and password
     * @param n String: name
     * @param g Char: gender
     * @param a Integer: age
     * @param e String: email
     * @param p String password
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
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * it set gender variable
     * @param gend String: gender
     */
    public void setGender(char gend) {
        this.gender = gend;
    }
    /**
     * it sets age variable
     * @param age Integer
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * It sets email variable
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * it sets password variable
     * @param pass String: password
     */
    public void setPassword(String pass) {
        this.password = pass;
    }
} 