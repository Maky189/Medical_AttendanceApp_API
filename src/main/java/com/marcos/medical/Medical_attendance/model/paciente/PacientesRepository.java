package com.marcos.medical.Medical_attendance.model.paciente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends CrudRepository<Pacientes, Integer> {

}
