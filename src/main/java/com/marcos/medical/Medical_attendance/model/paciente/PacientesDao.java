package com.marcos.medical.Medical_attendance.model.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacientesDao {
    @Autowired
    private PacientesRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Pacientes save(Pacientes paciente) {
        if (paciente.getPass() != null && (paciente.getId() == 0 || !paciente.getPass().startsWith("$2a$"))) {
            paciente.setPass(passwordEncoder.encode(paciente.getPass()));
        }
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
