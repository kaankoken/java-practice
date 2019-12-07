package app;

import javax.swing.*;

import app.SubMenuItem.AddCourse;
import app.SubMenuItem.EnrolledCourse;
import app.SubMenuItem.ListCourses;

import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.BorderLayout;

import java.util.*;
/**
 * Kaan Taha Köken 2152064 CNG 443 - Assignment 2
 * 
 * @author Kaan Taha Köken
 * @see <a href=
 *      "https://github.com/kaankoken/java-practice/tree/master/443_assignment_2">Github</a>
 */

public class OnlineLearningApplication extends ErrorHandling {
    public List<Instructor> instructors;
    public List<Trainee> trainee;
    public List<Course> courses;
    private JFrame frame;

    /** */
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

        frame = new JFrame("Online Learning Platform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
    }

    /**
     * 
     * @param sizeCourse     Integer: It accepts how many of mock data will created
     * @param sizeTrainee    Integer: It accepts how many of mock data will created
     * @param sizeInstructor Integer: It accepts how many of mock data will created
     */
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

    /**
     * It just calls the menu methods and rest of the programs starts to work.
     * 
     * @param args String
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        OnlineLearningApplication application = new OnlineLearningApplication();
        application.menu(application.trainee);
    }

    /**
     * This the main menu Operations start from here which are signup login and
     * exist
     * 
     * @param traineeList List: Created mock data program
     */
    public void menu(List<Trainee> traineeList) {
        JButton btnSign = new JButton("SignUp");
        JButton btnLogin = new JButton("Login");
        JButton btnExit = new JButton("Exit");

        signup(btnSign);
        login(traineeList, btnLogin);
        exit(btnExit);

        frame.getContentPane().add(btnSign, BorderLayout.CENTER);
        frame.getContentPane().add(btnLogin, BorderLayout.CENTER);
        frame.getContentPane().add(btnExit, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     * Takes all necessary parameters for signup
     * Name, Age, Gender, Email and Password from user.
     * First, checks whether any fields are empty then checks
     * if anybody has the same email. If anybody has same email
     * it does not allow to register.
     * (I assume that cannot be the email dublicate in the system)
     * @return Trainee
     */
    public void signup(JButton btnSign) {
        btnSign.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Signup signup = new Signup(frame);
                    JButton btnSignup = signup.getBtnSignup();
                    btnSignup.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Trainee temp =  new Trainee(signup.getName(),
                            signup.getGender().charAt(0), Integer.parseInt(signup.getAge()),
                            signup.getEmail(), signup.getPassword());
            
                            if (!isEmpty(temp)) {
                                JOptionPane.showMessageDialog(null,
                                "At least have problem on the fields",
                                "Sign Up",
                                JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                if (isExist(signup.getEmail(), trainee)) {
                                    JOptionPane.showMessageDialog(null,
                                    "E-mail exists in the system",
                                    "Sign Up",
                                    JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,
                                    "Account succesfully created",
                                    "Sign Up",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    trainee.add(temp);
                                    signup.closePanel();
                                }
                            }
                            signup.setName();
                            signup.setEmail();
                            signup.setPassword();
                            signup.setAge();
                            signup.setGender();
                        }
                    });
                    JButton btnCancel = signup.getBtnCancel();
                    btnCancel.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            signup.closePanel();
                        }
                    });

                    signup.setVisible(true);
                }
        });
    }
    /**
     * Takes 2 input from user, email and password
     * it searches inputs inside trainee list using authenticate
     * helper method. If returned object not null, it updates person object.
     * otherwise returns null;
     * @param traineeList List: Created mock data program 
     * @param person Trainee: logged in user inside mock data
     * @return boolean
     */
    public void login(List<Trainee> traineeList, JButton btnLogin) {
        btnLogin.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Login login = new Login(frame);
                    //login.login(frame, traineeList);
                    JButton btnLogin = login.getBtnLogin();
                    btnLogin.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Trainee person = authenticate(traineeList, login.getPassword(), login.getEmail());
                            if (person == null) {
                                JOptionPane.showMessageDialog(null,
                                "Invalid Username or Password",
                                "Login",
                                JOptionPane.ERROR_MESSAGE);
                                login.setEmail();
                                login.setPassword();
                            }
                            else {
                                JOptionPane.showMessageDialog(null,
                                "Login is Succesful",
                                "Login",
                                JOptionPane.INFORMATION_MESSAGE);
                                login.closePanel();
                                subMenu(person);
                            }
                        }
                    });

                    JButton btnCancel = login.getBtnCancel();
                    btnCancel.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            login.closePanel();
                        }
                    });
                    
                    login.setVisible(true);
                }
        });
    }
    /**
     * It searchs name of the course inside courseList
     * when it finds, adds to the enrolled courses. Otherwise give error messages
     * @param person Trainee: logged in user inside mock data
     * @param courseList List
     * @param courseName String: name of the course that going to added
     * @return TraineebtnAddCourse
     */
    public void addCourse(Trainee person, JButton btnAddCourse) {        
        btnAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                "Would you like to see Course list?",
                "List All Courses",
                JOptionPane.INFORMATION_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    ListCourses listOfCourses = new ListCourses(frame, getCourses(person));
                    listOfCourses.setVisible(true);
                }
                AddCourse course = new AddCourse(frame);
                JButton btnAdd = course.getBtnAdd();
                JButton btnCancel = course.getBtnCancel();

                btnAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boolean status = true;
                        int i = 0;
                        for (Course c: person.getCourses()) {
                            if (c.courseName.equals(course.getCourseField())) {
                                JOptionPane.showMessageDialog(null,
                                "This course has been already added",
                                "Add Course",
                                JOptionPane.ERROR_MESSAGE);
                                course.setCourseField();
                                status = false;
                            }
                        }
                        if (status == true) {
                            for (Course c: courses) {
                                if (c.courseName.equals(course.getCourseField())){
                                    person.setCourses(c);
                                    JOptionPane.showMessageDialog(null,
                                    "Course added succesfully",
                                    "Add Course",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    course.closePanel();
                                    i = 1;
                                }
                            }
                        }
                        if (status == false && i == 0) {
                            JOptionPane.showMessageDialog(null,
                            "Course could not added!!!",
                            "Add Course",
                            JOptionPane.ERROR_MESSAGE);
                            course.setCourseField();
                        }
                    }
                });

                btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        course.closePanel();
                    }
                });
                course.setVisible(true);
            }
        });
    }
    /**
     * It searchs inside enrolled courses. If it finds it,
     * deletes the course: Otherwise displays error message
     * @param person Trainee: logged in user inside mock data
     * @param courseName String: name of the course that going to be deleted
     * @return Trainee
     */
    public Trainee deleteCourse(Trainee person, JButton btnDeleteCourse) {
        boolean status = false;
        Iterator<Course> course = person.getCourses().iterator();

        if (person.getCourses().size() == 0)
            System.out.println("No course found. Please add course first");
    
        // while(course.hasNext()) {
            // if (course.next().courseName.equals(courseName)) {
                // course.remove();
                // status = true;
                // System.out.println("Course has been deleted succesfully\n");
            // }
        // }

        if (status == false)
            System.out.println("Course could not deleted\n");
        return person;
    }
    /**
     * checks whether Id match within the instructor list
     * if matchs, displays the instructor. otherwise displays error message
     * @param ID Integer: search instructor by id
     * @param instructorList List: Created mock data program 
     */
    public void getInstructorDetails(int ID, List<Instructor> instructorList) {
        boolean status = false;
        for (Instructor i: instructorList) {
            if (i.getId() == ID) {
                System.out.println("Instructor Name: " + i.getName());
                System.out.println("Age : " + i.getAge());
                System.out.println("Gender: " + i.getGender() +"\n");
                status = true;
            }
        }

        if (status == false) {
            System.out.println("ID of the instructor did not match please try again!!!\n");
        }
    }
    /**
     * It changes the person's premium status.
     * If the person already premium or cancel the operation
     * it displays messages accordingly
     * @param person Trainee: logged in user inside mock data
     * @return Trainee
     */
    public Trainee changeToPremium(Trainee person) {
        Scanner input = new Scanner(System.in);
        String choice;
        boolean status;
        System.out.println("Would you like to change your account to premium?");
        
        do {
            System.out.print("Your Choice (Y/N): ");
            choice = input.nextLine();
            status = this.charCheck(choice, 'y', 'n');
        } while(!status);

        if (choice.toLowerCase().charAt(0) == 'y') {
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
    /**
     * Display the courses according to person's premium status
     * @param premiumStat Boolean: premiums status of user
     */
    public void listAllCourses(JButton btnListAllCourses, Trainee person) { 
        List<Course> temp = getCourses(person);
        btnListAllCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListCourses listOfCourses = new ListCourses(frame, temp);
                listOfCourses.setVisible(true);
            }
        });
    }   
    /**
     * Displays the enrolled courses by person who logged in
     * @param person Trainee: logged in user inside mock data
     */
    public void listEnrolledCourses(Trainee person, JButton btnEnrolledCourses) {
        btnEnrolledCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EnrolledCourse enrolled = new EnrolledCourse(frame, person.getCourses());
                enrolled.setVisible(true);
            }
        });
    }
    /**
     * When user wants to logout, first finds the person in traineeList
     * then gets it, and updates it.
     * @param person Trainee: logged in user inside mock data
     * @param traineeList List: Created mock data program 
     * @return boolean
     */
    public void logout(JButton btnLogout, Trainee person) {
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                "Logout!!!",
                "Logout",
                JOptionPane.INFORMATION_MESSAGE);
               
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }
    /**
     * Exit method return false when user wants to exit from the sstem.
     * @return boolean
     */
    public void exit(JButton btnExit) {
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    /**
     * It is a submenu.
     * Apart from login, signup and exit methods, other operations run here.
     * @param person Trainee: logged in user inside mock datax
     */
    public void subMenu(Trainee person) {
        SubMenu submenu = new SubMenu(frame, person);
        listAllCourses(submenu.listAllCourses(), person);
        addCourse(person, submenu.addCourse());
        deleteCourse(person, submenu.deleteCourse());
        listEnrolledCourses(person, submenu.enrolledCourses());
        logout(submenu.logout(), person);
        submenu.setVisible(true);
        
                // case "3":
                    // System.out.print("Which course would you like to delete: ");
                    // String course = input.nextLine();
                    // person = this.deleteCourse(person, course);
                    // break;
                // case "4":
                    // this.listInstructor(this.instructors);
                    // System.out.print("ID: ");
                    // int id = input.nextInt();
                    // this.getInstructorDetails(id, this.instructors);
                    // input.nextLine();
                    // break;
                // case "5":
                    // this.changeToPremium(person);
                    // break;
    }

    private List<Course> getCourses(Trainee person) {
        List<Course> temp = new ArrayList<>();

        for (Course course : this.courses) {
            if (course.premium == person.getPremium() && person.getPremium() == false) {
                temp.add(course);
            }
            else if (person.getPremium() == true) {
                temp.add(course);
            }
        }
        return temp;
    }
}