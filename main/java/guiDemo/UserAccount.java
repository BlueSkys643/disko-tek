package guiDemo;

public class UserAccount {

    private String firstname;

    private String lastname;

    private String dob;
    private String age;
    private String email;
    private String username;
    private String password;

    public UserAccount(String firstname, String lastname, String dob, int age, String email, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.age = Integer.toString(age);
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public String getDOB() {
        return this.dob;
    }

    public String getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }




}
