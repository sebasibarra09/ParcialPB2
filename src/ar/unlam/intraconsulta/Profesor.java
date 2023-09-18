package ar.unlam.intraconsulta;

public class Profesor {

	private Integer codigo;
	private String apellido;
	private String nombre;

	public Profesor(Integer codigo, String apellido, String nombre) {
		super();
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
