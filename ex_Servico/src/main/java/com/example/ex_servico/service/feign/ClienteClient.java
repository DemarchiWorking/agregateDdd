package com.example.ex_servico.service.feign;


import com.example.ex_servico.dtos.LoginRecordDto;
import com.example.ex_servico.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "CLIENTE-SERVICE")
public interface ClienteClient {

        @RequestMapping(method = RequestMethod.POST, value = "/", consumes = "application/json")
        ResponseEntity<Cliente> cadastroCliente(@RequestBody Cliente cliente);

        @GetMapping("/{id}")
        ResponseEntity<Cliente> buscarClienteById(@PathVariable Long id);

        @PostMapping("login")
        ResponseEntity<Cliente> login(@RequestBody LoginRecordDto loginRecordDto);

        @GetMapping("/")
        ResponseEntity<List<Cliente>> obterClientes();
        @DeleteMapping("/{id}")
        ResponseEntity<Cliente> deletarCliente (@PathVariable Long id);
        //@PutMapping("/{id}")
        //ResponseEntity<Cliente> updateProject(@PathVariable Long id, @RequestBody Project project);
    }

