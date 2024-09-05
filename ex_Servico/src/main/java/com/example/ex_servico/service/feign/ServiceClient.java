package com.example.ex_servico.service.feign;

import com.example.ex_servico.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ServiceClient {
/*
@FeignClient("SERVICE-SERVICE")
    @GetMapping("{id}")
    ResponseEntity<Cliente> buscarClienteById(@PathVariable Long id);
    @GetMapping("/cliente")
    ResponseEntity<List<Cliente>> obterClientes(@PathVariable Long id);
    //ResponseEntity<Servicee> save(Servicee servicee);
    @PostMapping("/")
    ResponseEntity<Cliente> cadastroCliente(@RequestBody Cliente project);
    ResponseEntity<Cliente> Login(@RequestBody Cliente project);


*/
}