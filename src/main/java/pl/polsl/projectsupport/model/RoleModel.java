package pl.polsl.projectsupport.model;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;
import pl.polsl.projectsupport.enums.EnumRole;

@Data
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EnumRole name;

}