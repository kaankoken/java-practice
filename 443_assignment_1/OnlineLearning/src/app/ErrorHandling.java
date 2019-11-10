package app;

import java.util.List;
import app.Trainee;
import app.Course;
public class ErrorHandling {
    /**This class implemented for helper methods and error checking */
    
    /**
     * check whether any field empty or not
     * if any filed is empty return false
     * @param input Trainee: field check object
     * @return boolean
     * 
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
     * check existance of the email in the system
     * if the email exist return true
     * @param email String: email for existance check
     * @param traineeList List<Trainee>: object for existance check
     * @return boolean
     */
    public boolean isExist(String email, List<Trainee> traineeList) {
        for(Trainee t: traineeList) {
            if (t.getEmail().equals(email))
                return true;
        }
        return false;
    }
    /**
     * checks whether email and password in the system
     * if in the system return trainee object
     * @param input Trainee 
     * @param Pass String 
     * @param Email String
     * @return Trainee
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
     * it is updating given trainee object
     * @param src Trainee: source object
     * @param dest Trainee: destination object
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
     * It is helper method that lists the instructors with name and id
     * @param instructorList List<Instructor>: for printing
     */
    public void listInstructor(List<Instructor> instructorList) {
        System.out.println("-------- List of Instructors --------");
        for (Instructor i: instructorList)
            System.out.println("ID: " + i.getId() + " Instructor Name: " + i.getName());
    }
}