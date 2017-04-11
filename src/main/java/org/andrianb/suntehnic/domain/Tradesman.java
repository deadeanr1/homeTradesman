package org.andrianb.suntehnic.domain;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 3/28/2017.
 */
@Entity
@Table(name = Tradesman.TABLE_NAME)
public class Tradesman implements Serializable {
    public static final String TABLE_NAME = "tradesman";

    public static final String ID = "tradesman_id";
    public static final String BIDS = "bids";
    public static final String TITLE = "title";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID)
    private Long id;

    private String title;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = User.USER_ID)
    private User user;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobCategory> jobCategory;

    @OneToMany(mappedBy = Bid.COLUMN_SUBMITTER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bid> bids;

    public Long getId() {
        return id;
    }

    public String getBusinessTitle() {
        return title;
    }

    public void setBusinessTitle(String businessTitle) {
        this.title = businessTitle;
    }

    public UserDetails getUserDetails() {
        return user;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<JobCategory> getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(List<JobCategory> service) {
        this.jobCategory = service;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
