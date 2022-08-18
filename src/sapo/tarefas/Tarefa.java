package sapo.tarefas;

import java.util.ArrayList;

public class Tarefa {
	
	private String atividadeId; // id da atividdade associada
	private String nome;
	private String[] habilidades;
	private int horas;	//horas da tarefa
	private String idTarefa;	//id da tarefa
	private boolean estado = false; // true se concluido

	private ArrayList<String> pessoasAssociadas = new ArrayList<>();

	public Tarefa(String atividadeId, String nome, String[] habilidades, String idTarefa) {
		this.atividadeId = atividadeId;
		this.nome = nome;
		this.habilidades = habilidades;
		this.idTarefa = idTarefa;
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

	public void setIdTarefa(String idTarefa){this.idTarefa = idTarefa;}
	public String getIdTarefa(){return this.idTarefa;}

	public void setEstado(boolean estado){this.estado = estado;}

	public boolean getEstado(){return  this.estado;}

	public void addPessoaAssociada(String cpf){pessoasAssociadas.add(cpf);}
	
	public void removePessoaAssociada(String cpf){pessoasAssociadas.remove(cpf);}
}