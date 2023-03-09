package LoginRegister;

public class UserData {
    /**
     * Basic user fields to allow for login. This is the data that the concrete User objects are built from
     * upon login. They are left public and would only be accessible on the server side. The beauty of it here is
     * that the user doesn't have to be instantiated to login.
     */
    public String name;
    public int age;
    public String password;
    public boolean isAdmin = false;
    public String userName;
    public String email;
    public DummyRole[] roles;
}