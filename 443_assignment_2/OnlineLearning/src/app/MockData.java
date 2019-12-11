package app;

import java.util.*;
/**
 * This is a helper class that creates mock data for the system
 * It can be generated for any type which are Course,
 * Instructor and Trainee
 * @param <T> Generic Type: class creation
 */
@SuppressWarnings("unchecked")
public class MockData<T> {
    private List<T> temp;
    /** */
    public MockData() {
        this.temp =  new ArrayList<T>();
    }
    /**
     * It generates mock data according to its type
     * and initilialize the types with parameters
     * @param type String: Type of generic object(Course, Instructor etc)
     * @param size Integer: Mock data depends on the size
     */
    public void generateMockData(String type, int size) {
        for (int i = 0; i < size; i++) {
            if (type == "Course") { 
                this.temp.add((T) new Course(
                    new Instructor(i, "name" + i, 'F', 12 + i),
                    "course" + i,
                    (float) (52.1 + i),
                    /**random generator allow to create dynamically premium and 
                     * non premium classes
                     */
                    this.generateRandomValue(2) == 0 ? false: true
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
     * It returns list of generic type object that created
     * in generateMockData
     * @return List: T is generic type
     */
    public List<T> getData() {
        return temp;
    }
    /**
     * Creates random values in order to
     * make variation
     * @param range
     * @return
     */
    private double generateRandomValue(int range) {
        double randomValue = (int) (Math.random() *((range - 0))) + 0;
        return randomValue;
    }
}