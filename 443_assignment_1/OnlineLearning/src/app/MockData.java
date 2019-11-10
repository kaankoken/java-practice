package app;

import java.util.*;
/**
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class MockData<T> {
    private List<T> temp;
    /** */
    public MockData() {
        this.temp =  new ArrayList<T>();
    }
    /**
     * 
     * @param type
     * @param size
     */
    public void generateMockData(String type, int size) {
        for (int i = 0; i < size; i++) {
            if (type == "Course") { 
                this.temp.add((T) new Course(
                    new Instructor(i, "name" + i, 'F', 12 + i),
                    "course" + i,
                    (float) (52.1 + i),
                    false
                ));
            }
            else if (type == "Trainee") {
                this.temp.add((T) new Trainee(
                    "name" + i,
                    'f',
                    12 + i,
                    "email" + i,
                    "password" + i));
            }
            else {
                this.temp.add((T) new Instructor(i, "n" + i, 'f', 15 + i));
            }
        }
    }
    /**
     * 
     * @return
     */
    public List<T> getData() {
        return temp;
    }
}