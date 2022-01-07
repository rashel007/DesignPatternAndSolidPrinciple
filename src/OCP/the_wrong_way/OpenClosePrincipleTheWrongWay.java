package OCP.the_wrong_way;

import java.util.ArrayList;
import java.util.List;

public class OpenClosePrincipleTheWrongWay {


    public static void main(String[] args) {
        System.out.println("Single Responsibility Principle");

        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.firstName = "Estique";
        person1.lastname = "Ahmed";
        person1.isManager = false;

        Person person2 = new Person();
        person2.firstName = "Raju";
        person2.lastname = "Ahmed";
        person2.isManager = true;

        personList.add(person1);
        personList.add(person2);

        List<EmployeeModel> employeeModels = new ArrayList<>();

        Account account = new Account();

        for (int i = 0; i < personList.size(); i++) {
            employeeModels.add(account.createAccount(personList.get(i)));
        }

        for (int i = 0; i < employeeModels.size(); i++) {
            System.out.println(employeeModels.get(i).email + ", isManager "+ employeeModels.get(i).isManager);
        }
    }
}

//class Person {
//    public String firstName;
//    public String lastname;
//}

class Person {
    public String firstName;
    public String lastname;
    public boolean isManager;
}


/**
 * Here if new requirement comes
 * In EmployeeModel we have to add new field isManager
 **/

//class EmployeeModel {
//    String firstName;
//    String lastName;
//    String email;
//}

/**
 * let add isManager
 * make the default value false
 * it will not change anything
 * but to apply it we have to modify the account class.
 * and by this we are breaking the OCP.
 * we are modifying an existing working class
 */

class EmployeeModel {
    String firstName;
    String lastName;
    String email;
    boolean isManager = false;
}

//class Account {
//
//    EmployeeModel createAccount(Person person) {
//        EmployeeModel model = new EmployeeModel();
//        model.firstName = person.firstName;
//        model.lastName = person.lastname;
//        model.email = person.firstName.charAt(0) + "." + person.lastname + "@gmail.com";
//
//        return model;
//    }
//}

/**
 * lets rewrite the account class to make isManager workable
 * by breaking the OCP
 */


class Account {

    EmployeeModel createAccount(Person person) {
        EmployeeModel model = new EmployeeModel();
        model.firstName = person.firstName;
        model.lastName = person.lastname;
        model.email = person.firstName.charAt(0) + "." + person.lastname + "@gmail.com";
        model.isManager = person.isManager;

        return model;
    }
}