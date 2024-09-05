package com.example.ex_servico.model;

import com.example.ex_servico.model.Enum.ServiceType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="TB_SERVICE")
public class Servicee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal cost;
    private Long clienteId;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long cliente) {
        this.clienteId = cliente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }
}


