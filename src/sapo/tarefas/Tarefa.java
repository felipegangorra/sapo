package sapo.tarefas;

import java.util.Arrays;

public class Tarefa {
	
	private String atividadeId;
	
	private String nome;
	
	private String[] habilidades;
	
	private int horas;	//horas da tarefa

	public Tarefa(String atividadeId, String nome, String[] habilidades, int horas) {
		this.atividadeId = atividadeId;
		this.nome = nome;
		this.habilidades = habilidades;
		this.horas = horas;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String[] getHabilidades() {
		return this.habilidades;
	}
	
	public void setHabilidades(String[] habilidades) {
		this.habilidades = habilidades;
	}
	
	public String toString() {
		return null;
	}
	
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atividadeId == null) ? 0 : atividadeId.hashCode());
		result = prime * result + Arrays.hashCode(habilidades);
		result = prime * result + horas;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (atividadeId == null) {
			if (other.atividadeId != null)
				return false;
		} else if (!atividadeId.equals(other.atividadeId))
			return false;
		if (!Arrays.equals(habilidades, other.habilidades))
			return false;
		if (horas != other.horas)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}