package com.infopulse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
//@Table(name="clients")
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
public class User {

//    @Id
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    private Long id;

    @Id
    @GeneratedValue(generator = "idString-generator")
    @GenericGenerator(name = "idString-generator",
                      strategy = "com.infopulse.entity.CreateIdString")
    private String idstring;


    @Column(name="name")
    private String name;

}
