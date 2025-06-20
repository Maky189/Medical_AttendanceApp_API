package com.marcos.medical.Medical_attendance.controller;

import com.marcos.medical.Medical_attendance.model.consulta.Consultas;
import com.marcos.medical.Medical_attendance.model.consulta.ConsultasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ConsultasController {
    @Autowired
    private ConsultasDao consultasDao;

    @PostMapping("/consultas/register")
    public Consultas registerConsulta(@RequestBody Consultas consulta) {
        return consultasDao.save(consulta);
    }

    @PostMapping("/consultas/byPaciente")
    public List<Consultas> getConsultasByPaciente(@RequestBody Map<String, Integer> body) {
        int pacienteId = body.get("pacienteId");
        return consultasDao.getConsultasByPacienteId(pacienteId);
    }

    @PostMapping("/consultas/byMedico")
    public List<Consultas> getConsultasByMedico(@RequestBody Map<String, Integer> body) {
        int medicoId = body.get("medicoId");
        return consultasDao.getConsultasByMedicoId(medicoId);
    }

    @GetMapping("/consultas/getAll")
    public List<Consultas> getAllConsultas() {
        return consultasDao.getAllConsultas();
    }

    @PostMapping("/consultas/markDone")
    public Consultas markConsultaAsDone(@RequestBody Map<String, Integer> body) {
        int id = body.get("id");
        Consultas consulta = consultasDao.getConsultaById(id);
        if (consulta != null) {
            consulta.setStatus("Realizada");
            return consultasDao.save(consulta);
        }
        return null;
    }
}
