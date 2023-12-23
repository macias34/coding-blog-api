package com.macias34.codingblogapi.modules.user.domain.port;

import org.mapstruct.Mapper;

import com.macias34.codingblogapi.modules.user.domain.entity.UserEntity;
import com.macias34.codingblogapi.modules.user.domain.entity.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity mapModelToEntity(UserModel userModel);

    UserModel mapEntityToModel(UserEntity userEntity);
}