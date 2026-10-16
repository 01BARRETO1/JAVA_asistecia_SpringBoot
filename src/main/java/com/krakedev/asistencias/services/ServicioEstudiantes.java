package com.krakedev.asistencias.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {
	
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	
	//no permite duplicados
	public void agregar(Estudiante estudiante) {
		Estudiante newEstudiante=buscarPorCedula(estudiante.getCedula());
		
		if(newEstudiante==null) {
			estudiantes.add(estudiante);
		}else {
			//Ya existe
		}
		
		
	}
	
	public Estudiante buscarPorCedula(String cedula) {
		
		for(Estudiante estudiante: estudiantes) {
			String e=estudiante.getCedula();
			if(e.equals(cedula)) {
				
				return estudiante;
			}
		}
		return null;
	}
	
	

}
