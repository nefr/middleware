package com.setplex.middleware.domain;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractNamedEntity extends AbstractPersistable<Integer> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
