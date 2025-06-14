package com.marcos.medical.Medical_attendance;

import com.marcos.medical.Medical_attendance.model.medico.Medicos;
import com.marcos.medical.Medical_attendance.model.medico.MedicosDao;
import com.marcos.medical.Medical_attendance.model.paciente.Pacientes;
import com.marcos.medical.Medical_attendance.model.paciente.PacientesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicalAttendanceApplicationTests {

	//@Autowired
	private PacientesDao pacientesDao;

	//@Test
	void addPaciente() {
		Pacientes paciente = new Pacientes();
		paciente.setNome("Leonardo");
		paciente.setIdade(30);
		paciente.setContacto(123456789);
		paciente.setPass("password123");
		pacientesDao.save(paciente);
	}

	//@Test
	void getAllPacientes() {
		System.out.println(pacientesDao.getAllPacientes());
	}

	//@Test
	void deletePaciente() {
		pacientesDao.delete(3);
		System.out.println("Paciente deleted successfully.");
	}

	//@Autowired
	private MedicosDao medicosDao;

	//@Test
	void addMedico() {
		Medicos medico = new Medicos();
		medico.setNome("Dr. Marcos");
		medico.setEspecialidade("Cardiologia");
		medico.setHorario("09:00 - 17:00");
		medico.setPass("securepass");
		medicosDao.save(medico);
	}

	//@Test
	void getAllMedicos() {
		System.out.println(medicosDao.getAllMedicos());
	}

	//@Test
	void deleteMedico() {
		medicosDao.delete(2);
		System.out.println("Medico deleted successfully.");
	}

}
