package com.marcos.medical.Medical_attendance.model.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultasDao {
    @Autowired
    private ConsultasRepository repository;

    public Consultas save(Consultas consulta) {
        return repository.save(consulta);
    }

    public List<Consultas> getAllConsultas() {
        List<Consultas> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public Consultas getConsultaById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Consultas> getConsultasByPacienteId(int pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    public List<Consultas> getConsultasByMedicoId(int medicoId) {
        return repository.findByMedicoId(medicoId);
    }
}
