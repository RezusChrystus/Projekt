package code;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HelloDisplay {
    PersonService service = new PersonService();

    public void display() {
        displayHelloWindow();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            login();
        }else{
            service.addPerson();
            login();
        }
    }
    private void displayHelloWindow() {
        System.out.print("*********************************************+\n" +
                "*                                           *\n" +
                "*               Hello there                 *\n" +
                "*                                           *\n" +
                "*             Enter Pincode below           *\n" +
                "*========================================== *\n" +
                "*   1) login                                *\n" +
                "*   2) Create account                       *\n" +
                "*========================================== *\n" +
                "*                                           *\n" +
                "*********************************************+"
        );
    }

    private void succesfullLoginWindowDisplay(Person p){
        printTenLines();
        System.out.println(p.getName()+" Logged on");
        System.out.print("*********************************************+\n" +
                "*                                           *\n" +
                "*========================================== *\n" +
                "*  1) display money amount                  *\n" +
                "*  2) withdraw                              *\n" +
                "*  3) deposit                               *\n" +
                "*========================================== *\n" +
                "*                                           *\n" +
                "*********************************************\n"

        );
        handleOperation(p);
    }
    private void unsuccesfullLoginWindowDisplay(){
        printTenLines();
        System.out.print("*********************************************+\n" +
                "*                                           *\n" +
                "*                                           *\n" +
                "*         Unsuccesfully logged :C           *\n" +
                "*                                           *\n" +
                "*                                           *\n" +
                "*********************************************\n"

        );
    }


    private void login(){
        printTenLines();
        System.out.print("*********************************************+\n" +
                "*                                           *\n" +
                "*               Hello there                 *\n" +
                "*                                           *\n" +
                "*             Enter Pincode below           *\n" +
                "*========================================== *\n" +
                "                   "
        );
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        Person p = findPerson(pin);
        if( p== null){
            unsuccesfullLoginWindowDisplay();
        }else {
            succesfullLoginWindowDisplay(p);
        }
    }
    private void printTenLines(){
        for (int i =0;i<10;i++){
            System.out.println();
        }
    }
    private Person findPerson(int pincode){
        List<Person> l =  service.getPersonLinkedList();
        for (Person p : l){
            if(Objects.equals(p.getAccount().getFourDigitPin(), String.valueOf(pincode))){
                return p;
            }
        }
        return null;
    }
    public void handleOperation(Person p){
        Scanner sc = new Scanner(System.in);
        int choice ;
        double ammount;
        do{
            choice=sc.nextInt();
        }while(choice>3 || choice<1);
        if(choice ==1){
            System.out.println(p.getAccount().getCashAmount());
        } else if (choice == 2) {
            System.out.print("Select amount: ");
            ammount=sc.nextDouble();
            if(ammount<p.getAccount().getCashAmount()){
                System.out.println("not enough money");
            }else{
                p.getAccount().setCashAmount(p.getAccount().getCashAmount()-ammount);
            }
        } else {
            ammount=sc.nextDouble();
            p.getAccount().setCashAmount(p.getAccount().getCashAmount()+ammount);

        }
        if(choice==2 || choice ==3){
            service.savePersonData();
        }
    }


}
