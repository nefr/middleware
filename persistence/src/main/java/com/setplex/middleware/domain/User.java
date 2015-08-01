package com.setplex.middleware.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "userId")),
        @AttributeOverride(name = "name", column = @Column(name = "username"))
})
@Getter
@Setter
public class User extends AbstractNamedEntity {
    private String password;
    private boolean enabled;
    private String role;
    private String email;
}
