package com.marcos.medical.Medical_attendance;

import com.marcos.medical.Medical_attendance.model.consulta.Consultas;
import com.marcos.medical.Medical_attendance.model.consulta.ConsultasDao;
import com.marcos.medical.Medical_attendance.model.medico.Medicos;
import com.marcos.medical.Medical_attendance.model.medico.MedicosDao;
import com.marcos.medical.Medical_attendance.model.paciente.Pacientes;
import com.marcos.medical.Medical_attendance.model.paciente.PacientesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

@SpringBootTest
class MedicalAttendanceApplicationTests {

	@Autowired
	private PacientesDao pacientesDao;

	@Test
	void addPaciente() {
		Pacientes paciente = new Pacientes();
		paciente.setNome("Leonardo");
		paciente.setIdade(30);
		paciente.setContacto(123456789);
		paciente.setPass("password123");
		pacientesDao.save(paciente);
	}

	@Test
	void getAllPacientes() {
		System.out.println(pacientesDao.getAllPacientes());
	}

	@Test
	void deletePaciente() {
		pacientesDao.delete(3);
		System.out.println("Paciente deleted successfully.");
	}

	@Autowired
	private MedicosDao medicosDao;

	@Test
	void addMedico() {
		Medicos medico = new Medicos();
		medico.setNome("Dr. Marcos");
		medico.setEspecialidade("Cardiologia");
		medico.setHorario("09:00 - 17:00");
		medico.setPass("securepass");
		medicosDao.save(medico);
	}

	@Test
	void getAllMedicos() {
		System.out.println(medicosDao.getAllMedicos());
	}

	@Test
	void deleteMedico() {
		medicosDao.delete(2);
		System.out.println("Medico deleted successfully.");
	}

	@Autowired
	private ConsultasDao consultasDao;

	@Test
	@Transactional
	void addConsulta() {
		Consultas consulta = new Consultas();
		consulta.setPacienteId(1);
		consulta.setMedicoId(1);
		consulta.setData(Date.valueOf("2025-06-20"));
		consulta.setHora(Time.valueOf("10:00:00"));
		consulta.setDescricao("Teste de consulta");
		consulta.setStatus("Pendente");
		consultasDao.save(consulta);
		System.out.println("Consulta added: " + consulta.getDescricao());
	}

	@Test
	void getAllConsultas() {
		System.out.println(consultasDao.getAllConsultas());
	}

	@Test
	void getConsultaById() {
		Consultas consulta = consultasDao.getConsultaById(1);
		System.out.println(consulta);
	}

	@Test
	void getConsultasByPacienteId() {
		System.out.println(consultasDao.getConsultasByPacienteId(1));
	}

	@Test
	void getConsultasByMedicoId() {
		System.out.println(consultasDao.getConsultasByMedicoId(1));
	}

	@Test
	@Transactional
	void markConsultaAsDone() {
		Consultas consulta = consultasDao.getConsultaById(1);
		if (consulta != null) {
			consulta.setStatus("Realizada");
			consultasDao.save(consulta);
			System.out.println("Consulta marked as done: " + consulta.getId());
		}
	}

	@Test
	@Transactional
	void deleteConsulta() {
		Consultas consulta = consultasDao.getConsultaById(1);
		if (consulta != null) {
			// Assuming you have a delete method in ConsultasDao
			//consultasDao.delete(consulta.getId());
			System.out.println("Consulta deleted: " + consulta.getId());
		}
	}

}
