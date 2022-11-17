package com.example.msreserva.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.msreserva.entities.ConsultasEntity;


public interface RepositoryConsultasJPA extends org.springframework.data.jpa.repository.JpaRepository<ConsultasEntity, Integer>{
}