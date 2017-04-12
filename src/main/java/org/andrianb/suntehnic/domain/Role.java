package org.andrianb.suntehnic.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by AndrianB on 3/28/2017.
 */

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_ANONYMOUS("ROLE_ANONYMOUS"),
    ROLE_CUSTOMER("ROLE_CUSTOMER"),
    ROLE_TRADESMAN("ROLE_TRADESMAN");

    String name;

    private Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
//todo integrate liquibase and move to database role data
/*
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
*/
