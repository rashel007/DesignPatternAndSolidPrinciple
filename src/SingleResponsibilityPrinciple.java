import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityPrinciple {


    public static void main(String[] args) {
        System.out.println("Single Responsibility Principle");
    }
}

class UserController{

    public void createUser(String userInfo){
        // convert string (JSON) of user info to User Object
        /**
         * should create separate class for object conversion
         */
        ConvertToObject convertToObject = new ConvertToObject();

        // validate user info
        /**
         * should create separate class for validation
         */

        Validator validator = new Validator();

        // save user in persistence
        /**
         * should create e persistence class to store user info
         */

        Persistence persistence = new Persistence();
    }
}

class User{
    private String name;
    private String email;
}

class ConvertToObject{

    User getUser(String data){
        // create user conversion logic here
        return new User();
    }
}

class Validator{

    boolean isValidUser(User user){
        // add user validation here
        return true;
    }
}

class Persistence{

    void saveUser(User user){
        // logic for save user
    }
}

