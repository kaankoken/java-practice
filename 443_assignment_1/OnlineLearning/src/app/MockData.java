package app;

import java.util.*;

public class MockData<T> {
    private List<T> temp;
    
    public MockData() {
        this.temp =  new ArrayList<T>();
    }

    public void generateMockData(String type) {
        if (type == "Course") {
            this.temp.add((T) new Course(
                new Instructor(1, "name1", 'F', 12),
                "course1",
                (float) 52.1,
                false
            ));
        }
        else if (type == "Trainee") {
            System.out.println("x1");
        }
        else {
            System.out.println("x2");
        }
    }

    public List<T> getData() {
        return temp;
    }
}