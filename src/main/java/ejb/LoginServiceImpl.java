package ejb;

import jpa.Student;
import jsf.LoginBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LoginServiceImpl implements LoginService {

    @PersistenceContext
    private EntityManager em;
    private String userRole = "Login";
    private Long id;

    @Override
    public void submitLogin(String email, String password) {

        Query query = em.createNamedQuery("StudentFindByEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<Student> s = query.getResultList();
        if (s.size()>0) {
            setId(s.get(0).getId());
            setUserRole("student");
        }
    }

    @Override
    public void setUserRole(String role) {
        this.userRole = role;
    }

    @Override
    public String getUserRole() {
        return userRole;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
