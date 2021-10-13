package com.sandp.ratings.soa.kongtool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "KT_ROLE")
public class Role {
    
    @Id
    @Column(name = "ID", length=50)
    private String id;
    
    @Column(name = "NAME", length=50, nullable = false)
    private String name;
    
    @Column(name = "DESCRIPTION", length=100, nullable = false)
    private String description;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    

}
