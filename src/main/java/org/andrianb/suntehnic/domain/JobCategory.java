package org.andrianb.suntehnic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by AndrianB on 4/11/2017.
 */

@Entity
@Table(name = JobCategory.TABLE_NAME)
public class JobCategory implements Serializable{
    public static final String TABLE_NAME = "job_category";

    public static final String COLUMN_ID = "job_category_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCIPTION = "description";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_ID)
    @JsonIgnore
    private Long id;

    @Column(name = COLUMN_TITLE)
    private String title;

    @Column(name = COLUMN_DESCIPTION)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = JobCategoryType.COLUMN_PARENT, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobCategoryType> categoryTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Tradesman.TRADESMAN_ID, updatable = false, insertable = false)
    @JsonIgnore
    private Tradesman specialist;

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<JobCategoryType> getCategoryTypes()
    {
        return categoryTypes;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}

