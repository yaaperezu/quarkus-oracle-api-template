package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@SequenceGenerator(
        name = "usuarios_seq",
        sequenceName = "usuarios_SEQ",
        allocationSize = 1
)
public class UserEntity extends PanacheEntity {

    public String username;
    public String email;
    public String role;
}