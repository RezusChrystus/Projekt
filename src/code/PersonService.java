package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class PersonService {


    public LinkedList<Person> personLinkedList = new LinkedList<>();
    private final String userDataPath = "src/data/user_info";

    public PersonService() {
        readPersons();
    }

    public LinkedList<Person> getPersonLinkedList() {
        return personLinkedList;
    }

    public void addPerson(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Wprowadz imie uzytkownika: ");
        String imie = sc.nextLine();
        System.out.print("Podaj swoj wiek: ");
        int wiek = sc.nextInt();
        personLinkedList.add(new Person(imie,wiek));
        savePersonData();
    }
    public void readPersons(){
        try {
            Scanner sc = new Scanner(new File(userDataPath));
            while (sc.hasNext()){
                personLinkedList.add(personParser(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load users");
        }

    }
    public void savePersonData() {
        try (FileWriter writer = new FileWriter(userDataPath)) {
            for (Person person : personLinkedList) {
                writer.write(prepareDataToWrite(person));
            }
        } catch (IOException e) {
            System.out.println("Something wrong with data file");
            e.printStackTrace();
        }
    }
    public void printUsers(){
        for (Person p: personLinkedList){
            System.out.println(p);
        }
    }

    public String prepareDataToWrite(Person p){
        StringBuilder sb = new StringBuilder();
        sb.append(p.getName()).append(";");
        sb.append(p.getAge()).append(";");
        sb.append(p.getAccount().getAccountNumber()).append(";");
        sb.append(p.getAccount().getCashAmount()).append(";");
        sb.append(p.getAccount().getFourDigitPin()).append("\n");

        return sb.toString();
    }


    public Person personParser(String line){
        String []info = line.split(";");
        Person p = new Person(info[0].toString(),Integer.parseInt(info[1]),new Account(info[2],Double.parseDouble(info[3]),info[4]));
        return p;
    }




}
