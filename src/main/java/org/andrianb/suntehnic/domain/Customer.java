package org.andrianb.suntehnic.domain;

import org.andrianb.suntehnic.domain.Review.Feedback;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by AndrianB on 3/28/2017.
 */

@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer implements Serializable
{
    public static final String TABLE_NAME = "customer";

    public static final String COLUMN_ID = "customer_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_ID)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = User.USER_ID)
    private User user;

    @OneToMany(mappedBy = Feedback.COLUMN_CUSTOMER, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = Job.COLUMN_SUBMITTER, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Job> jobs;

    public List<Feedback> getRatings()
    {
        return feedbacks;
    }

    public void setRatings(List<Feedback> feedbacks)
    {
        this.feedbacks = feedbacks;
    }

    public void setJobs(List<Job> jobs)
    {
        this.jobs = jobs;
    }


    public Long getId()
    {
        return id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUserDetails(User user)
    {
        this.user = user;
    }


    public void addJob(Job job)
    {
        this.jobs.add(job);
        if (job.getOwner() != this)
        {
            job.setOwner(this);
        }
    }


    public List<Job> getJobs()
    {
        return jobs;
    };

}

