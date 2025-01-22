package code;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HelloDisplay {
    PersonService service = new PersonService();

    public void display() {
        displayHelloWindow();
        Scanner sc = new Scanner(System.in);
        int choice=-1;
        do {
            choice = sc.nextInt();
        } while (choice<1 ||choice>3);
        if (choice == 1) {
            login();
        } else if (choice == 2) {
            service.addPerson();
            login();
        } else {
            printFrameWithMessage("*========================================== *\n" +
                    "*             Thank You!                    *\n" +
                    "*========================================== *\n");
            return;
        }
    }

    private void displayHelloWindow() {
        printFrameWithMessage("*               Hello there                 *\n" +
                "*                                           *\n" +
                "*             Enter Pincode below           *\n" +
                "*========================================== *\n" +
                "*   1) login                                *\n" +
                "*   2) Create account                       *\n" +
                "*   3) Exit                                 *\n" +
                "*========================================== *\n");

    }

    private void printFrameWithMessage(String message) {
        printTenLines();
        System.out.print("*********************************************+\n" +
                "*                                           *\n");
        System.out.print(message);
        System.out.print("*                                           *\n" +
                "*********************************************+\n");
    }

    private boolean handleOperation(Person p) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double ammount;
        do {
            choice = sc.nextInt();
        } while (choice > 4 || choice < 1);
        if (choice == 1) {
            System.out.println(p.getAccount().getCashAmount());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (choice == 2) {
            System.out.print("Select amount: ");
            ammount = sc.nextDouble();
            if (ammount > p.getAccount().getCashAmount()) {
                System.out.println("not enough money");
            } else {
                p.getAccount().setCashAmount(p.getAccount().getCashAmount() - ammount);
            }
        } else if (choice == 4) {
            return false;

        } else {
            ammount = sc.nextDouble();
            p.getAccount().setCashAmount(p.getAccount().getCashAmount() + ammount);

        }
        if (choice == 2 || choice == 3) {
            service.savePersonData();
        }
        return true;
    }

    private void succesfullLoginWindowDisplay(Person p) {
        boolean cont = true;
        while (cont) {
            printFrameWithMessage(p.getName() + " Logged on\n" +
                    "*========================================== *\n" +
                    "*  1) display money amount                  *\n" +
                    "*  2) withdraw                              *\n" +
                    "*  3) deposit                               *\n" +
                    "*  4) Logout                                *\n" +
                    "*========================================== *\n");
            cont = handleOperation(p);
        }
        display();
    }

    private void unsuccesfullLoginWindowDisplay() {
        printFrameWithMessage("*         Unsuccesfully logged :C           *\n");

    }

    private void login() {
        printFrameWithMessage("*               Hello there                 *\n" +
                "*                                           *\n" +
                "*             Enter Pincode below           *\n");

        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        Person p = findPerson(pin);
        if (p == null) {
            unsuccesfullLoginWindowDisplay();
        } else {
            succesfullLoginWindowDisplay(p);

        }
    }

    private void printTenLines() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private Person findPerson(int pincode) {
        List<Person> l = service.getPersonLinkedList();
        for (Person p : l) {
            if (Objects.equals(p.getAccount().getFourDigitPin(), String.valueOf(pincode))) {
                return p;
            }
        }
        return null;
    }


}
