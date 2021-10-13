package com.sandp.ratings.soa.kongtool.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "KT_USER")
public class User {
    
    @Id
    @Column(name = "ID", length=50)
    private String id;
    
    @Column(name = "USERNAME", length=50, nullable = false)
    private String username;
    
    @Column(name = "EMAIL", length=50, nullable = true)
    private String email;
    
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
     
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "KT_USER_ROLE_XREF",
            joinColumns = @JoinColumn(name = "USER_ID",  referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
            )
    private Set<Role> roles = new HashSet<Role>();
 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    
}
