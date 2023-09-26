package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Comision {

    private Integer id;
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private Materia materia;
    private CicloElectivo cicloElec;
    private ArrayList<Nota> notas = new ArrayList<>();
    private String turnoyDia;
    private Aula aula;

    public Comision(Integer id, Materia materia, CicloElectivo cicloElec, String turnoyDia) {
        super();
        this.id = id;
        this.materia = materia;
        this.cicloElec = cicloElec;
        this.turnoyDia = turnoyDia;
    }

    public Comision(Integer id, ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, Materia materia,
            CicloElectivo cicloElec, ArrayList<Nota> nota, String turnoyDia, Aula aula) {
        super();
        this.id = id;
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.materia = materia;
        this.cicloElec = cicloElec;
        this.notas = nota;
        this.turnoyDia = turnoyDia;
        this.aula = aula;
    }
    
    public void agregarProfesorAComision(Profesor profe) {
    	profesores.add(profe);
    }
    
    public void agregarAlumnosAComision(Alumno alumno) {
    	alumnos.add(alumno);
    }
    
    public void agregarNotasAComision(Nota nota) {
    	notas.add(nota);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
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

	public ArrayList<Nota> getNota() {
		return notas;
	}

	public void setNota(ArrayList<Nota> nota) {
		this.notas = nota;
	}

	public String getTurnoyDia() {
		return turnoyDia;
	}

	public void setTurnoyDia(String turnoyDia) {
		this.turnoyDia = turnoyDia;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

/*public class Comision {

	private Integer id;
	private ArrayList<Alumno> alumnos;
	private Profesor profesor;
	private Materia materia;
	private CicloElectivo cicloElec;
	private Nota nota;
	private String turno;
	private Aula aula;

	public Comision(Integer id, Alumno alumno, Profesor profesor, Materia materia, CicloElectivo cicloElec, Nota nota,
			String turno) {
		super();
		this.id = id;
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = profesor;
		this.materia = materia;
		this.cicloElec = cicloElec;
		this.nota = nota;
		this.turno = turno;
	}
	
	

	public Comision(Integer id, ArrayList<Alumno> alumnos, Profesor profesor, Materia materia, CicloElectivo cicloElec,
			Nota nota, String turno, Aula aula) {
		super();
		this.id = id;
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.materia = materia;
		this.cicloElec = cicloElec;
		this.nota = nota;
		this.turno = turno;
		this.aula = aula;
	}*/

}
