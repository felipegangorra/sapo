package sapo.tarefas;

public class Tarefa {
	
	private String atividadeId;
	private String nome;
	private String[] habilidades;

	public Tarefa(String atividadeId, String nome, String[] habilidades) {
		this.atividadeId = atividadeId;
		this.nome = nome;
		this.habilidades = habilidades;
	}
	
	public void cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		return;
	}
}