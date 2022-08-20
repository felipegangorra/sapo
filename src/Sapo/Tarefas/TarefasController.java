package Sapo.Tarefas;

public class TarefasController {


	private TarefasService ts;

	public TarefasController(TarefasService ts){
		this.ts = ts;
	}
	public String cadastraTarefas(String atividadeId, String nome, String[] habilidades) {

		return ts.cadastraTarefas(atividadeId,nome,habilidades);
	}

	public void alterarNomeTarefas(String idTarefa, String novoNome) {
		ts.alterarNomeTarefas(idTarefa, novoNome);
	}

	public void alterarHabilidadeTarefas(String idTarefa, String[] habilidades) {
		ts.alterarHabilidadeTarefas(idTarefa, habilidades);
	}

	public void adicionarHorasTarefas(String idTarefa, int horas) {
		ts.adicionarHorasTarefas(idTarefa, horas);
	}

	public void removerHorasTarefa(String idTarefa, int horas) {
		ts.removerHorasTarefa(idTarefa, horas);
	}

	public void concluirTarefas(String idTarefa) {
		ts.concluirTarefas(idTarefa);
	}

	public void removerTarefas(String idTarefa) {
		ts.removerTarefas(idTarefa);
	}

	public String exibirTarefas(String idTarefa) {
		return ts.exibirTarefas(idTarefa);
	}

	public void associarPessoaTarefas(String cpf, String idTarefa) {
		ts.associarPessoaTarefas(cpf, idTarefa);
	}

	public void removerPessoaTarefas(String cpf, String idTarefa) {
		ts.removerPessoaTarefas(cpf, idTarefa);
	}
	
	
}