import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@EqualsAndHashCode
@Embeddable
public class LinkedPurchaseListKey implements Serializable {

    @Column(name = "student_id")
    @Getter
    @Setter
    private String studentId;

    @Column(name = "course_id")
    @Getter
    @Setter
    private String courseId;




}
