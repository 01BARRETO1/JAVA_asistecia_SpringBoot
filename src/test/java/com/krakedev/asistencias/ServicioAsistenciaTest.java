package com.krakedev.asistencias;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.services.ServicioAsistencia;
import com.krakedev.asistencias.services.ServicioEstudiantes;

public class ServicioAsistenciaTest {

    @Test
    public void testRegistrarAsistenciaEstudianteExistente() {
        // Se prueba que al registrar asistencia de un estudiante existente
        // se retorna un objeto RegistroAsistencia con datos válidos.
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        Estudiante estudiante = new Estudiante("123", "Carlos", "Barreto");
        servicioEstudiantes.agregar(estudiante);

        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);
        RegistroAsistencia registro = servicioAsistencia.registrarAsistencia("123");

        assertNotNull(registro, "El registro no debe ser nulo");
        assertEquals("123", registro.getEstudiante().getCedula(), "La cédula debe coincidir");
        assertEquals("P", registro.getAsistencia().getEstado(), "El estado debe ser 'P'");
    }

    @Test
    public void testRegistrarAsistenciaEstudianteInexistente() {
        // Se prueba que al intentar registrar asistencia de un estudiante inexistente
        // el método retorna null.
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);

        RegistroAsistencia registro = servicioAsistencia.registrarAsistencia("999");

        assertNull(registro, "Debe retornar null si el estudiante no existe");
    }

    @Test
    public void testConsultarAsistenciaConRegistros() {
        // Se prueba que consultar asistencias de un estudiante existente
        // retorna una lista con las asistencias registradas.
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        Estudiante estudiante = new Estudiante("123", "Carlos", "Barreto");
        servicioEstudiantes.agregar(estudiante);

        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);
        servicioAsistencia.registrarAsistencia("123");
        servicioAsistencia.registrarAsistencia("123");

        ArrayList<Asistencia> asistencias = servicioAsistencia.consultarAsistencia("123");

        assertNotNull(asistencias, "La lista no debe ser nula");
        assertEquals(2, asistencias.size(), "Debe contener 2 asistencias registradas");
    }

    @Test
    public void testConsultarAsistenciaEstudianteSinRegistros() {
        // Se prueba que consultar asistencias de un estudiante existente
        // pero sin registros retorna una lista vacía.
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        Estudiante estudiante = new Estudiante("456", "Ana", "Perez");
        servicioEstudiantes.agregar(estudiante);

        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);
        ArrayList<Asistencia> asistencias = servicioAsistencia.consultarAsistencia("456");

        assertNotNull(asistencias, "La lista no debe ser nula");
        assertTrue(asistencias.isEmpty(), "Debe estar vacía si no hay asistencias");
    }

    @Test
    public void testConsultarAsistenciaEstudianteInexistente() {
        // Se prueba que consultar asistencias de un estudiante inexistente
        // retorna una lista vacía (según tu implementación actual).
        ServicioEstudiantes servicioEstudiantes = new ServicioEstudiantes();
        ServicioAsistencia servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);

        ArrayList<Asistencia> asistencias = servicioAsistencia.consultarAsistencia("999");

        assertNotNull(asistencias, "La lista no debe ser nula");
        assertTrue(asistencias.isEmpty(), "Debe estar vacía si el estudiante no existe");
    }
}
