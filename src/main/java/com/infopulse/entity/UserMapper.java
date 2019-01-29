package com.infopulse.entity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mappings({
            @Mapping(source= "user.idstring",target = "idUser"),
            @Mapping(source ="user.name", target  = "nameUser" )
    })
    UserDTO userToUserDTO (User user);

    @Mappings({
            @Mapping(source = "userDTO.idUser", target = "idstring"),
            @Mapping(source = "userDTO.nameUser", target = "name")
    })
    User userDTOtoUser (UserDTO userDTO);
}
