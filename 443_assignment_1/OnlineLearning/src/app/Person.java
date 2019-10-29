package app;

public abstract class Person {
    private String name;
    private char gender;
    private int age;
    private String email;
    private String password;

    public Person() {
        this.name = "";
        this.gender = '0';
        this.age = 0;
        this.email = "";
        this.password = "";
    }

    public Person(String n, char g, int a) {
        this.name = n;
        this.gender = g;
        this.age = a;
    }

    public Person(String n, char g, int a, String e, String p) {
        this.name = n;
        this.gender = g;
        this.age = a;
        this.email = e;
        this.password = p;
    }

    public String getName() {
        return this.name;
    }

    public char getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gend) {
        this.gender = gend;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
} 