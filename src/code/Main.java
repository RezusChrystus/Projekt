package code;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
////        Person p = new Person("Adam",35);
////        System.out.println(p);
//        PersonService service = new PersonService();
//        service.addPerson();
//        service.addPerson();
//        service.savePersonData();
        PersonService service = new PersonService();
        service.printUsers();
    }
}
