package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import domain.StudentDomain;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class StudentServiceImpl implements StudentService{


    @Override
    public void addStudent(StudentDomain Student) {

    }

    @Override
    public void updateStudent(StudentDomain Student) {

    }

    @Override
    public StudentDomain getStudent(Long id) {
        return null;
    }

    @Override
    public void removeStudent(Long id) {

    }

    @Override
    public List<StudentDomain> getStudents() {
        return null;
    }
}
