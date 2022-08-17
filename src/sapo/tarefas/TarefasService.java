package sapo.tarefas;

public class TarefasService {

    private TarefasRepository tr;

    public TarefasService(){
        this.tr = new TarefasRepository();
    }
    public String cadastraTarefas(String atividadeId, String nome, String[] habilidades) {

        return tr.cadastraTarefas(atividadeId,nome,habilidades);
    }

    public void alterarNomeTarefas(String idTarefa, String novoNome) {
        tr.alterarNomeTarefas(idTarefa, novoNome);
    }

    public void alterarHabilidadeTarefas(String idTarefa, String[] habilidades) {
        tr.alterarHabilidadeTarefas(idTarefa, habilidades);
    }

    public void adicionarHorasTarefas(String idTarefa, int horas) {
        tr.adicionarHorasTarefas(idTarefa, horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        tr.removerHorasTarefa(idTarefa, horas);
    }

    public void concluirTarefas(String idTarefa) {
        tr.concluirTarefas(idTarefa);
    }

    public void removerTarefas(String idTarefa) {
        tr.removerTarefas(idTarefa);
    }

    public String exibirTarefas(String idTarefa) {
        return tr.exibirTarefas(idTarefa);
    }
    public void associarPessoaTarefas(String cpf, String idTarefa) {
        tr.associarPessoaTarefas(cpf, idTarefa);
    }

    public void removerPessoaTarefas(String cpf, String idTarefa) {
        tr.removerPessoaTarefas(cpf, idTarefa);
    }
}