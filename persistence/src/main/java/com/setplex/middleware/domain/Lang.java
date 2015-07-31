package com.setplex.middleware.domain;

import lombok.Getter;
import lombok.Setter;
import  com.setplex.middleware.domain.Package;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "langId"))
@Getter
@Setter
public class Lang extends AbstractPersistable<Integer> {

    private String language;
    private String translation;
    @ManyToOne(optional = false)
    private Package pk;
}
