package sapo.tarefas;

public class Tarefa {
	
	private String atividadeId;
	private String nome;
	private String[] habilidades;
	private int horas;	//horas da tarefa
	private String idTarefas;	//id da tarefa
	private boolean estado; //se tá concluida

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
}