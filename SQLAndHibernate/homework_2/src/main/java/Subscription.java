import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    @Getter
    @Setter
    private SubscriptionKey id;


    @Column(name = "student_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private int courseId;

    @Column(name = "subscription_date")
    @Getter
    @Setter
    private Date subscriptionDate;


}
