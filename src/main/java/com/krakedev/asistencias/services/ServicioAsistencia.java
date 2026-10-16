package com.krakedev.asistencias.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {

	private ArrayList<RegistroAsistencia> registros = new ArrayList<RegistroAsistencia>();

	// Final protege: asegura que esa referencia no se pueda cambiar después.
	private final ServicioEstudiantes servicioEstudiantes;// Spring instancia

	// Cosntructor que permite inyectar dependencias
	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	public RegistroAsistencia registrarAsistencia(String cedula) {
		// Buscar estudiante por cedula, en servicioEstudiantes
		Estudiante estudianteTrabaja = servicioEstudiantes.buscarPorCedula(cedula);
		// si no existe el estudiante retorna null
		if (estudianteTrabaja == null) {

			return null;
		} else {
			// crea la asistencia, con la fecha y hora actuales
			Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");
			// crea un registro asistencia, agrega a la lista, retorna el registro creado
			RegistroAsistencia alumnoPresente = new RegistroAsistencia(estudianteTrabaja, asistencia);
			registros.add(alumnoPresente);
			return alumnoPresente;
		}

	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		// retorna todas las asistencias del estudiante
		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);
		ArrayList<Asistencia> asistencia = new ArrayList<Asistencia>();
		if (estudiante != null) {
			
			for (RegistroAsistencia asistenciasDelJoven : registros) {
				String cedulaEstudiante = asistenciasDelJoven.getEstudiante().getCedula();
				if (cedulaEstudiante.equals(cedula)) {
					asistencia.add(asistenciasDelJoven.getAsistencia());

				}

			}
			
		}
		return asistencia;
	}

}
