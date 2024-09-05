package com.example.ex_servico.controller;

import com.example.ex_servico.dtos.ServiceRecordDto;
import com.example.ex_servico.model.Servicee;
import com.example.ex_servico.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("servicos")
public class ServiceController {


    @Autowired
    private ServiceService serviceService;
    @PostMapping
    public ResponseEntity<Servicee> createService(@RequestBody Servicee service) {
        return serviceService.save(service);
    }

    @GetMapping
    public ResponseEntity<List<Servicee>> getAllServices(){
        return serviceService.getAllService();
    }
    //@GetMapping("/usuario/{usuarioId}")
    //public ResponseEntity<List<Servicee>> getAllServicesByUsuarioId(@PathVariable Long projectId){
      //  return serviceService.getAllServicesByUsuarioId(projectId);
        //adicionar client;
    //   }
    @GetMapping("{id}")
    public ResponseEntity<Servicee> getServiceById(@PathVariable Long id){
        System.out.println(id);
        return serviceService.findById(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity excluirService (@PathVariable Long id){
        return this.serviceService.deleteById(id);
    }
}


