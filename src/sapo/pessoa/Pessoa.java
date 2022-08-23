package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pessoa {

	private String cpf;
	private String nome;
	private String[] habilidades;
	private List<Comentario> comentarios;

	public Pessoa(String cpf, String nome, String[] habilidades) {
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
		this.comentarios = new ArrayList<>();
	}
	public Pessoa(String cpf, String nome, String[] habilidades, List<Comentario> comentarios) {
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

	public String[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String[] habilidades) {
		this.habilidades = habilidades;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public String getComentariosString(){
		String retorno = new String();
		for (Comentario a : comentarios){
			retorno += "- " + a.getTexto() + "\n";
		}
		return retorno;

	}

	public void setComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}

	@Override
	public String toString() {
		return "Pessoa cpf=" + cpf + ", nome=" + nome + ", habilidades=" + Arrays.toString(habilidades)
				+ ", comentarios=" + comentarios ;
	}
	
}
