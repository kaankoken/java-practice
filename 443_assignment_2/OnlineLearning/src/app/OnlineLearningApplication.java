package app;

import javax.swing.*;

import app.SubMenuItem.AddCourse;
import app.SubMenuItem.ChangePremium;
import app.SubMenuItem.DeleteCourse;
import app.SubMenuItem.EnrolledCourse;
import app.SubMenuItem.ListCourses;
import app.SubMenuItem.ListInstDetails;
import app.SubMenuItem.ListInstructors;

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
    private String Status;
    /** Main Constructors without no parameters */
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

        frame = new JFrame("Online Learning Platform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
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
     * @return void
     */
    public void menu(List<Trainee> traineeList) {
        /**
         * button for main menu
         */
        JButton btnSign = new JButton("SignUp");
        JButton btnLogin = new JButton("Login");
        JButton btnExit = new JButton("Exit");

        /**
         * Invokeaction of 3 button
         */
        signup(btnSign);
        login(traineeList, btnLogin);
        exit(btnExit);

        /**
         * Layout and visibility option of creted main frame
         */
        frame.getContentPane().add(btnSign, BorderLayout.CENTER);
        frame.getContentPane().add(btnLogin, BorderLayout.CENTER);
        frame.getContentPane().add(btnExit, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     * It accepts button object, and creates the
     * button listener depend on btnSign
     * @param btnSign
     * @return void
     */
    public void signup(JButton btnSign) {
        btnSign.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /**
                     * When the btnSign triggered, It creates new object
                     * from Signup class, and gets JButton object as 
                     * in order to create another action listener.
                     */
                    Signup signup = new Signup(frame);
                    JButton btnSignup = signup.getBtnSignup();
                    btnSignup.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            /**
                             * Creates temporary trainee object in order to
                             * save the new user, and after that it adds created 
                             * temporary object to main trainee list
                             */
                            Trainee temp =  new Trainee(signup.getName(),
                            signup.getGender().charAt(0), Integer.parseInt(signup.getAge()),
                            signup.getEmail(), signup.getPassword());
                            /**Check empty fields exist or not*/
                            if (!isEmpty(temp)) {
                                JOptionPane.showMessageDialog(null,
                                "At least have problem on the fields",
                                "Sign Up",
                                JOptionPane.ERROR_MESSAGE);
                            }
                            else {/**check wheter user used same email address */
                                if (isExist(signup.getEmail(), trainee)) {
                                    JOptionPane.showMessageDialog(null,
                                    "E-mail exists in the system",
                                    "Sign Up",
                                    JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                    if (signup.getAccountType().equals("Student"))
                                        Status = "student";
                                    else
                                        Status = "non";

                                    JOptionPane.showMessageDialog(null,
                                    "Account succesfully created",
                                    "Sign Up",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    trainee.add(temp);
                                    signup.closePanel();
                                }
                            }
                            /**Empties the field if the person got
                             * error message */
                            signup.setName();
                            signup.setEmail();
                            signup.setPassword();
                            signup.setAge();
                            signup.setGender();
                            signup.setAccountType();
                        }
                    });
                    JButton btnCancel = signup.getBtnCancel();
                    btnCancel.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            /** Close the panel */
                            signup.closePanel();
                        }
                    });

                    signup.setVisible(true);
                }
        });
    }
    /**
     * It accepts button object, and creates the
     * button listener depend on btnLogin
     * @param traineeList
     * @param btnLogin
     * @return void
     */
    public void login(List<Trainee> traineeList, JButton btnLogin) {
        btnLogin.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /**Creates Login object depend on Login class */
                    Login login = new Login(frame);
                    JButton btnLogin = login.getBtnLogin();
                    btnLogin.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            /**Checks whether user in the trainee list */
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
     * It accepts button object, and creates the
     * button listener depend on btnAddCourse
     * @param person
     * @param btnAddCourse
     * @return void
     */
    public void addCourse(Trainee person, JButton btnAddCourse) {        
        btnAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /**Display the messages */
                int option = JOptionPane.showConfirmDialog(null,
                "Would you like to see Course list?",
                "List All Courses",
                JOptionPane.INFORMATION_MESSAGE);
                /** If the option yes lists the courses */
                if (option == JOptionPane.YES_OPTION) {
                    ListCourses listOfCourses = new ListCourses(frame, getCourses(person));
                    listOfCourses.setVisible(true);
                }
                AddCourse course = new AddCourse(frame);
                JButton btnAdd = course.getBtnAdd();
                JButton btnCancel = course.getBtnCancel();
                /**Triggers when the add button pressed */
                btnAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boolean status = true;
                        int i = 0;
                        /**Does not add the course if the written course name does not exist */
                        for (Course c: courses) {
                            if (c.courseName.equals(course.getCourseField())) {
                                status = true;
                                break;
                            }
                            else
                                status = false;
                        }
                        /**Display message when written wrong course name */
                        if (status == false)
                            JOptionPane.showMessageDialog(null,
                            "Entered wrong course name",
                            "Add Course",
                            JOptionPane.ERROR_MESSAGE);
                        /**Checks whether course added before */
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
                        /**adds the course to the logged user
                         * Also display the fee and the credit
                        */
                        if (status == true) {
                            for (Course c: courses) {
                                if (c.courseName.equals(course.getCourseField())){
                                    person.setCourses(c);
                                    JOptionPane.showMessageDialog(null,
                                    "Course added succesfully",
                                    "Add Course",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    
                                    float credit, monthlyFee;
                                    
                                    if (Status == "student") {
                                        Student s = new Student();
                                        credit = s.credit(person);
                                        monthlyFee = s.monthlyFee(person);
                                    }
                                    else {
                                        NonStudent n = new NonStudent();
                                        credit = n.credit(person);
                                        monthlyFee = n.monthlyFee(person);
                                    }
                                    JOptionPane.showMessageDialog(null,
                                    "Credit: " +credit + "\n" + "Montly Fee: " + monthlyFee,
                                    "Bill",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    course.closePanel();
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
                        //** close the opened panel */
                        course.closePanel();
                    }
                });
                course.setVisible(true);
            }
        });
    }
    /**
     * It accepts button object, and creates the
     * button listener depend on btnDeleteCourse
     * @param person
     * @param btnDeleteCourse
     */
    public void deleteCourse(Trainee person, JButton btnDeleteCourse) {
        btnDeleteCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteCourse delete = new DeleteCourse(frame);
                JButton btnDelete = delete.getBtnDelete();
                btnDelete.addActionListener(new ActionListener() {
                    Iterator<Course> course = person.getCourses().iterator();
                    boolean status = true;
                    int i = 0;
                    /**Search for the course inside logged user
                     * If the course size 0 gives error
                     */
                    public void actionPerformed(ActionEvent e) {
                        if (person.getCourses().size() == 0) {
                            JOptionPane.showMessageDialog(null,
                            "No course found. Please add course first",
                            "Delete Course",
                            JOptionPane.ERROR_MESSAGE);
                            status = false;
                        }
                        /** If the course size other than 1
                         * and exist in list, deletes it
                         */
                        if (status == true) {
                            while(course.hasNext()) {
                                if (course.next().courseName.equals(delete.getCourseField())) {
                                    course.remove();
                                    status = true;
                                    JOptionPane.showMessageDialog(null,
                                    "Course has been deleted succesfully",
                                    "Delete Course",
                                    JOptionPane.INFORMATION_MESSAGE);
                                    delete.closePanel();
                                }
                            }
                        }
                        if (status == false && i == 0)
                            JOptionPane.showMessageDialog(null,
                            "Course could not deleted",
                            "Delete Course",
                            JOptionPane.ERROR_MESSAGE);
                    }
                });

                JButton btnCancel = delete.getBtnCancel();
                btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        delete.dispose();
                    }
                });
                delete.setVisible(true); 
            }
        });
    }
    /**
     * It accepts button object, and creates the
     * button listener depend on btnGetInstructors
     * @param btnGetInstructors
     */
    public void getInstructorDetails(JButton btnGetInstructors) {
        btnGetInstructors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListInstructors listInst = new ListInstructors(frame, instructors);
                listInst.setVisible(true);
                
                ListInstDetails details = new ListInstDetails(frame);
                JButton btnInstructor = details.getInstButton();
                btnInstructor.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boolean status = false;
                        for (Instructor i: instructors) {
                            if (i.getId() == details.getInstructorID()) {
                                details.setVisibility();
                                details.displayData(frame, i);
                                status = true;
                            }
                        }
                        if (status == false) {
                            JOptionPane.showMessageDialog(null,
                            "ID of the instructor did not match please try again!!!",
                            "Details of Instructors",
                            JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                
                JButton btnCancel = details.getCancelButton();
                btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        details.closePanel();
                    }
                });
                details.setVisible(true);
            }
        });
    }
    /**
     * It accepts button object, and creates the
     * button listener depend on btnChangeAccountType
     * @param person
     * @param btnChangeAccountType
     */
    public void changeToPremium(Trainee person, JButton btnChangeAccountType) {
        btnChangeAccountType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (person.getPremium() == true) {
                    JOptionPane.showMessageDialog(null,
                    "Your account has already premium!!!",
                    "Premium Status",
                    JOptionPane.ERROR_MESSAGE);
                }
                else {
                    ChangePremium pre = new ChangePremium(frame);
                    /** add action listener for yes button */
                    JButton btnYes = pre.getBtnYes();
                    /**changes the account type */
                    btnYes.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            person.setPremium(true);
                            JOptionPane.showMessageDialog(null,
                            "Account has been changed to premium!!!",
                            "Premium Status",
                            JOptionPane.INFORMATION_MESSAGE);
                            pre.closePanel();
                        }
                    });
                    /** add action listener for no button 
                     * If the button invoked does not change its status
                    */
                    JButton btnNo = pre.getBtnNo();
                    btnNo.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null,
                            "Operation is cancelled",
                            "Premium Status",
                            JOptionPane.ERROR_MESSAGE);
                            pre.closePanel();
                        }
                    });
                    pre.setVisible(true);
                }
            }
        });
    }
    /**
     * reates action listener in order to display list all courses.
     * @param btnListAllCourses
     * @param person
     */
    public void listAllCourses(JButton btnListAllCourses, Trainee person) { 
        btnListAllCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListCourses listOfCourses = new ListCourses(frame, getCourses(person));
                listOfCourses.setVisible(true);
            }
        });
    }   
    /**
     * creates action listener in order to display list enrolled courses.
     * @param person
     * @param btnEnrolledCourses
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
     * It closes the session of the logged user
     * @param btnLogout
     * @param person
     */
    public void logout(JButton btnLogout) {
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
     * Exist from all the system
     * @param btnExit
     */
    public void exit(JButton btnExit) {
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    /**
     * Invokaction of all the sub menu items happen here
     * @param person
     */
    public void subMenu(Trainee person) {
        SubMenu submenu = new SubMenu(frame, person);
        listAllCourses(submenu.listAllCourses(), person);
        addCourse(person, submenu.addCourse());
        deleteCourse(person, submenu.deleteCourse());
        listEnrolledCourses(person, submenu.enrolledCourses());
        getInstructorDetails(submenu.listInstructors());
        changeToPremium(person, submenu.changePremiumStatus());
        logout(submenu.logout());
        submenu.setVisible(true);
    }
    /**
     * It returns courses according premium status of person
     * @param person
     * @return List<Course>
     */
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