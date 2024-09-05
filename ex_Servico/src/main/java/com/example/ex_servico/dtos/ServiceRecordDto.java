package com.example.ex_servico.dtos;

import com.example.ex_servico.model.Enum.ServiceType;

import java.math.BigDecimal;

public record ServiceRecordDto(String name, BigDecimal cost,Long clientId, String description, ServiceType type) {
}
