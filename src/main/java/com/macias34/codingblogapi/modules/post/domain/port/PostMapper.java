package com.macias34.codingblogapi.modules.post.domain.port;

import com.macias34.codingblogapi.modules.post.domain.entity.PostEntity;
import com.macias34.codingblogapi.modules.post.domain.entity.PostModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostEntity mapModelToEntity(PostModel postModel);

    PostModel mapEntityToModel(PostEntity postEntity);
}