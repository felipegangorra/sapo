package model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pessoa {

	private String cpf;
	private String nome;
	private Set<String> habilidades;
	private List<String> comentarios;
	
	public Pessoa(String cpf, String nome, Set<String> habilidades, List<String> comentarios) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
		this.comentarios = comentarios;		
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<String> habilidades) {
		this.habilidades = habilidades;
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
