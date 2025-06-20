package com.marcos.medical.Medical_attendance.controller;

import com.marcos.medical.Medical_attendance.model.paciente.Pacientes;
import com.marcos.medical.Medical_attendance.model.paciente.PacientesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacientesController {

    @Autowired
    private PacientesDao pacientesDao;

    @GetMapping("/pacientes/getAll")
    public List<Pacientes> getAllPacientes() {
        return pacientesDao.getAllPacientes();
    }

    @PostMapping("/pacientes/save")
    public Pacientes save(@RequestBody Pacientes paciente) {
        return pacientesDao.save(paciente);
    }

    @PostMapping("/pacientes/login")
    public Pacientes login(@RequestBody Pacientes loginRequest) {
        List<Pacientes> pacientesList = pacientesDao.getAllPacientes();
        for (Pacientes paciente : pacientesList) {
            if (paciente.getNome().equals(loginRequest.getNome()) && paciente.getPass().equals(loginRequest.getPass())) {
                return paciente;
            }
        }
        return null;
    }
}
