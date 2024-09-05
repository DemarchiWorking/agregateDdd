package com.example.ex_microservico.controller;

import com.example.ex_microservico.dto.LoginRecordDto;
import com.example.ex_microservico.model.Cliente;
import com.example.ex_microservico.service.ClienteService;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("{id}")
    public ResponseEntity<Cliente>buscarClienteById(@PathVariable Long id){

    return clienteService.obterClienteById(id);
    }
    @GetMapping()
    public List<Cliente> obterClientes(){

        return clienteService.obterTodosClientes();
    }
    @PostMapping
    public ResponseEntity<Cliente> cadastroCliente(@RequestBody Cliente cliente)
    {
        return clienteService.cadastroCliente(cliente);

    }
    @PostMapping("login")
    public ResponseEntity<Cliente> login(@RequestBody LoginRecordDto loginRecordDto)
    {
        System.out.println(loginRecordDto);
        return clienteService.login(loginRecordDto);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id)
    {
       return clienteService.deletarCliente(id);
    }


}