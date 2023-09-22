package ar.unlam.intraconsulta;

public class Nota {

	private Integer NotaParcial1;
	private Integer NotaParcial2;
	private Integer NotaRecuperatorio;
	private Integer NotaFinalDeCursada;

	public Nota(Integer notaParcial1, Integer notaParcial2, Integer NotaRecuperatorio, Integer NotaFinalDeCursada) {
		NotaParcial1 = notaParcial1;
		NotaParcial2 = notaParcial2;
		NotaRecuperatorio = NotaRecuperatorio;
		NotaFinalDeCursada=NotaFinalDeCursada;
	}
	
	public String CondicionDelEstudiante (Integer NotaParcial1, Integer NotaParcial2, Integer NotaRecuperatorio, Integer NotaFinalDeCursada) {
		int condicion1 = 0;
		int condicion2 = 0;
		switch (NotaParcial1) {
		case 7:
		case 8:
		case 9:
		case 10: condicion1= 1;
		}
		switch (NotaParcial2) {
		case 7:
		case 8:
		case 9:
		case 10: condicion2= 1;
		}
		switch (NotaParcial1) {
		case 1:
		case 2:
		case 3: condicion1= 2;
		}
		switch (NotaParcial2) {
		case 1:
		case 2:
		case 3: condicion2= 2;
		}
		
		
		if (condicion1==1 && condicion2==1) {
			NotaFinalDeCursada= (NotaParcial1*NotaParcial2)/2;
			return "Promocionado";
		}
		if (condicion1==2 && condicion2==2) {
			NotaFinalDeCursada= (NotaParcial1*NotaParcial2)/2;
			return "Desaprobado";
		}
		
		switch (NotaParcial1) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:condicion1= 0;
		}
		switch (NotaParcial2) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:condicion2= 0;
		}
		if (condicion1==0 || condicion2==0) {
			notaParcial1
		}
		return "";
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
