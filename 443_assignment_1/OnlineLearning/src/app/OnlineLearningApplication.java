package app;

import java.util.List;
import java.util.NoSuchElementException;
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

    public OnlineLearningApplication(int sizeCourse, int sizeTrainee, int sizeInstructor) {
        super();
        MockData<Course> mockCourse = new MockData<>();
        mockCourse.generateMockData("Course", sizeCourse);
        this.courses = mockCourse.getData();

        MockData<Trainee> mockTrainee = new MockData<>();
        mockTrainee.generateMockData("Trainee", sizeTrainee);
        this.trainee = mockTrainee.getData();

        MockData<Instructor> mockInstructor = new MockData<>();
        mockInstructor.generateMockData("Instructor", sizeTrainee);
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
        Scanner readInput = new Scanner(System.in);
        boolean condition = true;

        do {
            System.out.println("**Welcome To Online Learning Platform**");
            System.out.println("Menu\n" + "(1)Signup\n" + "(2)Login\n" + "(3)Exit");
            System.out.print("Your Choice: ");
            String option = readInput.nextLine();

            switch (option) {
                case "1":
                    Trainee isNullSignUp;
                    
                    do {
                        isNullSignUp = this.signup();
                        if (isNullSignUp != null)
                            traineeList.add(isNullSignUp);
                        System.out.println();
                    } while (isNullSignUp == null);
                case "2":
                    boolean result;
                    do {
                        result = this.login(this.trainee);
                        System.out.println();
                    } while (result == false);
                    
                    this.subMenu();
                    break;
                case "3":
                    System.out.println("Exiting from the system. Goodbye!!!");
                    condition = this.exit();
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        } while (condition == true);
        readInput.close();
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

    public boolean login(List<Trainee> traineeList) {
        Scanner input =  new Scanner(System.in);

        System.out.println("Please Enter Login Informations");
        System.out.print("Email: ");
        String email = input.nextLine();
        
        System.out.print("Password: ");
        String pass = input.nextLine();

        boolean state = this.authenticate(traineeList, pass, email);

        if (state == true) {
            System.out.println("Login is succesful");
            return true;
        }
        System.out.println("Login is failed. Please try again");
        return false;
    }

    // public Trainee addCourse(Trainee person) {
        // Scanner input = new Scanner(System.in);
// 
        // System.out.print("Would you like to list the courses (Y/n): ");
        // char stat = input.nextLine().charAt(0);
// 
        // if (stat == 'y')
            // listAllCourses(person.getPremium());
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
    public void listAllCourses(boolean premiumStat) {
        for (Course course : this.courses) {
            if (course.premium == premiumStat) {
                System.out.println("Course Name: " + course.courseName);
                System.out.println("Duration : " + course.duration);
                System.out.println("Instructor: " + course.instructor.getName());
            }
        }
    }   
// 
    // public void listEnrolledCourses() {
// 
    // }
// 
    public boolean logout() {
        return false;
    }

    public boolean exit() {
        return false;
    }

    public void subMenu() {
        Scanner input = new Scanner(System.in);
        boolean condition = true;

        do {
            System.out.println("(1)List All Courses\n" + "(2)Add Course\n" + "(3)Logout");
            System.out.print("Your Choice: ");
            String option = input.nextLine();

            switch (option) {
                case "1":
                    this.listAllCourses(false);
                    break;
                case "2":
                    //this.addCourse
                    break;
                case "3":
                    System.out.println("Logging out!!!");
                    condition = this.logout();
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        } while (condition == true);
    }
}