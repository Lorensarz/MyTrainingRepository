import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;


@Entity
public class PurchaseList {

    @EmbeddedId
    @Getter
    @Setter
    private PurchaseListKey id;

    @Column(name = "student_name", insertable = false, updatable = false)
    @Getter
    @Setter
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    private int price;

    @Column(name = "subscription_date", insertable = false, updatable = false)
    @Getter
    @Setter
    private Date subscriptionDate;





}
