package org.andrianb.suntehnic.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by AndrianB on 3/28/2017.
 */

@Entity
@Table(name ="job")
public class Job {
    public static final String COLUMN_SUBMITTER = "submitter";
    public static final String JOB_ID = "job_id";




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = JOB_ID)
    private Long id;

    private String postCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JobCategoryType.COLUMN_ID)
    private JobCategoryType serviceTaskJobType;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JobCategoryType.COLUMN_ID, updatable = false, insertable = false)
    private JobCategoryType serviceType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JobCategory.COLUMN_ID, updatable = false, insertable = false)
    private JobCategory jobCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Customer.COLUMN_ID)
    private Customer owner;


    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public JobCategory getJobCategory()
    {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory)
    {
        this.jobCategory = jobCategory;
    }



    public JobCategoryType getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(JobCategoryType serviceType)
    {
        this.serviceType = serviceType;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

}
