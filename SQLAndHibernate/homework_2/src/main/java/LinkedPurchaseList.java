import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "linked_purchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    @Getter
    @Setter
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private int courseId;


}
