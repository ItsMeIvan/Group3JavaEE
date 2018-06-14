package jsf;

import domain.StudentDomain;
import domain.TeacherDomain;
import ejb.StudentService;
import ejb.TeacherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class CreateCourseBean {
    private String newCourseName;
    private Long teacherId;
    private List<TeacherDomain> teachers;
    private List<StudentDomain> studentsFromDb;
    private List<StudentDomain> studentsForCourse;


    @EJB
    TeacherService teacherService;

    @EJB
    StudentService studentService;

    public void createCourse(Long teacherId){

    }

    public void addStudentToCourse(Long studentId){
        //Leder till nullpointerexception
        StudentDomain student = studentsFromDb.get(studentId.intValue());
        studentsFromDb.remove(student);
        studentsForCourse.add(student);
    }
    public void removeStudentToCourse(Long studentId){
        //Leder till nullpointerexception
        StudentDomain student = studentsForCourse.get(studentId.intValue());
        studentsForCourse.remove(student);
        studentsFromDb.add(student);
    }

    public String ifStudentIsPicked(Long studentId){
        //Fixa ifsatsen
        //if(studentsForCourse.contains(studentsForCourse.get(studentId.intValue())))
        //    return "Student is in the course";
        return "Student is not in the course";
    }

    public String getNewCourseName() {
        return newCourseName;
    }

    public void setNewCourseName(String newCourseName) {
        this.newCourseName = newCourseName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public List<TeacherDomain> getTeachers() {
        return teachers = teacherService.getTeachers();
    }

    public void setTeachers(List<TeacherDomain> teachers) {
        this.teachers = teachers;
    }

    public List<StudentDomain> getStudentsFromDb() {
        return studentsFromDb = studentService.getStudents();
    }

    public void setStudentsFromDb(List<StudentDomain> studentsFromDb) {
        this.studentsFromDb = studentsFromDb;
    }

    public List<StudentDomain> getStudentsForCourse() {
        return studentsForCourse;
    }

    public void setStudentsForCourse(List<StudentDomain> studentsForCourse) {
        this.studentsForCourse = studentsForCourse;
    }
}
