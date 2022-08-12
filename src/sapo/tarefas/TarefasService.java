package sapo.tarefas;

public class TarefasService {
<<<<<<< HEAD
	
	private TarefasRepository tr;
	
	public TarefasService() {
		this.tr = new TarefasRepository();
	}

	public void cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		this.tr.cadastrar(atividadeId, nome, habilidades);
	}

	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.tr.alterarNome(idTarefa, novoNome);	
	}

	public void alterarHabilidadeTarefa(String idTarefa, String[] habilidades) {
		this.tr.alterarHabilidade(idTarefa, habilidades);
	}

	public void adicionarHorasTarefa(String idTarefa, int horas) {
		this.tr.adicionarHoras(idTarefa, horas);
	}

	public void removeHorasTarefa(String idTarefa, int horas) {
		this.tr.removeHoras(idTarefa, horas);
	}

	public void concluirTarefa(String idTarefa) {
		this.tr.concluir(idTarefa);
		
	}

	public void removerTarefa(String idTarefa) {
		this.tr.remover(idTarefa);
	}

	public void associarPessoaTarefa(String cpf, String idTarefa) {
		this.tr.associarPessoa(cpf, idTarefa);
	}

	public void removerPessoaTarefa(String cpf, String idTarefa) {
		this.tr.removerPessoa(cpf, idTarefa);
	}

	public String exibirTarefa(String idTarefa) {
		return this.tr.exibir(idTarefa);
	}
=======
>>>>>>> 9af110a4aab5fb32a0d64dabfbacb408a3be9522

}
