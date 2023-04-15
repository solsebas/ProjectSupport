package pl.polsl.projectsupport.model;

import lombok.Data;
import pl.polsl.projectsupport.enums.EnumRole;

import javax.persistence.*;

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