import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Course course = session.get(Course.class, 1);
//        List<Student> studentsList = course.getStudents();
//        for (Student students : studentsList) {
//            System.out.println(students.getName() + " - " + students.getAge());
////    }
//        Student student = session.get(Student.class, 2);
//        List<Course> coursesList = student.getCourses();
//        for (Course courses : coursesList) {
//            System.out.println(student.getName() + " " + courses.getName());
//        }



        transaction.commit();
        sessionFactory.close();


    }
}
