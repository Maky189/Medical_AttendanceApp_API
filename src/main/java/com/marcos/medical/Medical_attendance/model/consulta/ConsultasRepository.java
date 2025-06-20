package com.marcos.medical.Medical_attendance.model.consulta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultasRepository extends CrudRepository<Consultas, Integer> {
    List<Consultas> findByPacienteId(int pacienteId);
    List<Consultas> findByMedicoId(int medicoId);
}
