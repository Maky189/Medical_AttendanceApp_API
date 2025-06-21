package com.marcos.medical.Medical_attendance.model.consulta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConsultasDaoTest {
    @Mock
    private ConsultasRepository repository;

    @InjectMocks
    private ConsultasDao consultasDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Consultas consulta = new Consultas();
        when(repository.save(consulta)).thenReturn(consulta);
        Consultas saved = consultasDao.save(consulta);
        assertEquals(consulta, saved);
    }

    @Test
    void testGetAllConsultas() {
        Consultas c1 = new Consultas();
        Consultas c2 = new Consultas();
        when(repository.findAll()).thenReturn(Arrays.asList(c1, c2));
        List<Consultas> result = consultasDao.getAllConsultas();
        assertEquals(2, result.size());
    }

    @Test
    void testGetConsultaById() {
        Consultas consulta = new Consultas();
        when(repository.findById(1)).thenReturn(Optional.of(consulta));
        Consultas found = consultasDao.getConsultaById(1);
        assertEquals(consulta, found);
    }

    @Test
    void testGetConsultasByPacienteId() {
        Consultas consulta = new Consultas();
        when(repository.findByPacienteId(1)).thenReturn(Arrays.asList(consulta));
        List<Consultas> result = consultasDao.getConsultasByPacienteId(1);
        assertEquals(1, result.size());
    }

    @Test
    void testGetConsultasByMedicoId() {
        Consultas consulta = new Consultas();
        when(repository.findByMedicoId(1)).thenReturn(Arrays.asList(consulta));
        List<Consultas> result = consultasDao.getConsultasByMedicoId(1);
        assertEquals(1, result.size());
    }
}

