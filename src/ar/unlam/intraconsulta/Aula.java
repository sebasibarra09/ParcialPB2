package ar.unlam.intraconsulta;

public class Aula {
	
	private Integer id;
	private Integer cantidadAlumnos;
	private Integer idComision;
	

	public Aula(Integer id, Integer cantidadAlumnos, Integer idComision) {
		super();
		this.id = id;
		this.cantidadAlumnos = cantidadAlumnos;
		this.idComision = idComision;
	}

	public Aula(Integer id, Integer cantidadAlumnos) {
		this.id = id;
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(Integer cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	
}
