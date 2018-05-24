package jsf;


import ejb.LoginService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String message;
    @EJB
    LoginService loginService;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String loginAction() {

        String returnPage = "Login";

        String person = loginService.submitLogin(email, password);
        if(person == "student") {
            returnPage = "index";
        }
        else if(person == "teacher"){}
        else if(person == "admin"){}
        else
            {
                setPassword("");
            }
        return returnPage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
