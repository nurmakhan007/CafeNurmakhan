package sample;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String login;
    private String password;
    private String email;
    private String mobilePhone;

    public Client(int id, String login, String password, String email, String mobilePhone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }
    public Client( String login, String password, String email, String mobilePhone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
