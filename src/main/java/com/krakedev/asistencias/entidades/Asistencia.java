package com.krakedev.asistencias.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asistencia {
	private LocalDate fechaClase;
	private LocalDateTime fechaHoraRegistro;
	private String estado; //P-Presente A-Ausente
	
	//Constructor
	public Asistencia(LocalDate fechaClase, LocalDateTime fechaHoraRegistro, String estado) {
		super();
		this.fechaClase = fechaClase;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.estado = estado;
	}
	
	//To String
	@Override
	public String toString() {
		return "Asistencia [fechaClase=" + fechaClase + ", fechaHoraRegistro=" + fechaHoraRegistro + ", estado="
				+ estado + "]";
	}
	
	
	
	
	
	
}
