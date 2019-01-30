package com.infopulse.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

    public UserDTO() {}

    private String idUser;
    private String nameUser;

    public String getIdUser() { return idUser; }
    public void setIdUser(String idUser) { this.idUser = idUser; }

    public String getNameUser() { return nameUser; }
    public void setNameUser(String nameUser) { this.nameUser = nameUser; }

    @Override
    public String toString() {
        return this.idUser +"*dto*"+this.nameUser;
    }
}
