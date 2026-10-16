package com.krakedev.asistencias.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {

	private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	
	//-----------Método agregar
	// no permite duplicados
	public void agregar(Estudiante estudiante) {
		Estudiante newEstudiante = buscarPorCedula(estudiante.getCedula());

		if (newEstudiante == null) {
			estudiantes.add(estudiante);
		} else {
			// Ya existe
		}

	}
	
	//-----------método buscarPorCedula

	public Estudiante buscarPorCedula(String cedula) {

		for (Estudiante estudiante : estudiantes) {
			String e = estudiante.getCedula();
			if (e.equals(cedula)) {

				return estudiante;
			}
		}
		return null;
	}
	
	//------------- Método eliminar

	public void eliminar(String cedula) {
		Estudiante estudiante = buscarPorCedula(cedula);

		if (estudiante != null) {
			estudiantes.remove(estudiante);
		} else {
			// No existe
		}

	}
	
	//-----------Método actualizar
	
	public void actualizar(String cedula, Estudiante nuevo) {
		Estudiante estudiante = buscarPorCedula(cedula);

		if (estudiante != null) {
			estudiante.setApellido(nuevo.getApellido());
			estudiante.setNombre(nuevo.getNombre());
		} else {
			// No existe
		}
		
	}
	
	//--------------Listar()
	
	public ArrayList<Estudiante> listar() {
		return estudiantes;
	}
	
	

}
