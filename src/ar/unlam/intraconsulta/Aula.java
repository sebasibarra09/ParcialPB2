package ar.unlam.intraconsulta;

public class Aula {
	private Integer id;
	private Integer cantidadMaximaAlumnos;

	public Aula(Integer id, Integer cantidadMaximaAlumnos) {
		this.id = id;
		this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidadMaximaAlumnos() {
		return cantidadMaximaAlumnos;
	}

	public void setCantidadMaximaAlumnos(Integer cantidadMaximaAlumnos) {
		this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
	}

}
