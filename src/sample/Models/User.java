package sample.Models;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String userSpecific;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getUserSpecific() != null ? !getUserSpecific().equals(user.getUserSpecific()) : user.getUserSpecific() != null)
            return false;
        return getDate() != null ? getDate().equals(user.getDate()) : user.getDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getUserSpecific() != null ? getUserSpecific().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return firstName;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public String getUserSpecific() {

        return userSpecific;
    }

    public void setUserSpecific(String userSpecific) {
        this.userSpecific = userSpecific;
    }

    public User(){}

    public User(String firstName, String lastName, String password, String userSpecific) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userSpecific = userSpecific;
       // this.date = date;
    }

    public User(String firstName){
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
