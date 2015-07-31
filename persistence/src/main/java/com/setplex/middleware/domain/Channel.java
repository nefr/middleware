package com.setplex.middleware.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "channelId"))
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Channel.class)
public class Channel extends AbstractNamedEntity {

    private String language;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "PACKAGE_CHANNEL", joinColumns = { @JoinColumn(name = "channelId") }, inverseJoinColumns = { @JoinColumn(name = "packageId") })
    private List<Package> packages;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}
