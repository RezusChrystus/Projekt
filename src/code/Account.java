package code;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class Account {
    private String accountNumber;
    private double cashAmount;
    private String fourDigitPin;

    public Account() {
        this.accountNumber = generateAccountNumber();
        this.cashAmount = 0;
        this.fourDigitPin = insertPinNumber();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getFourDigitPin() {
        return fourDigitPin;
    }
    public String toString(){
        return "acc number: "+accountNumber+
                " cash amount: "+cashAmount+
                " pin number: "+fourDigitPin;
    }

    private String generateAccountNumber(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i =0;i<9;i++){
            sb.append(random.nextInt(0,10));
        }
        return sb.toString();
    }
    private String insertPinNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("TWORZENIE KONTA:\n");
        String pinNumber="";
        do {
            System.out.println("podaj numer pin aby ustawić: ");
            pinNumber = sc.nextLine();
        }while(!correctPin(pinNumber));
        return pinNumber;
    }
    private boolean correctPin(String pin){
        try{
            Integer.parseInt(pin);
        }catch (NumberFormatException e){
            return false;
        }
        return pin.length()==4;
    }

}
