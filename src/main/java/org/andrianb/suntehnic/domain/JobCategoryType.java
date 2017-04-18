package org.andrianb.suntehnic.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by AndrianB on 4/11/2017.
 */

@Entity
@Table(name = "job_category_type")
public class JobCategoryType implements Serializable {

    public static final String COLUMN_ID = "solution_task_type_id";
    public static final String COLUMN_PARENT = "parent";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_ID)
    //@JsonIgnore
    private Long id;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JobCategory.COLUMN_ID)
   @JsonBackReference
//      @JsonIgnore
    private JobCategory parent;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobCategory getParent() {
        return parent;
    }

    public void setOwner(JobCategory parent) {
        this.parent = parent;
    }


}

