package com.marcos.medical.Medical_attendance.model.medico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicosRepository extends CrudRepository<Medicos, Integer> {
}
