import org.hibernate.HibernateException;
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


        try (sessionFactory) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            String createLinkedPurchaseList = "insert into linked_purchaselist\n" +
                    "select Students.id, Courses.id\n" +
                    "from purchaselist\n" +
                    "join Students on Students.name = PurchaseList.student_Name\n" +
                    "join Courses on Courses.name = PurchaseList.course_Name";


            session.createSQLQuery(createLinkedPurchaseList).executeUpdate();

            transaction.commit();


        } catch (HibernateException e) {
            e.printStackTrace();

        }


//        String createLinkedPurchaseList =
//                "CREATE TABLE " + LinkedPurchaseList.class.getSimpleName() +
//                " AS " +
//                "SELECT Student.id, Course.id " +
//                "FROM " + PurchaseList.class.getSimpleName() +
//                " JOIN " + Student.class.getSimpleName() + " on Student.name = PurchaseList.studentName " +
//                "JOIN " + Course.class.getSimpleName() + " on Course.name = PurchaseList.courseName";


//        Course course = session.get(Course.class, 1);
//        List<Student> studentsList = course.getStudents();
//        for (Student students : studentsList) {
//            System.out.println(students.getName() + " - " + students.getAge());
//    }
//        Student student = session.get(Student.class, 2);
//        List<Course> coursesList = student.getCourses();
//        for (Course courses : coursesList) {
//            System.out.println(student.getName() + " " + courses.getName());
//        }

//        Subscription subscription = session.get(Subscription.class,
//                new SubscriptionKey(1, 2));


    }
}
