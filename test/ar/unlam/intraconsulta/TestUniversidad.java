package ar.unlam.intraconsulta;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
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
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);

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
		Comision comi2 = new Comision(idComi2, materia2, ciclo2, turno2);

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
		Profesor profe = new Profesor(dni, apellido, nombre);
		assertTrue(unlam.agregarDocentes(profe));
	}

	@Test
	public void queNoSePuedaRegistrarUnProfesorConMismoDni() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "perez";
		Integer dni = 44555;
		Profesor profe = new Profesor(dni, apellido, nombre);
		unlam.agregarDocentes(profe);
		assertFalse(unlam.agregarDocentes(new Profesor(44555, "Fernandez", "Gonzalo")));
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

		//Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		//Nota nota = new Nota(5, 8, 7, 5);
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni, apellido, nombre);
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

		//Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		Materia materia = new Materia(codigo, nombre);
		//Nota nota = new Nota(5, 8, 7, 5);
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni, apellido, nombre);
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
		Materia pb3 = new Materia(codigo2, nombre2);
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb3);
		Correlatividad correlativa = new Correlatividad(pb2, pb3);
		assertTrue(unlam.agregarCorrelatividad(pb2.getCodigo(), pb3.getCodigo()));
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
		Materia pb3 = new Materia(codigo2, nombre2);
		unlam.agregarMateria(pb2);
		unlam.agregarMateria(pb3);
		Correlatividad correlativa = new Correlatividad(pb2, pb3);
		unlam.agregarCorrelatividad(pb2.getCodigo(), pb3.getCodigo());
		assertTrue(unlam.quitarCorrelatividad(correlativa));
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
		Integer cantidadDeAlumnos = 50;

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
		Aula aula = new Aula(id, cantidadDeAlumnos, 15);
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni, apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		assertFalse(unlam.registrarNota(comi1.getId(), alumno.getDni(), nota));
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
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(5, 5, 5, 8);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
		unlam.agregarComision(comi1);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		unlam.agregarComision(comi1);
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
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
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
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni, apellido, nombre);
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
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		unlam.agregarMateria(materia);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni, apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		unlam.registrarNota(idComi, alumno.getDni(), nota);
		Boolean esperado = alumno.getMateriasAprobadas()
				.equals(unlam.obtenerMateriasAprobadasParaUnAlumno(alumno.getDni()));
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
		Materia materia = new Materia(1005, "PB1");
		unlam.agregarMateria(materia);
		alumno.agregarMateria(materia);
		Nota nota = new Nota(10, 10, 10, 9);
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		unlam.agregarComision(comi1);
		unlam.agregarAlumno(alumno);
		unlam.registrarNota(idComi, alumno.getDni(), nota);
		// System.out.println(nota.getNotaFinal());
		// System.out.println(alumno.getNotasMaterias());
		assertEquals(nota.getNotaFinal(), unlam.obtenerNota(alumno.getDni(), materia.getCodigo()));
	}

	@Test
	public void queSePuedaObtenerLasMateriasFaltantesParaUnAlumno() {
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
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		Materia materia3 = new Materia(1007, "BDD");
		Materia materia4 = new Materia(1008, "PW1");
		// Materia materia5 = new Materia (1009, "PW2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		unlam.agregarMateria(materia3);
		unlam.agregarMateria(materia4);
		// unlam.agregarMateria(materia5);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		unlam.agregarComision(comi1);
		Profesor profe = new Profesor(dni, apellido, nombre);
		unlam.agregarDocentes(profe);
		unlam.agregarAlumno(alumno);
		ArrayList<Materia> materiasFaltantes = unlam.obtenerMateriasFaltantesParaUnAlumno(alumno.getDni());
		int valorEsperado = 3;
		assertEquals(valorEsperado, materiasFaltantes.size());
	}

	@Test
	public void queSePuedaAgregarUnAula() {
		Integer id = 15;
		Integer cantidadDeAlumnos = 50;
		Aula aula = new Aula(id, cantidadDeAlumnos, 15);
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		assertTrue(unlam.agregarAula(aula));
	}

	@Test
	public void queSePuedaBuscarUnAula() {
		Integer id = 15;
		Integer cantidadDeAlumnos = 50;
		Aula aula = new Aula(id, cantidadDeAlumnos, 15);
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		unlam.agregarAula(aula);
		assertEquals(aula, unlam.buscarAulaPorId(15));
	}

	@Test
	public void queUnAlumnoNoSePuedaInscribirPorqueEstaFueraDeFecha() {
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
		LocalDate fechaInicioInscripcion = LocalDate.of(2020, 05, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2024, 05, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
		unlam.agregarComision(comi1);
		Aula aula = new Aula(15, 50);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(comi1.getId(), aula.getId());
		assertTrue(unlam.inscribirAlumnoAComision(alumno.getDni(), comi1.getId()));
	}

	@Test
	public void queSePuedaAsignarUnAula() {
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
		LocalDate fechaInicioInscripcion = LocalDate.of(2020, 05, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2024, 05, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		//Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		//unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		//alumno.agregarMateria(materia);
		//unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		//Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
		unlam.agregarComision(comi1);
		Aula aula = new Aula(15, 50);
		unlam.agregarAula(aula);
		assertTrue(unlam.asignarAulaAlaComision(comi1.getId(), aula.getId()));
	}

	@Test
	public void queUnAlumnoNoSePuedaAnotarPorqueElAulaEstaLlena() {
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
		LocalDate fechaInicioInscripcion = LocalDate.of(2020, 05, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2024, 05, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		alumno.agregarMateria(materia);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
		unlam.agregarComision(comi1);
		Aula aula = new Aula(15, 0);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(idComi, aula.getId());
		assertFalse(unlam.inscribirAlumnoAComision(alumno.getDni(), comi1.getId()));
	}

	@Test
	public void queUnAlumnoNoSePuedaAnotarPorqueYaAproboEsaMateria() {
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
		LocalDate fechaInicioInscripcion = LocalDate.of(2020, 05, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2024, 05, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		unlam.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		unlam.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		Materia materia2 = new Materia(1006, "PB2");
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materia2);
		alumno.agregarMateria(materia);
		alumno.agregarMateria(materia2);
		unlam.agregarCorrelatividad(materia.getCodigo(), materia2.getCodigo());
		Nota nota = new Nota(10, 10, 10, 10);
		Comision comi1 = new Comision(idComi, materia2, ciclo1, turno);
		unlam.agregarComision(comi1);
		Aula aula = new Aula(15, 15);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(idComi, aula.getId());
		assertFalse(unlam.inscribirAlumnoAComision(alumno.getDni(), comi1.getId()));
	}

	@Test
	public void queSePuedaCalcularUnPromedio() {
		String nombre = "UNLaM";
		Universidad UNLaM = new Universidad(nombre);
		nombre = "Marta";
		String apellido = "Perez";
		Integer dni = 44555666;
		Integer idComi = 003;
		Integer id = 5;
		Integer codigo = 1;
		String turno = "Noche";
		LocalDate fechaNacimiento = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2004, 5, 8);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2005, 5, 8);
		LocalDate fechaInicioInscripcion = LocalDate.of(2020, 05, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2024, 05, 8);
		CicloElectivo ciclo1 = new CicloElectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(dni, fechaNacimiento, apellido, nombre);
		UNLaM.agregarAlumno(alumno);
		Profesor profesor = new Profesor(codigo, apellido, nombre);
		UNLaM.agregarDocentes(profesor);
		Materia materia = new Materia(1005, "PB1");
		UNLaM.agregarMateria(materia);
		Materia materia2 = new Materia(1006, "PB2");
		UNLaM.agregarMateria(materia2);
		Materia materia3 = new Materia(1007, "BDD");
		UNLaM.agregarMateria(materia3);
		Materia materia4 = new Materia(1008, "PW1");
		UNLaM.agregarMateria(materia4);
		alumno.agregarMateria(materia);
		alumno.agregarMateria(materia2);
		alumno.agregarMateria(materia3);
		alumno.agregarMateria(materia4);
		Nota nota = new Nota(10, 10, 10, 10);
		Nota nota2 = new Nota(10, 5, 10, 10);
		Nota nota3 = new Nota(7, 7, 7, 7);
		Nota nota4 = new Nota(8, 8, 8, 8);
		alumno.agregarNotas(nota.getNotaFinal());
		alumno.agregarNotas(nota2.getNotaFinal());
		alumno.agregarNotas(nota3.getNotaFinal());
		alumno.agregarNotas(nota4.getNotaFinal());
		Comision comi1 = new Comision(idComi, materia, ciclo1, turno);
		Comision comi2 = new Comision(idComi, materia2, ciclo1, turno);
		Comision comi3 = new Comision(idComi, materia3, ciclo1, turno);
		Comision comi4 = new Comision(idComi, materia4, ciclo1, turno);
		UNLaM.agregarComision(comi1);
		UNLaM.agregarComision(comi2);
		UNLaM.agregarComision(comi3);
		UNLaM.agregarComision(comi4);
		Double valorEsperado = 8.75;

		assertEquals(valorEsperado, UNLaM.calcularPromedio(alumno), 0.01);

	}

}
