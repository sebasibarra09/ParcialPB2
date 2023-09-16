package ar.unlam.intraconsulta;

import java.time.LocalDate;

public class Alumno {

	private Integer id;
	private Integer dni;
	private LocalDate fechaNacimiento;
	private String apellido;
	private String nombre;

	public Alumno(Integer id, Integer dni, LocalDate fechaNacimiento, String apellido, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
