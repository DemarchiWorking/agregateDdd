package com.example.ex_microservico.repository;

import com.example.ex_microservico.model.Cliente;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //Cliente findByEmail(String email);
    @Query(value = "SELECT * FROM cliente WHERE email = :email AND senha = :senha", nativeQuery = true)
    Cliente findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

    Cliente findByEmail(String email);
}
