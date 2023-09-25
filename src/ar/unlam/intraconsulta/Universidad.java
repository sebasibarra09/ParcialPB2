package ar.unlam.intraconsulta;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<InscripcionMateria> inscripcionesMateria;
	private ArrayList<CicloElectivo> cicloElect;
	private ArrayList<Profesor> profesores;
	private ArrayList<Comision> comisiones;
	private ArrayList<Correlatividad> correlativas;
	private ArrayList<Aula> aulas; 

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.cicloElect = new ArrayList<CicloElectivo>();
		this.materias = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.correlativas = new ArrayList<>();
		this.inscripcionesMateria = new ArrayList<>();
		this.aulas = new ArrayList<>();
	}

	public Boolean agregarMateria(Materia materia) {
		if (!this.materias.contains(materia))
			return this.materias.add(materia);
		return false;
	}

	public Boolean agregarAlumno(Alumno alumno) {
		if (!this.alumnos.contains(alumno))
			return this.alumnos.add(alumno);
		return false;
	}

	public Boolean agregarCicloLectivo(CicloElectivo cicloElectiv) {
		for (int i = 0; i < this.cicloElect.size(); i++) {
			if ((this.cicloElect.get(i).getId().equals(cicloElectiv.getId())) || (this.cicloElect.get(i)
					.getFechaFinalizacionCicloLectivo().isBefore(cicloElectiv.getFechaInicioCicloLectivo())))
				return false;
		}
		return this.cicloElect.add(cicloElectiv);
	}

	public Boolean agregarComision(Comision comi) {
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (((this.comisiones.get(i).getId().equals(comi.getId()))
					|| (this.comisiones.get(i).getMateria().getCodigo().equals(comi.getMateria().getCodigo()))
							&& (this.comisiones.get(i).getCicloElec().getId().equals(comi.getCicloElec().getId()))
							&& (this.comisiones.get(i).getTurno().equals(comi.getTurno()))))
				return false;
		}
		return this.comisiones.add(comi);

	}

	public Boolean agregarDocentes(Profesor profe) {
		if (!this.profesores.contains(profe))
			return this.profesores.add(profe);
		return false;

	}

	public Boolean asignarDocentesAComision(Profesor profe, Comision comi) {
		if (!comi.getProfesor().equals(profe)) {
			comi.setProfesor(profe);
			return true;
		}
		return false;
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

	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);
		if (alumno != null && materia != null) {
			InscripcionMateria inscripcionMateria = new InscripcionMateria(alumno, materia);
			return this.inscripcionesMateria.add(inscripcionMateria);
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
	
	private Comision buscarComisionPorId(Integer codigo) {
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(codigo))
				return this.comisiones.get(i);
		}
		return null;
	}

	public Boolean agregarCorrelatividad(Integer codigo1, Integer codigo2) {
		Materia materia1 = this.buscarMateriaPorCodigo(codigo1);
		Materia materia2 = this.buscarMateriaPorCodigo(codigo2);
		if(materia1 != null && materia2 != null) {
		Correlatividad correlativa = new Correlatividad(materia1, materia2);
		this.correlativas.add(correlativa);
		return true;		
		}
		return false;
	}
	
	public Boolean agregarAula(Aula aula) {
		if (!this.aulas.contains(aula))
			return this.aulas.add(aula);
		return false;
	}
	
	public Aula buscarAulaPorId(Integer codigo) {
		for (int i = 0; i < this.aulas.size(); i++) {
			if (this.aulas.get(i).getId().equals(codigo))
				return this.aulas.get(i);
		}
		return null;
	}
	
	public Profesor buscarDocentePorDni(Integer codigo) {
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(codigo))
				return this.profesores.get(i);
		}
		return null;
	}
	
	public Boolean asignarAulaAlaComision(Integer idComision, Integer dniDocente, Integer idAula) {
		Aula aula = this.buscarAulaPorId(idAula);
		Comision comi = this.buscarComisionPorId(idComision);
		Profesor profe = this.buscarDocentePorDni(dniDocente);
		if (aula != null && comi != null && profe!= null) {
			aula.setIdComision(idComision);
			return true;
		}
		
		return false;
	}

	public boolean inscribirAlumnoAComision(Integer dni, Integer id, Integer idAula) {
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Comision comi = this.buscarComisionPorId(id);
		Aula aula = this.buscarAulaPorId(idAula);
		LocalDate fecha = LocalDate.now();
		if(alumno == null || comi == null) {
			return false;		
			}
		if (!alumno.getMateriasAprobadas().contains(buscarCorrelativa(comi.getMateria()))) {
			if(buscarCorrelativa(comi.getMateria()) != null) 
				return false;
		}
		if (!(comi.getCicloElec().getFechaInicioInscripcion().isBefore(fecha) && comi.getCicloElec().getFechaFinalizacionInscripcion().isAfter(fecha))) {
			return false;
		}
		;
		if (aula.getCantidadAlumnos()-1 < 0) {
			return false;
		} else {
			aula.setCantidadAlumnos(aula.getCantidadAlumnos()-1);
		}
		
		
		
		if(alumno.getMateriasAprobadas().contains(comi.getMateria())) {
			return false;
		}
			
		
		return true;
	}
	
	public Boolean notaValida(Integer examen) {
		if (examen>=  1 && examen <=10) {
				return true;	
		} 
		return false;
	}
	
	public Materia buscarCorrelativa(Materia mat) {
		for (int i = 0; i < this.correlativas.size(); i++) {
			if (this.correlativas.get(i).getMateria2().equals(mat))
				return this.correlativas.get(i).getMateria1();
		}
		return null;
	}
	
	
	public boolean registrarNota (Integer IdComision, Integer IdAlumno, Nota nota) {
		Alumno alumno = this.buscarAlumnoPorDni(IdAlumno);
		Comision comi = this.buscarComisionPorId(IdComision);
		if (!(notaValida(nota.getNotaParcial1()) && notaValida(nota.getNotaParcial2()) &&
				notaValida(nota.getNotaRecu()) && notaValida(nota.getNotaFinal()))){
			return false;
		}
		
		if (!(alumno.getMateriasAprobadas().contains(buscarCorrelativa(comi.getMateria())))){
			if(buscarCorrelativa(comi.getMateria()) != null){
				if(nota.getNotaFinal() >= 7)
					return false;	
			}
		}
		if(nota.getNotaParcial1() < nota.getNotaParcial2()) {
			nota.setNotaParcial1(nota.getNotaRecu());
		}else {
			nota.setNotaParcial2(nota.getNotaRecu());
		}	
		
		if(nota.getNotaParcial1() < 4 || nota.getNotaParcial2() <4) {
			return false;
		}
		
		alumno.agregarMateria(comi.getMateria());
		alumno.agregarNotas(nota.getNotaFinal());
		return true;
	}
	
	public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno(Integer idAlumno) {
		Alumno alumno = this.buscarAlumnoPorDni(idAlumno);
		return alumno.getMateriasAprobadas();
		
	}
	
	public Integer obtenerNota(Integer idAlumno, Integer idMateria) {

        Alumno alumno = this.buscarAlumnoPorDni(idAlumno);
        for (int i = 0; i < alumno.getMateriasAprobadas().size(); i++) {
            if (alumno.getMateriasAprobadas().get(i).getCodigo().equals(idMateria)) {
                return alumno.getNotasMaterias().get(i);
            }
        }
        return null;
    }

	

	
}
