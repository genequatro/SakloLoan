package SakloLoan;

public class User {

    private String name;
    private String address;
    private int age;
    private String birthday;
    private String number;
    private double income;


    public User(String name, String address, int age, String birthday, String number, double income) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.birthday = birthday;
        this.number = number;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNumber(){
        return number;
    }

    public double getIncome(){
        return income;
    }

}
