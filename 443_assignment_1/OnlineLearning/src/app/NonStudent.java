package app;
public class NonStudent implements IPerformance {   
    private String job;
    private String position;

    public NonStudent() {
        
    }

    public float credit() {
        return (float)1;
    }

    public float monthlyFee() {
        return (float)1;
    }

    public String getJob() {
        return this.job;
    }

    public String getPosition() {
        return this.position;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }
}