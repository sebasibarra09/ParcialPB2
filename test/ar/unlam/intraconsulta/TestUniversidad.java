package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		String nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555666;
		LocalDate fechaNacimiento = LocalDate.of(1996, 5, 8);
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaNacimiento);
		Boolean registroExitoso = unlam.registrar(alumno);
		assertTrue(registroExitoso);

	}
	
	@Test
	public void queNoSePuedaRegistrarDosAlumnosConMismoDNIAUnaUniversidad() {
		String nombreUni = "Unlam";
		Universidad unlam = new Universidad(nombreUni);
		Alumno alumno = new Alumno(44555666, "Perez", "Marta", LocalDate.of(1996, 5, 8));
		Alumno alumno2 = new Alumno(44555666, "Tevez", "Carlos", LocalDate.of(1990, 4, 3));
		unlam.registrar(alumno);
		assertFalse(unlam.registrar(alumno2));

	}

	/*
	 * @Test public void
	 * queNoSePuedaRegistrarUnAlumnoCuandoElAlumnoYaEsteRegistradoAUnaUniversidad()
	 * { String nombre = "Unlam"; Universidad unlam = new Universidad (nombre);
	 * nombre = "Marta"; String apellido = "perez"; Integer dni= 44555; Alumno
	 * alumno = new Alumno (dni,apellido, nombre); Alumno alumno2 = new Alumno
	 * (dni,"jose", "Lopez"); unlam.registrar(alumno); Boolean registroExitoso =
	 * unlam.registrar(alumno2); assertFalse(registroExitoso);
	 * 
	 * 
	 * }
	 */
	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB2 ";
		Integer codigo = 1;
		Materia pb2 = new Materia(codigo, nombre);
		assertTrue(unlam.registraMateria(pb2));

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
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "PB2 ";
		Integer codigo = 1;
		Materia pb2 = new Materia(codigo, nombre);
		unlam.registraMateria(pb2);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaNacimiento);
		unlam.registrar(alumno);
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
	public void queSePuedaCrearUnCurso() {
		Integer idCurso = 002;
		Integer codigo = 004;
		String nombre = "pb2";
		String turno = "mañana";
		Materia materia = new Materia(codigo, nombre);
		Integer id = 002;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2008, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2010, 5, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2015, 5, 8);
		CicloElectivo cicloElect = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Comision comision1 = new Comision(idCurso, materia, cicloElect, turno);
		assertEquals(idCurso, comision1.getId());

	}

}
