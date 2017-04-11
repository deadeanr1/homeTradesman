package org.andrianb.suntehnic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static org.andrianb.suntehnic.domain.Job.JOB_ID;
import static org.andrianb.suntehnic.domain.Tradesman.TRADESMAN_ID;

/**
 * Created by Andrian on 4/11/2017.
 */

@Entity
@Table(name = "bid")
public class Bid implements Serializable{
    public static final String COLUMN_SUBMITTER = "submitter";

    public static final String COLUMN_ID = "bid_id";
    public static final String COLUMN_VALUE = "value";
    public static final String COLUMN_CREATED = "created";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_VALUE)
    private BigDecimal value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = COLUMN_CREATED)
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = TRADESMAN_ID, updatable = false, insertable = false)
    private Tradesman owner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JOB_ID, updatable = false, insertable = false)
    private Job job;

    //todo: add bid state published, accepted

    public Tradesman getOwner() {
        return owner;
    }

    public void setOwner(Tradesman owner) {
        this.owner = owner;
    }

    public Job getJob() {
        return job;
    }

    public void setTask(Job task) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}