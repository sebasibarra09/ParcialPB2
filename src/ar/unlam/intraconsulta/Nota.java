package ar.unlam.intraconsulta;

public class Nota {

	private Integer Id;
	private Integer Nota1;
	private Integer Nota2;
	private Integer NotaFinal;

	public Nota(Integer id, Integer nota1, Integer nota2, Integer notaFinal) {
		Id = id;
		Nota1 = nota1;
		Nota2 = nota2;
		NotaFinal = notaFinal;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getNota1() {
		return Nota1;
	}

	public void setNota1(Integer nota1) {
		Nota1 = nota1;
	}

	public Integer getNota2() {
		return Nota2;
	}

	public void setNota2(Integer nota2) {
		Nota2 = nota2;
	}

	public Integer getNotaFinal() {
		return NotaFinal;
	}

	public void setNotaFinal(Integer notaFinal) {
		NotaFinal = notaFinal;
	}

}
