import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Getter
    @Setter
    private CourseType type;

    @Getter
    @Setter
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Teacher teacher;

    @Column(name = "students_count")
    @Getter
    @Setter
    private int studentCount;

    @Getter
    @Setter
    private int price;

    @Column(name = "price_per_hour")
    @Getter
    @Setter
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
    joinColumns = {@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
    @Getter
    @Setter
    private List<Student> students;

}
