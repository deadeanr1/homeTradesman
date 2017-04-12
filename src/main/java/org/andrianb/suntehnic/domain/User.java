package org.andrianb.suntehnic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by AndrianB on 3/28/2017.
 */

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

    @JsonIgnore
    private static final long serialVersionUID = 6534751544232619891L;
    public static final String USER_ID = "user_id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private boolean enabled = true;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
   /* @ElementCollection
    @JoinTable(name="user_roles",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns = @JoinColumn(name = "TRADESMAN_ID"))
    private Set<Role> roles;
   @ElementCollection*/
   @Enumerated(EnumType.STRING)
   Role role;

    public User() {
    }

    public User(Long id, String username, String email, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Role getRoles() {
        return role;
    }


    public void setRoles(Role role) {
        this.role = role;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

