package ar.unlam.intraconsulta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	// private Alumno [] alumnos;
	private ArrayList<Alumno> alumnos;
	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList <InscripcionMateria> inscripcionesMateria;
	private CicloElectivo cicloElect;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
	}

	public Boolean registrarAlumno(Alumno alumno) {
		   for (int i = 0; i < this.alumnos.size(); i++) {
	            if (this.alumnos.get(i).getDni().equals(alumno.getDni()))
	                return false;
	        }
	        return this.alumnos.add(alumno);

	    }

	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return this.alumnos.get(i);
		}
		
		return null;
	}

	public Boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	public Boolean registraMateria(Materia materia) {
        for (int i = 0; i < this.materias.size(); i++) {
            if (this.materias.get(i).getCodigo().equals(materia.getCodigo()))
                return false;
        }
        return this.materias.add(materia);

    }

	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {
	
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);
		
		if (alumno != null && materia != null) {
			
	    InscripcionMateria  inscripcionMateria = new InscripcionMateria (alumno,materia);
		return this.inscripcionesMateria.add(inscripcionMateria );
			
		}
		
		return false;
	}

	private Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo))
				return this.materias.get(i);
		}
		return null;
	}
	
	
}
