package com.setplex.middleware.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "packageId"))
//@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Package.class)
@Getter
@Setter
@ToString(callSuper = true)
public class Package extends AbstractNamedEntity {

    private String type;
    private String infopagesd;
    private String infopagehd;
    private String infopagepctv;
//    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "packages")
    private List<Channel> channels;

    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "packages")
    private List<Client> clients;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "pk")
    private List<Lang> languages;
}