package com.marcos.medical.Medical_attendance.controller;

import com.marcos.medical.Medical_attendance.model.medico.Medicos;
import com.marcos.medical.Medical_attendance.model.medico.MedicosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicosController {
    @Autowired
    private MedicosDao medicosDao;

    @GetMapping("/medicos/getAll")
    public List<Medicos> getAllMedicos() {
        return medicosDao.getAllMedicos();
    }

    @PostMapping("/medicos/save")
    public Medicos save(@RequestBody Medicos medico) {
        return medicosDao.save(medico);
    }

    @PostMapping("/medicos/login")
    public Medicos login(@RequestBody Medicos loginRequest) {
        List<Medicos> medicosList = medicosDao.getAllMedicos();
        for (Medicos medico : medicosList) {
            if (medico.getNome().equals(loginRequest.getNome()) && medico.getPass().equals(loginRequest.getPass())) {
                return medico;
            }
        }
        return null;
    }
}
