package app;

import java.util.List;
import java.util.Scanner;
import app.Course;
import app.Trainee;
import app.Instructor;
import app.ErrorHandling;

/**
 * @author Kaan Taha Köken
 * @see <a href=
 *      "https://github.com/kaankoken/java-practice/tree/master/443_assignment_1">Github</a>
 */

public class OnlineLearningApplication extends ErrorHandling {
    public List<Instructor> instructors;
    public List<Trainee> trainee;
    public List<Course> courses;

    public OnlineLearningApplication() {
        super();
        MockData<Course> mockCourse = new MockData<>();
        mockCourse.generateMockData("Course", 5);
        this.courses = mockCourse.getData();

        MockData<Trainee> mockTrainee = new MockData<>();
        mockTrainee.generateMockData("Trainee", 6);
        this.trainee = mockTrainee.getData();

        MockData<Instructor> mockInstructor = new MockData<>();
        mockInstructor.generateMockData("Instructor", 3);
        this.instructors = mockInstructor.getData();
    }

    public static void main(String[] args) throws Exception {

        OnlineLearningApplication application = new OnlineLearningApplication();

        application.menu(application.trainee);

        // for (int i = 0; i < app.courses.size(); i++) {
        // System.out.println(app.courses.get(i).courseName);
        // }
    }

    public void menu(List<Trainee> traineeList) {
        String option;

        System.out.println("**Welcome To Online Learning Platform**");
        System.out.println("Menu\n" + "(1)Signup\n" + "(2)Login");
        System.out.print("Your Choice: ");
        
        Scanner readInput = new Scanner(System.in);
        option = readInput.nextLine();
        
        switch (option) {
            case "1":
                Trainee isNullSignUp;
                
                do {
                    isNullSignUp = this.signup();
                    if (isNullSignUp != null)
                        traineeList.add(isNullSignUp);
                    System.out.println();
                } while (isNullSignUp == null);
                
                //this.login();
                break;
            case "2":
                //this.login();
                System.out.println("Hello Java2");
                break;
            default:
                break;
        }
    }

    public Trainee signup() {
        Trainee newTrainee =  new Trainee();
        Scanner input = new Scanner(System.in);

        System.out.print("Name: ");
        newTrainee.setName(input.nextLine());

        System.out.print("Age: ");
        newTrainee.setAge(input.nextInt());
        input.nextLine();
        System.out.print("Gender (F/M): ");
        newTrainee.setGender(input.nextLine().charAt(0));

        System.out.print("Email: ");
        newTrainee.setEmail(input.nextLine());

        System.out.print("Password: ");
        newTrainee.setPassword(input.nextLine());
        
        boolean isEmpty = this.isEmpty(newTrainee);
        if (isEmpty == false) {
            System.out.print("Atleast one field is empty" + "\n" + "Please re-try to Signup");
            return null;
        }
        //System.out.println(newTrainee.getName());
        return newTrainee;
    }

    public boolean login() {

    }
// 
    // public Trainee addCourse() {
// 
    // }
// 
    // public Trainee deleteCourse() {
// 
    // }
// 
    // public void getInstructorDetails() {
// 
    // }
// 
    // public Trainee changeToPremium() {
// 
    // }
// 
    // public void listAllCourses() {
// 
    // }
// 
    // public void listEnrolledCourses() {
// 
    // }
// 
    // public void logout() {
// 
    // }
// 
    // public void exit() {
        // 
    // }
}