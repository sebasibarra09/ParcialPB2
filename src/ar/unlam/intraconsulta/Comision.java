package ar.unlam.intraconsulta;

public class Comision {

	private Integer id;
	private Materia materia;
	private CicloElectivo cicloElec;
	private String turno;
	
	
	public Comision(Integer id, Materia materia, CicloElectivo cicloElec, String turno) {
		this.id = id;
		this.materia = materia;
		this.cicloElec = cicloElec;
		this.turno = turno;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public CicloElectivo getCicloElec() {
		return cicloElec;
	}
	public void setCicloElec(CicloElectivo cicloElec) {
		this.cicloElec = cicloElec;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}

}
