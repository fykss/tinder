package dto;

public class User implements Identifiable{
    private String name;
    private String surname;
    private String photoURL;
    private String work;
    private String gender;
    private String email;
    private String password;
    private int id;
    private String lastLogin;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String surname, String photoURL, String work, String gender, String email, String password, int id, String lastLogin) {
        this.name = name;
        this.surname = surname;
        this.photoURL = photoURL;
        this.work = work;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.id = id;
        this.lastLogin = lastLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public int getId() {
        return 0;
    }
}
