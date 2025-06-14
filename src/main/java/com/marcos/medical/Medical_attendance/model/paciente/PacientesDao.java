package com.marcos.medical.Medical_attendance.model.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacientesDao {
    @Autowired
    private PacientesRepository repository;

    public Pacientes save(Pacientes paciente) {
        return repository.save(paciente);
    }

    public List<Pacientes> getAllPacientes() {
        List<Pacientes> result = new ArrayList<Pacientes>();
        repository.findAll().forEach(result::add);
        return result;
    }
    public void delete(int id) {
        repository.deleteById(id);
    }
}
