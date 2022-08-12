package sapo.tarefas;

public class TarefasController {

<<<<<<< HEAD
	private TarefasService ts;
	
	public TarefasController(TarefasService ts) {
		this.ts = ts;
	}
	
	
	public void cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		this.ts.cadastraTarefa(atividadeId, nome, habilidades);
	}
	
	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.ts.alterarNomeTarefa(idTarefa, novoNome);
	}
	
	public void alterarHabilidadeTarefas(String idTarefa, String[] habilidades) {
		this.ts.alterarHabilidadeTarefa(idTarefa, habilidades);
	}
	
	public void adicionarHorasTarefa(String idTarefa, int horas) {
		this.ts.adicionarHorasTarefa(idTarefa, horas);
	}
	
	public void removerHorasTarefa(String idTarefa, int horas) {
		this.ts.removeHorasTarefa(idTarefa, horas);
	}
	
	public void concluirTarefa(String idTarefa) {
		this.ts.concluirTarefa(idTarefa);
	}
	
	public void removerTarefa(String idTarefa) {
		this.ts.removerTarefa(idTarefa);
	}
	
	public void associarPessoaTarefa(String cpf, String idTarefa) {
		this.ts.associarPessoaTarefa(cpf, idTarefa);
	}
	
	public void removerPessoaTarefa(String cpf, String idTarefa) {
		this.ts.removerPessoaTarefa(cpf, idTarefa);
	}
	
	public String exibirTarefa(String idTarefa) {
		return this.ts.exibirTarefa(idTarefa);
	}
	
=======
	
	
	public String cadastraTarefas(String atividadeId, String nome, String[] habilidades) {
		return null;
	}
	
	public void alterarNomeTarefas(String idTarefa, String novoNome) {
		return;
	}
	
	public void alterarHabilidadeTarefas(String idTarefa, String[] habilidades) {
		return;
	}
	
	public void adicionarHorasTarefas(String idTarefa, int horas) {
		return;
	}
	
	public void removerTarefas(String idTarefa, int horas) {
		return;
	}
	
	public void concluirTarefas(String idTarefa) {
		return;
	}
	
	public void removerTarefas(String idTarefa) {
		return;
	}
	
	public String exibirTarefas(String idTarefa) {
		return null;
	}
	
	public void associarPessoaTarefas(String cpf, String idTarefa) {
		return;
	}
	
	public void removerPessoaTarefas(String cpf, String idTarefa) {
		return;
	}
	
	
>>>>>>> 9af110a4aab5fb32a0d64dabfbacb408a3be9522
}
