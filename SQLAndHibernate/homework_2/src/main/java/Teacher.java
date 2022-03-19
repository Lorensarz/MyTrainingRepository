import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teacher {

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
    private int salary;

    @Getter
    @Setter
    private int age;

}
