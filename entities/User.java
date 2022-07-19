package br.com.aulaapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "usuario")
public class User {

    @Id
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "NOME")
    private String name;

    @Basic
    @Column(name = "IDADE")
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

}
