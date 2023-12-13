package ar.com.educacionit.bootcamp;

import java.time.LocalDate;
import java.util.Objects;

public class EntidadB {

	private String id;
	private String atributeD;
	private LocalDate atributeE;
	private Long atributeF;
	
	public EntidadB(String id, String atributeD, LocalDate atributeE, Long atributeF) {
		
		this.id = id;
		this.atributeD = atributeD;
		this.atributeE = atributeE;
		this.atributeF = atributeF;
	}

	public EntidadB(String atributeD, LocalDate atributeE, Long atributeF) {
		
		this.atributeD = atributeD;
		this.atributeE = atributeE;
		this.atributeF = atributeF;
	}

	public String getId() {
		return id;
	}

	public String getAtributeD() {
		return atributeD;
	}

	public LocalDate getAtributeE() {
		return atributeE;
	}

	public Long getAtributeF() {
		return atributeF;
	}

	public void setAtributeD(String atributeD) {
		this.atributeD = atributeD;
	}

	public void setAtributeE(LocalDate atributeE) {
		this.atributeE = atributeE;
	}

	public void setAtributeF(Long atributeF) {
		this.atributeF = atributeF;
	}

	@Override
	public String toString() {
		return "EntidadB [id=" + id + ", atributeD=" + atributeD + ", atributeE=" + atributeE + ", atributeF="
				+ atributeF + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadB other = (EntidadB) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
