package com.example.mstraspasos.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.mstraspasos.entities.ConsultasEntity;


public interface RepositoryConsultasJPA extends org.springframework.data.jpa.repository.JpaRepository<ConsultasEntity, Integer>{
}