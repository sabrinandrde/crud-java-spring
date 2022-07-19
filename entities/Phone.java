package br.com.aulaapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "telefone")
public class Phone {

    @Id
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "DDD")
    private Long ddd;

    @Basic
    @Column(name = "NUMERO")
    private String number;

    @ManyToOne
    @JsonIgnore
    private User user;
}
