package com.marcos.medical.Medical_attendance.model.medico;

import com.marcos.medical.Medical_attendance.model.paciente.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicosDao {
    @Autowired
    private MedicosRepository repository;

    public Medicos save(Medicos medico) {return repository.save(medico);}

    public List<Medicos> getAllMedicos() {
        List<Medicos> result = new ArrayList<Medicos>();
        repository.findAll().forEach(result::add);
        return result;
    }
    public void delete(int id) {repository.deleteById(id);}
}
