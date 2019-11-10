package app;

import java.util.List;
import app.Trainee;
import app.Course;
public class ErrorHandling {
    /**
     * 
     * @param input
     * @return
     */
    public boolean isEmpty(Trainee input) {
        if (input.getName().length() <= 1)
            return false;
        else {
            if (input.getGender() == '0')
                return false;
            else {
                if (input.getAge() == 0)
                    return false;
                else {
                    if (input.getEmail().length() <= 1)
                        return false;
                    else {
                        if (input.getPassword().length() <= 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * 
     * @param email
     * @param traineeList
     * @return
     */
    public boolean isExist(String email, List<Trainee> traineeList) {
        for(Trainee t: traineeList) {
            if (t.getEmail().equals(email))
                return true;
        }
        return false;
    }
    /**
     * 
     * @param input
     * @param Pass
     * @param Email
     * @return
     */
    public Trainee authenticate(List<Trainee> input, String Pass, String Email) {
        for(Trainee t: input) {
            if (t.getEmail().equals(Email) && t.getPassword().equals(Pass)) {
                return t;
            }
        }
        return null;
    }
    /**
     * 
     * @param src
     * @param dest
     */
    public void updateTrainee(Trainee src, Trainee dest) {
        dest.setAge(src.getAge());
        dest.setEmail(src.getEmail());
        dest.setGender(src.getGender());
        dest.setName(src.getName());
        dest.setPassword(src.getPassword());
        dest.setPremium(src.getPremium());

        for (Course c: src.getCourses())
            dest.setCourses(c);
    }
    /**
     * 
     * @param instructorList
     */
    public void listInstructor(List<Instructor> instructorList) {
        System.out.println("-------- List of Instructors --------");
        for (Instructor i: instructorList)
            System.out.println("ID: " + i.getId() + " Instructor Name: " + i.getName());
    }
}