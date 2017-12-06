package com.jpa.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.jpa.models.UserDto;

@Qualifier("userRepo")
@Primary
@Repository
public interface UserRepository extends BaseRepository<UserDto> {
}
