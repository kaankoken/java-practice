package app;

import java.util.List;
import app.Trainee;

public class ErrorHandling {
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

    public boolean authenticate(List<Trainee> input, String Pass, String Email) {
        for(Trainee t: input) {
            System.out.println(t.getEmail() + " " + t.getPassword());
            if (t.getEmail().equals(Email) && t.getPassword().equals(Pass)) {
                return true;
            }
        }
 
        return false;
    }
}