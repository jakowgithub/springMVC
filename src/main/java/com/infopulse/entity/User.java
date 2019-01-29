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
//@NoArgsConstructor
public class User {

//    @Id
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    private Long id;

    public User() {}

    @Id
    @GeneratedValue  (generator = "idString-generator")
    @GenericGenerator(name = "idString-generator",
                      strategy = "com.infopulse.entity.CreateIdString")
    private String idstring;


    @Column(name="name")
    private String name;

    public String getIdstring() { return idstring; }
    public void setIdstring(String idstring) { this.idstring = idstring; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
