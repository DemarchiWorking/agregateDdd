package com.example.ex_servico.service;

import com.example.ex_servico.dtos.ServiceRecordDto;
import com.example.ex_servico.model.Cliente;
import com.example.ex_servico.model.Servicee;
import com.example.ex_servico.repository.ServiceRepository;
import com.example.ex_servico.service.feign.ClienteClient;
import com.example.ex_servico.service.feign.ServiceClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ClienteClient client;

    @Autowired
    private ServiceRepository serviceRepository;

    @Transactional
    public ResponseEntity<Servicee> save(Servicee service) {
        System.out.println(service.getName());
        System.out.println(service.getCost());
        System.out.println(service.getClienteId());
        Cliente cliente = client.buscarClienteById(service.getClienteId()).getBody();
        System.out.println(cliente);
        if(cliente.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        else{
            service.setClienteId(cliente.getId());
        }

        Servicee saved_service = serviceRepository.save(service);
        return ResponseEntity.ok(saved_service);


    }

    public ResponseEntity<List<Servicee>> getAllService() {
        return ResponseEntity.ok(serviceRepository.findAll());
    }

    public ResponseEntity<Servicee> findById(@PathVariable Long id) {
        Servicee service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        } else {
            return ResponseEntity.ok(service);
        }
    }

    public ResponseEntity deleteById(@PathVariable Long id) {
        Servicee service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Return 400 Bad Request
        } else {
            //historicoService.newLog(Historico.OPERACAO.APAGAR, "Serviço", "", "ID: " +  id.toString());
            serviceRepository.deleteById(id);
            return ResponseEntity.ok(service);
        }
    }
}


