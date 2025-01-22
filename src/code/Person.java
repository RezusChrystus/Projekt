package code;



public class Person {
    private String name;
    private int age;
    private Account account;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.account = new Account();
    }
    public String toString(){
        return "name: "+name+
                " age: "+age+
                "\naccount:\n"+
                account.toString();
    }




}
