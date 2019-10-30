package AssignmentSix;

//import lombok.Getter;
//import lombok.Setter;

public class User {
    //    @Getter @Setter
    private String name;
    //    @Getter @Setter
    private int age;
    //    @Getter @Setter
    private String address;
    //    @Getter @Setter
    private String phoneNumber;
    //    @Getter @Setter
    private String bankAccountNumber;
    //    @Getter @Setter
    private String password;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}