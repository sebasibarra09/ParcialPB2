package ar.unlam.intraconsulta;

import static org.junit.Assert.*;
import java.time.LocalDate;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		String nombre = "PB2 ";
		Integer codigo = 1;
		Materia pb2 = new Materia(codigo, nombre);
		assertTrue(unlam.agregarMateria(pb2));
	}

	@Test
	public void queNoSePuedaRegistrarDosMateriaConMismoIDAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Materia pb2 = new Materia(1, "PB2");
		unlam.agregarMateria(pb2);
		assertFalse(unlam.agregarMateria(new Materia(1, "PB2")));
	}

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		Integer dni = 44555;
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Boolean registroExitoso = unlam.agregarAlumno(alumno);
		assertTrue(registroExitoso);
	}

	@Test
	public void queNoSePuedaRegistrarUnAlumnoConMismoDni() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		Integer dni = 44555;
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		assertFalse(unlam.agregarAlumno(new Alumno(44555, LocalDate.of(2005, 5, 8), "Fernandez", "Gonzalo")));
	}

	@Test
	public void queSePuedaAgregarUnCicloElectivo() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer id = 002;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2008, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		assertTrue(unlam.agregarCicloLectivo(ciclo1));
	}

	@Test
	public void queNoSePuedaAgregarUnCicloElectivoConMismoId() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer id = 002;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2006, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(ciclo1);

		Integer id2 = 002;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2007, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2008, 5, 8);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo2 = new CicloElectivo(id2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);
		assertFalse(unlam.agregarCicloLectivo(ciclo2));
	}

	@Test
	public void queNoSePuedaAgregarUnCicloElectivoConSuperposicionDeFecha() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer id = 005;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		unlam.agregarCicloLectivo(ciclo1);

		Integer id2 = 002;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2007, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2008, 5, 8);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo2 = new CicloElectivo(id2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);
		assertFalse(unlam.agregarCicloLectivo(ciclo2));
	}

	@Test
	public void queSePuedaAgregarUnaComision() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1;
		Integer dni = 12;
		String turno = "noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		String apellido = "Checchia";

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		Nota nota = new Nota(5, 8, 7, 5);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);
		assertTrue(unlam.agregarComision(comi1));
	}

	@Test
	public void queNoSePuedaAgregarUnaComisionPorDatosRepetidos() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		Integer idComi = 004;
		Integer id = 50;
		Integer codigo = 10;
		Integer dni = 120;
		String turno = "noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		String apellido = "Checchia";
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);

		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		Nota nota = new Nota(5, 8, 7, 5);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);

		Integer idComi2 = 004;
		Integer id2 = 50;
		Integer codigo2 = 10;
		Integer dni2 = 120;
		String turno2 = "noche";
		LocalDate fechaNacimiento2 = LocalDate.of(2005, 5, 8);
		String apellido2 = "Checchia";
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2015, 5, 8);

		CicloElectivo ciclo2 = new CicloElectivo(id2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);
		Alumno alumno2 = new Alumno(dni2, fechaNacimiento2, apellido2, nombre);
		Profesor profesor2 = new Profesor(codigo2, apellido, nombre);
		Materia materia2 = new Materia(codigo2, nombre);
		Nota nota2 = new Nota(5, 8, 7, 5);
		Comision comi2 = new Comision(idComi2, alumno2, profesor2, materia2, ciclo2, nota2, turno2);

		unlam.agregarComision(comi1);
		assertFalse(unlam.agregarComision(comi2));
	}
	
	@Test
	public void queSePuedaRegistrarUnProfesorAUnaUniversidad() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Profesor profe = new Profesor(dni,apellido, nombre);
		assertTrue(unlam.agregarDocentes(profe));
	}

	@Test
	public void queNoSePuedaRegistrarUnProfesorConMismoDni() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Profesor profe = new Profesor(dni,apellido, nombre);
		unlam.agregarDocentes(profe);
		assertFalse(unlam.agregarDocentes(new Profesor(44555,"Fernandez", "Gonzalo")));
	}

	@Test
	public void queSePuedaInscribirUnAlumnoenMateria() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB2 ";
		Integer codigo = 1;
		Materia pb2 = new Materia(codigo, nombre);
		unlam.agregarMateria(pb2);
		nombre = "Marta";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		String apellido = "perez";
		Integer dni = 44555;
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		assertTrue(unlam.inscribirAlumnoAUnaMateria(dni, codigo));

	}

	@Test
	public void queSePuedaCrearUnCicloLectivo() {
		Integer id = 002;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2008, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);

		CicloElectivo cicloElect = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		assertEquals(fechaInicioCicloLectivo, cicloElect.getFechaInicioCicloLectivo());

	}
	
	@Test
	public void queSePuedaRegistrarUnProfesorAUnaComision() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1;
		String turno = "noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		Nota nota = new Nota(5, 8, 7, 5);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni,apellido, nombre);
		unlam.agregarDocentes(profe);
		assertTrue(unlam.asignarDocentesAComision(profe, comi1));
	}
	
	@Test
	public void queNoSePuedaRegistrarUnProfesorAUnaMismaComision() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1;
		String turno = "noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		Nota nota = new Nota(5, 8, 7, 5);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni,apellido, nombre);
		Profesor profe2 = new Profesor(44555, "Riquelme", "Roman");
		unlam.agregarDocentes(profe);
		unlam.asignarDocentesAComision(profe, comi1);
		assertFalse(unlam.asignarDocentesAComision(profe2, comi1));
		
	}
	
	@Test
	public void queSePuedaAgregarUnaCorrelativa() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		String nombre = "PB2 ";
		Integer codigo = 1;
		String nombre2 = "PB3 ";
		Integer codigo2 = 2;
		Materia pb2 = new Materia(codigo, nombre);
		Materia pb3 = new Materia (codigo2, nombre2);
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb3);
		Correlatividad correlativa = new Correlatividad (pb2,pb3);
		assertTrue(unlam.agregarCorrelatividad(pb2.getCodigo(), pb3.getCodigo()));
	}
	
	@Test
	public void queNoSePuedaRegistrarUnaNotaQueNoEsteEntre1y10() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1;
		String turno = "noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		Nota nota = new Nota(0, 11, 5, 10);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni,apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		assertFalse(unlam.registrarNota(comi1.getId(), alumno.getDni(), nota));
	}
	
	@Test
	public void queSePuedaEliminarUnaCorrelativa() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		String nombre = "PB2 ";
		Integer codigo = 1;
		String nombre2 = "PB3 ";
		Integer codigo2 = 2;
		Materia pb2 = new Materia(codigo, nombre);
		Materia pb3 = new Materia (codigo2, nombre2);
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb3);
		Correlatividad correlativa = new Correlatividad (pb2,pb3);
		assertTrue(unlam.agregarCorrelatividad(pb2.getCodigo(), pb3.getCodigo()));
		assertFalse(unlam.quitarCorrelatividad(pb2.getCodigo(), pb3.getCodigo()));
	}
	
	@Test
	public void queNoSePuedaRegistrarUnaNotaMayorA7SiNoAproboLaCorrelativa() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1 ;
		String turno = "noche" ;
		
	
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia (1006, "PB2");
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 7);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia2, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni,apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		assertFalse(unlam.registrarNota(comi1.getId(), alumno.getDni(), nota));
	}
	
	@Test
	public void queSePuedaRegistrarUnaNotaSiElAlumnoAproboLaCorrelativa() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1 ;
		String turno = "noche" ;
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia (1006, "PB2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia2, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		assertTrue(unlam.registrarNota(comi1.getId(), alumno.getDni(), nota));
	}
	
	@Test
	public void queNoSePuedaAprobarElFinalSiNoEstanAprobadosLosParciales() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1;
		String turno = "noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		Nota nota = new Nota(3, 3, 4, 10);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni,apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		assertFalse(unlam.registrarNota(comi1.getId(), alumno.getDni(), nota));
	}
	
	@Test
	public void queSePuedaObtenerLasMateriasAprobadasParaUnAlumno() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1 ;
		String turno = "noche" ;
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia (1006, "PB2");
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia2, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni,apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		Boolean esperado =alumno.getMateriasAprobadas().equals(unlam.obtenerMateriasAprobadasParaUnAlumno(alumno.getDni()));
		assertTrue(esperado);
	}
	
	@Test
    public void queSePuedanObtenerLasNotasDeUnAlumno() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1 ;
		String turno = "noche" ;
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(1005, "PB1");
		Nota nota = new Nota(10, 10, 10, 9);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		unlam.agregarDocentes(profesor);
		unlam.agregarAlumno(alumno);
        unlam.registrarNota(comi1.getId(), alumno.getDni(), nota);
        assertEquals(nota.getNotaFinal(),unlam.obtenerNota(alumno.getDni(),materia.getCodigo()));
    }
	
	@Test
	public void queUnAlumnoNSePuedaInscribirPorqueEstaEnDeFecha() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1 ;
		String turno = "noche" ;
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2020, 05, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2024, 05, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia (1006, "PB2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, alumno, profesor, materia2, ciclo1, nota, turno);
		unlam.agregarComision(comi1);
		assertTrue(unlam.inscribirAlumnoAComision(alumno.getDni(), comi1.getId()));
	}
	

	
	

}
