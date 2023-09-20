package ar.unlam.intraconsulta;

public class Nota {

	private Integer NotaParcial1;
	private Integer NotaParcial2;
	private Integer NotaRecu1;
	private Integer NotaRecu2;
	private Integer NotaFinal;

	public Nota(Integer notaParcial1, Integer notaParcial2, Integer notaRecu1, Integer notaRecu2, Integer notaFinal) {
		NotaParcial1 = notaParcial1;
		NotaParcial2 = notaParcial2;
		NotaRecu1 = notaRecu1;
		NotaRecu2 = notaRecu2;
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

	public Integer getNotaRecu1() {
		return NotaRecu1;
	}

	public void setNotaRecu1(Integer notaRecu1) {
		NotaRecu1 = notaRecu1;
	}

	public Integer getNotaRecu2() {
		return NotaRecu2;
	}

	public void setNotaRecu2(Integer notaRecu2) {
		NotaRecu2 = notaRecu2;
	}

	public Integer getNotaFinal() {
		return NotaFinal;
	}

	public void setNotaFinal(Integer notaFinal) {
		NotaFinal = notaFinal;
	}
}
