package code;



public class Person {
    private String name;
    private int age;
    private Account account;

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Account getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
