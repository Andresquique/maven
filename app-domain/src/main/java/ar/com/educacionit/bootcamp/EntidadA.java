package ar.com.educacionit.bootcamp;

import java.time.LocalDate;
import java.util.Objects;

public class EntidadA {

	private String id;
	private String atributeA;
	private LocalDate atributeB;
	private Long atributeC;
	
	public EntidadA(String id, String atributeA, LocalDate atributeB, Long atributeC) {
		
		this.id = id;
		this.atributeA = atributeA;
		this.atributeB = atributeB;
		this.atributeC = atributeC;
	}

	public EntidadA(String atributeA, LocalDate atributeB, Long atributeC) {
		
		this.atributeA = atributeA;
		this.atributeB = atributeB;
		this.atributeC = atributeC;
	}

	public String getId() {
		return id;
	}

	public String getAtributeA() {
		return atributeA;
	}

	public LocalDate getAtributeB() {
		return atributeB;
	}

	public Long getAtributeC() {
		return atributeC;
	}

	public void setAtributeA(String atributeA) {
		this.atributeA = atributeA;
	}

	public void setAtributeB(LocalDate atributeB) {
		this.atributeB = atributeB;
	}

	public void setAtributeC(Long atributeC) {
		this.atributeC = atributeC;
	}

	@Override
	public String toString() {
		return "EntidadA [id=" + id + ", atributeA=" + atributeA + ", atributeB=" + atributeB + ", atributeC="
				+ atributeC + "]";
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
		EntidadA other = (EntidadA) obj;
		return Objects.equals(id, other.id);
	}
	
	 
	
}
