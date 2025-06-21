package com.marcos.medical.Medical_attendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcos.medical.Medical_attendance.model.consulta.Consultas;
import com.marcos.medical.Medical_attendance.model.consulta.ConsultasDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConsultasController.class)
class ConsultasControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultasDao consultasDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterConsulta() throws Exception {
        Consultas consulta = new Consultas();
        consulta.setId(1);
        consulta.setPacienteId(1);
        consulta.setMedicoId(1);
        consulta.setData(Date.valueOf("2021-01-01"));
        consulta.setHora(Time.valueOf("08:00:00"));
        consulta.setDescricao("Consulta de Cardiologia");
        consulta.setStatus("Realizada");
        when(consultasDao.save(any(Consultas.class))).thenReturn(consulta);
        mockMvc.perform(post("/consultas/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(consulta)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testGetConsultasByPaciente() throws Exception {
        Consultas consulta = new Consultas();
        consulta.setPacienteId(1);
        List<Consultas> list = Arrays.asList(consulta);
        when(consultasDao.getConsultasByPacienteId(eq(1))).thenReturn(list);
        Map<String, Integer> body = new HashMap<>();
        body.put("pacienteId", 1);
        mockMvc.perform(post("/consultas/byPaciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pacienteId").value(1));
    }

    @Test
    void testGetConsultasByMedico() throws Exception {
        Consultas consulta = new Consultas();
        consulta.setMedicoId(1);
        List<Consultas> list = Arrays.asList(consulta);
        when(consultasDao.getConsultasByMedicoId(eq(1))).thenReturn(list);
        Map<String, Integer> body = new HashMap<>();
        body.put("medicoId", 1);
        mockMvc.perform(post("/consultas/byMedico")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].medicoId").value(1));
    }

    @Test
    void testGetAllConsultas() throws Exception {
        Consultas consulta = new Consultas();
        when(consultasDao.getAllConsultas()).thenReturn(Arrays.asList(consulta));
        mockMvc.perform(get("/consultas/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    void testMarkConsultaAsDone() throws Exception {
        Consultas consulta = new Consultas();
        consulta.setId(1);
        consulta.setStatus("Pendente");
        when(consultasDao.getConsultaById(1)).thenReturn(consulta);
        Consultas doneConsulta = new Consultas();
        doneConsulta.setId(1);
        doneConsulta.setStatus("Realizada");
        when(consultasDao.save(any(Consultas.class))).thenReturn(doneConsulta);
        Map<String, Integer> body = new HashMap<>();
        body.put("id", 1);
        mockMvc.perform(post("/consultas/markDone")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Realizada"));
    }
}

