package com.setplex.middleware.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "clientId")),
        @AttributeOverride(name = "name", column = @Column(name = "username"))
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Client.class)
@Getter
@Setter
public class Client extends AbstractNamedEntity {

    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String language;
    private String pincode;
    private String address;
    private String city;
    private String zipcode;
    private String state;
    private String country;
    private LocalDateTime expirationTime;
    private LocalDateTime lastAccess;
    private LocalDateTime registered;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "CLIENT_PACKAGE", joinColumns = {@JoinColumn(name = "clientId")}, inverseJoinColumns = {@JoinColumn(name = "packageId")})
    private List<Package> packages;

}
