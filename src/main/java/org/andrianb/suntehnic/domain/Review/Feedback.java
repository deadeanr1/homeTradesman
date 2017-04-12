package org.andrianb.suntehnic.domain.Review;

import org.andrianb.suntehnic.domain.Customer;
import org.andrianb.suntehnic.domain.Job;

import javax.persistence.*;
import java.io.Serializable;

import static org.andrianb.suntehnic.domain.Job.JOB_ID;

/**
 * Created by User on 4/11/2017.
 */

@Entity
@Table(name = Feedback.TABLE_NAME)
public class Feedback implements Serializable {
    public static final String TABLE_NAME = "rating";

    public static final String RATING_ID = "rating_id";
    public static final String COLUMN_OWNER = "customer";
    public static final String COLUMN_SHORT_DESCRIPTION = "short_description";
    public static final String COLUMN_LONG_DESCRIPTION = "long_description";
    public static final String COLUMN_CUSTOMER = "customer";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = RATING_ID)
    private Long id;

    private int score;

    @Column(name = COLUMN_SHORT_DESCRIPTION)
    private String shortDescription;

    @Column(name = COLUMN_LONG_DESCRIPTION)
    private String longDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Customer.COLUMN_ID)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JOB_ID)
    private Job job;

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}

