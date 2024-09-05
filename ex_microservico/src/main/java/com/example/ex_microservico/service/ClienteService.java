package com.example.ex_microservico.service;

import com.example.ex_microservico.dto.LoginRecordDto;
import com.example.ex_microservico.model.Cliente;
import com.example.ex_microservico.repository.ClienteRepository;
import feign.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity<Cliente> login(LoginRecordDto loginRecordDto) {
        var user = clienteRepository.findByEmailAndSenha(loginRecordDto.email(), loginRecordDto.senha());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    public List<Cliente> obterTodosClientes(){
        return clienteRepository.findAll();
    }


    public ResponseEntity<Cliente> obterClienteById(@PathVariable long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else{
            return ResponseEntity.ok(cliente);
        }
    }
    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    public ResponseEntity<Cliente> cadastroCliente(Cliente cliente){
        Cliente clienteLogin = buscarPorEmail(cliente.getEmail());
        System.out.println(clienteLogin);
        System.out.println(cliente.getEmail());
        if(clienteLogin == null) {
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);


        }
    }
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok(cliente);
    }
    public Cliente Login(LoginRecordDto login) {
        return  clienteRepository.findByEmailAndSenha(login.email(), login.senha());
    }
    }
