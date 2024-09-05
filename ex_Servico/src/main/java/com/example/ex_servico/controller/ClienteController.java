package com.example.ex_servico.controller;

import com.example.ex_servico.dtos.LoginRecordDto;
import com.example.ex_servico.model.Cliente;
import com.example.ex_servico.service.ClienteService;
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
    @GetMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody LoginRecordDto loginRecordDto)
    {
        return clienteService.login(loginRecordDto);
    }
    @PostMapping("/")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

        return clienteService.cadastroCliente(cliente);
    }
    @GetMapping("{id}")
    public ResponseEntity<Cliente>buscarClienteById(@PathVariable Long id){
        return clienteService.buscarClienteById(id);
    };
    @GetMapping("")
    public ResponseEntity<List<Cliente>> getAll() {
      return clienteService.obterClientes();
    };
    @DeleteMapping("{id}")
    public void deletarCliente(@PathVariable Long id)
    {
        clienteService.deletarCliente(id);
    }

}
