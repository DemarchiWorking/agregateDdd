package com.example.ex_servico.service;


import com.example.ex_servico.dtos.LoginRecordDto;
import com.example.ex_servico.model.Cliente;
import com.example.ex_servico.service.feign.ClienteClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteClient client;

    public ResponseEntity<Cliente> cadastroCliente(@RequestBody Cliente cliente){
        return client.cadastroCliente(cliente);

    }
    public ResponseEntity<Cliente> buscarClienteById(@PathVariable long id){
        return client.buscarClienteById(id);

    }
    public ResponseEntity<List<Cliente>> obterClientes(){
        return client.obterClientes();
    }
    public ResponseEntity<Cliente> deletarCliente(Long id)
    {
        return client.deletarCliente(id);
    }
    public ResponseEntity<Cliente> login(LoginRecordDto loginDto) {
        return client.login(loginDto);

    }


}
