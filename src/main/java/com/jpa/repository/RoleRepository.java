package com.jpa.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.jpa.models.RoleDto;

@Qualifier("roleRepo")
@Repository
@Primary
public interface RoleRepository extends BaseRepository<RoleDto> {

}
