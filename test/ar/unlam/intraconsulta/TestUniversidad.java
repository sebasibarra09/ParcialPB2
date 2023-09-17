package ar.unlam.intraconsulta;

import static org.junit.Assert.*;
import java.time.LocalDate;


import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	LocalDate fechaNacimiento= LocalDate.of(2005, 5, 8);
    	Integer dni= 44555; 
    	Alumno alumno = new Alumno (dni,fechaNacimiento,apellido, nombre);
		Boolean registroExitoso = unlam.registrarAlumno(alumno);
    	assertTrue(registroExitoso);	
	}
	
	@Test
	public void queNoSePuedaRegistrarUnAlumnoConMismoDni() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	LocalDate fechaNacimiento= LocalDate.of(2005, 5, 8);
    	Integer dni= 44555; 
    	Alumno alumno = new Alumno (dni,fechaNacimiento,apellido, nombre);
		unlam.registrarAlumno(alumno);
    	assertFalse(unlam.registrarAlumno(new Alumno(44555,LocalDate.of(2005, 5, 8), "Fernandez", "Gonzalo" )));	
	}
	
	
	/*
	@Test
	public void queNoSePuedaRegistrarUnAlumnoCuandoElAlumnoYaEsteRegistradoAUnaUniversidad() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	Integer dni= 44555; 
    	Alumno alumno = new Alumno (dni,apellido, nombre);
    	Alumno alumno2 = new Alumno (dni,"jose", "Lopez");
    	unlam.registrar(alumno);
		Boolean registroExitoso = unlam.registrar(alumno2);
    	assertFalse(registroExitoso);
    	
    	
	}
	*/
	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "PB2 ";
        Integer codigo = 1;
        Materia pb2 = new Materia (codigo,nombre);
        assertTrue (unlam.registraMateria(pb2));     
	}
	
	@Test
    public void queNoSePuedaRegistrarDosMateriaConMismoIDAUnaUniversidad() {
        String nombreUni = "Unlam";
        Universidad unlam = new Universidad(nombreUni);
        Materia pb2 = new Materia(1, "PB2");
        unlam.registraMateria(pb2);
        assertFalse(unlam.registraMateria(new Materia(1, "PB2")));
    }
	
	
	
	@Test
	public void queSePuedaInscribirUnAlumnoenMateria() {
		 String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "PB2 ";
        Integer codigo = 1;
        Materia pb2 = new Materia (codigo,nombre);
        unlam.registraMateria(pb2);
     	nombre = "Marta";
     	LocalDate fechaNacimiento= LocalDate.of(2005, 5, 8);
    	String apellido = "perez";
    	Integer dni= 44555; 
        Alumno alumno = new Alumno (dni, fechaNacimiento,apellido, nombre);
    	unlam.registrarAlumno(alumno);
    	assertTrue (unlam.inscribirAlumnoAUnaMateria(dni,codigo)) ;
    	       
	}
	
	@Test
	public void queSePuedaCrearUnCicloLectivo() {
		Integer id = 002;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo= LocalDate.of(2008, 5, 8) ;
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		
		CicloElectivo cicloElect = new CicloElectivo (id,fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		assertEquals(fechaInicioCicloLectivo,cicloElect.getFechaInicioCicloLectivo());
    	
    	       
	}
	
	
	@Test
	public void queSePuedaCrearUnCurso() {
		Integer idCurso = 002;
		Integer codigo = 004;
		String nombre = "pb2";
		String turno = "mañana";
		Materia materia = new Materia(codigo, nombre);
		Integer id = 002;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo= LocalDate.of(2008, 5, 8) ;
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo cicloElect = new CicloElectivo (id,fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision comision1 = new Comision (idCurso,materia,  cicloElect, turno);
		assertEquals(idCurso,comision1.getId());
    	
    	       
	}
	
	
	
	
	
	
	
	
	
	
	

	

}
