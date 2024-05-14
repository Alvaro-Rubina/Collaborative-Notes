package org.alvarub.rtnotes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long userID;
    private String username;
    private String password;
    private String email;

    // Associations
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

    // TODO: En un futuro agregar quizás niveles de visualizacion (colaborador, vizualizacion, etc).
}
