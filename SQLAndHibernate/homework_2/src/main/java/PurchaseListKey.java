import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode
@Embeddable
public class PurchaseListKey implements Serializable {

    @Column(name = "student_name")
    @Getter
    @Setter
    private String studentName;

    @Column(name = "course_name")
    @Getter
    @Setter
    private String courseName;

    @Column(name = "subscription_date")
    @Getter
    @Setter
    private Date subscriptionDate;

}
