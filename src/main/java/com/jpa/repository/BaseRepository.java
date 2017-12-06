package com.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jpa.models.CommonDto;

@NoRepositoryBean
public interface BaseRepository<T extends CommonDto> extends JpaRepository<T, CommonDto> {
}
