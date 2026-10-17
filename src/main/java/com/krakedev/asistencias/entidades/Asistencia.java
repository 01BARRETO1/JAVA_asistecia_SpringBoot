package com.krakedev.asistencias.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Asistencia {
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaClase;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaHoraRegistro;

    private String estado; // P-Presente A-Ausente
	
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

	// get and set 
	public LocalDate getFechaClase() {
		return fechaClase;
	}

	public void setFechaClase(LocalDate fechaClase) {
		this.fechaClase = fechaClase;
	}

	public LocalDateTime getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}
