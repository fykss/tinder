package dto;

public class User implements Identifiable{
    private String name;
    private String surname;
    private String photoURL;
    private String work;
    private String gender;
    private String email;
    private String password;
    private String lastLogin;
    private int id;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.id = getId();
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(String name, String surname, String photoURL, String work, String gender, String email, String password, String lastLogin) {
        this.name = name;
        this.surname = surname;
        this.photoURL = photoURL;
        this.work = work;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getWork() {
        return work;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
