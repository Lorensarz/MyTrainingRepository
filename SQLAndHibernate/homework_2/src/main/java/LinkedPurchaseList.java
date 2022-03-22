import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LinkedPurchaseList {

    @EmbeddedId
    @Getter
    @Setter
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private String studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private String courseId;


}
