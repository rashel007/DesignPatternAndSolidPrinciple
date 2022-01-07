package OCP.the_wright_way;

import java.util.ArrayList;
import java.util.List;

public class OpenClosePrincipleTheWrightWay {

    public static void main(String[] args) {
        System.out.println("Single Responsibility Principle");


        IApplicantModule person1 = new PersonNew();

        person1.setFirstName("Estique");
        person1.setLastName("Ahmed");

        IApplicantModule person2 = new Manager();
        person2.setFirstName("Raju");
        person2.setLastName("Ahmed");


        List<EmployeeModelNew> employeeModels = new ArrayList<>();
        employeeModels.add(person1.getAccountProcessor().createAccountNew(person1));
        employeeModels.add(person2.getAccountProcessor().createAccountNew(person2));

        for (int i = 0; i < employeeModels.size(); i++) {
            System.out.println(employeeModels.get(i).email + ", isManager "+ employeeModels.get(i).isManager);
        }
    }
}


interface IApplicantModule {

    String getFirstName();

    String getLastName();

    IAccount getAccountProcessor();


    void setFirstName(String name);

    void setLastName(String name);

}

class PersonNew implements IApplicantModule {
    String firstName;
    String lastName;

    IAccount accountProcessor  = new AccountNew();;

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public IAccount getAccountProcessor() {
        return accountProcessor;
    }
}


class Manager implements IApplicantModule {
    String firstName;
    String lastName;

    IAccount accountProcessor  = new ManagerAccount();;

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public IAccount getAccountProcessor() {
        return accountProcessor;
    }
}



class EmployeeModelNew {
    String firstName;
    String lastName;
    String email;
    boolean isManager = false;
}

interface IAccount {
    EmployeeModelNew createAccountNew(IApplicantModule person);
}



class AccountNew implements IAccount {

    @Override
    public EmployeeModelNew createAccountNew(IApplicantModule person) {
        EmployeeModelNew model = new EmployeeModelNew();
        model.firstName = person.getFirstName();
        model.lastName = person.getLastName();
        model.email = person.getFirstName().charAt(0) + "." + person.getLastName() + "@gmail.com";
        return model;
    }
}

class ManagerAccount implements IAccount {

    @Override
    public EmployeeModelNew createAccountNew(IApplicantModule person) {
        EmployeeModelNew model = new EmployeeModelNew();
        model.firstName = person.getFirstName();
        model.lastName = person.getLastName();
        model.email = person.getFirstName().charAt(0) + "." + person.getLastName() + "@gmail.com";
        model.isManager = true;
        return model;
    }
}







