package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.services.ServicioEstudiantes;

@RestController

@RequestMapping("/estudiantes")
public class ControladorEstudiantes {

	// inyección de dependencias por constructor en Spring Boot.
	private final ServicioEstudiantes servicioEstudiante;

	// Constructor: Spring inyecta automáticamente la instancia
	public ControladorEstudiantes(ServicioEstudiantes servicioEstudiante) {

		this.servicioEstudiante = servicioEstudiante;
	}

	// -----------Método agregar
	// no permite duplicados
	 // POST: crear estudiante
	@PostMapping
	public void agregarEstudiante(@RequestBody Estudiante estudiante) {
		
		servicioEstudiante.agregar(estudiante);
	}
	
	//-----------método buscarPorCedula
	//GET:  buscarPorCedula
	@GetMapping("/{cedula}")
	public Estudiante buscarEstudiante(@PathVariable String cedula) {
		return servicioEstudiante.buscarPorCedula(cedula);
	}
	
	//------------- Método eliminar
	//DELET: eliminar
	@DeleteMapping("/{cedula}")
	public void eliminarEstudiante(@PathVariable String cedula) {
		servicioEstudiante.eliminar(cedula);
	}
	
	//-----------Método actualizar
	//PUT: actualizar estudiante
	@PutMapping("/{cedula}")
	public void actualizarEstudiante(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
		servicioEstudiante.actualizar(cedula, estudiante);
	}
	
	//--------------Listar()
	// GET: listar estudiantes
	@GetMapping
	public ArrayList<Estudiante> listar(){
		return servicioEstudiante.listar();
	}
	

}
