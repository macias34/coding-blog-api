package com.macias34.codingblogapi.modules.post.domain.port;

import org.mapstruct.Mapper;

import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostEntity mapModelToEntity(PostModel postModel);

    PostModel mapEntityToModel(PostEntity postEntity);
}