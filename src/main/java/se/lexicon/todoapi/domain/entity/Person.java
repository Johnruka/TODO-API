package se.lexicon.todoapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "email")
    private User user;

    @OneToMany(mappedBy = "person")
    private List<Task> tasks = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }


}
