package com.example.ex_servico.repository;

import com.example.ex_servico.model.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Servicee, Long> {

}
