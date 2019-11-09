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
        System.out.println("**Welcome To Online Learning Platform**");

        do {
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
                    break;
                case "2":
                    Trainee person = new Trainee();
                    boolean result;
                    do {
                        result = this.login(this.trainee, person);
                        System.out.println();
                    } while (result == false);
                    
                    this.subMenu(person);
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
            System.out.print("Atleast one field is empty\n" + "Please re-try to Signup");
            return null;
        }

        boolean isExist = this.isExist(newTrainee.getEmail(), this.trainee);
        if (isExist == true) {
            System.out.println("This email is already in use\n" + "Please try again with different email");
            return null;
        }
        //System.out.println(newTrainee.getName());
        return newTrainee;
    }

    public boolean login(List<Trainee> traineeList, Trainee person) {
        Scanner input =  new Scanner(System.in);

        System.out.println("Please Enter Login Informations");
        System.out.print("Email: ");
        String email = input.nextLine();
        
        System.out.print("Password: ");
        String pass = input.nextLine();

        Trainee p = this.authenticate(traineeList, pass, email);

        if (p != null) {
            System.out.println("Login is succesful");
            this.updateTrainee(p, person);
            return true;
        }
        System.out.println("Login is failed. Please try again\n");
        person = null;
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
    public Trainee changeToPremium(Trainee person) {
        Scanner input = new Scanner(System.in);

        System.out.println("Would you like to change your account to premium?");
        System.out.print("Your Choice (Y/N): ");
        
        char choice = input.nextLine().charAt(0); 
        
        if (choice == 'y') {
            if (person.getPremium() == true)
                System.out.println("Your account has already premium!!!\n");
            else {
                person.setPremium(true);
                System.out.println("Account has been changed to premium!!!\n");
            }
 
        }
        else
            System.out.println("Operation is cancelled!!!\n");
        return person;
    }

    public void listAllCourses(boolean premiumStat) {
        for (Course course : this.courses) {
            if (course.premium == premiumStat) {
                System.out.println("Course Name: " + course.courseName);
                System.out.println("Duration : " + course.duration);
                System.out.println("Instructor: " + course.instructor.getName() + "\n");
            }
        }
    }   

    public void listEnrolledCourses(Trainee person) {
        for(Course course: person.getCourses()) {
            System.out.println("Course Name: " + course.courseName);
            System.out.println("Duration : " + course.duration);
            System.out.println("Instructor: " + course.instructor.getName());
            System.out.println("Premium: " + course.premium + "\n");
        }
    }

    public boolean logout() {
        return false;
    }

    public boolean exit() {
        return false;
    }

    public void subMenu(Trainee person) {
        Scanner input = new Scanner(System.in);
        boolean condition = true;

        do {
            System.out.println("(1)List All Courses\n" + "(2)Add Course\n" + "(3)Change Account Type\n" + "(4)Logout");
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
                    this.changeToPremium(person);
                    break;
                case "4":
                    System.out.println("Logging out!!!\n");
                    condition = this.logout();
                    break;
                default:
                    System.out.println("Not a valid option\n");
                    break;
            }
        } while (condition == true);
    }
}