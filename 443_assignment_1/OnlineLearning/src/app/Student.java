package app;
public class Student implements IPerformance{
    private String institution;

    public Student() {

    }

    public float credit() {
        return (float)1;
    }

    public float monthlyFee() {
        return (float)1;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String inst) {
        this.institution = inst;
    }
}