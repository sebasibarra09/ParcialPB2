package ar.unlam.intraconsulta;

public class Nota {

	private Integer NotaParcial1;
	private Integer NotaParcial2;
	private Integer NotaRecu;
	private Integer NotaFinal;

	public Nota(Integer notaParcial1, Integer notaParcial2, Integer notaRecu, Integer notaFinal) {
		super();
		NotaParcial1 = notaParcial1;
		NotaParcial2 = notaParcial2;
		NotaRecu = notaRecu;
		NotaFinal = notaFinal;
	}

	public Integer getNotaParcial1() {
		return NotaParcial1;
	}

	public void setNotaParcial1(Integer notaParcial1) {
		NotaParcial1 = notaParcial1;
	}

	public Integer getNotaParcial2() {
		return NotaParcial2;
	}

	public void setNotaParcial2(Integer notaParcial2) {
		NotaParcial2 = notaParcial2;
	}

	public Integer getNotaRecu() {
		return NotaRecu;
	}

	public void setNotaRecu(Integer notaRecu) {
		NotaRecu = notaRecu;
	}

	public Integer getNotaFinal() {
		return NotaFinal;
	}

	public void setNotaFinal(Integer notaFinal) {
		NotaFinal = notaFinal;
	}

}
