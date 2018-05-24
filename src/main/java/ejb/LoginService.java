package ejb;

import javax.ejb.Local;

import domain.StudentDomain;
        import jpa.Student;
        import sun.security.validator.ValidatorException;

        import javax.ejb.Local;


@Local
public interface LoginService {
    String submitLogin(String email, String password);
}
