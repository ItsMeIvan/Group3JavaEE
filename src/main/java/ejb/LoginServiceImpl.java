package ejb;

import jpa.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LoginServiceImpl implements LoginService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String submitLogin(String email, String password) {
        String user = "Login";

        Query query = em.createNamedQuery("StudentFindByEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<Student> s = query.getResultList();
        if (s.size()>0) {
            user = "student";
        }
        return user;
    }
}
