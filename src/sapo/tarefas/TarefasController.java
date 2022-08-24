package sapo.tarefas;

import sapo.atividades.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;

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

	public void removeHorasTarefas(String idTarefa, int horas) {
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

	public Tarefa getTarefa(String idTarefa){
		return ts.getTarefa(idTarefa);
	}

	public void removerPessoaTarefas(String cpf, String idTarefa) {
		ts.removerPessoaTarefas(cpf, idTarefa);
	}

	public void setAtividades(HashMap<String, Atividade> allAtividades) {
		ts.setAtividades(allAtividades);
	}

	public void setPessoas(HashMap<String, Pessoa> allPessoas) {
		ts.setPessoas(allPessoas);
	}
}