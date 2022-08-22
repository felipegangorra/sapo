package sapo.tarefas;

public class TarefasService {

    private TarefaRepository tarefasRepository;
    private int count = 0;

    public TarefasService(){
        this.tarefasRepository = new TarefaRepository();
    }

    public String geraTarefaId(String atividadeId, String nome){
        count++;
        return atividadeId + "-" + (count - 1);
    }

    public String cadastraTarefas(String atividadeId, String nome, String[] habilidades) {
        Tarefa tarefa = new Tarefa(atividadeId, nome, habilidades, geraTarefaId(atividadeId, nome));
        tarefasRepository.salvaTarefa(tarefa);
        return tarefa.getIdTarefa();
    }

    public void alterarNomeTarefas(String idTarefa, String novoNome) {
        tarefasRepository.getTarefa(idTarefa).setNome(novoNome);
    }

    public void alterarHabilidadeTarefas(String idTarefa, String[] habilidades) {
        tarefasRepository.getTarefa(idTarefa).setHabilidades(habilidades);
    }

    public void adicionarHorasTarefas(String idTarefa, int horas) {
        tarefasRepository.getTarefa(idTarefa).setHoras(horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        tarefasRepository.getTarefa(idTarefa).setHoras(horas);
        // vai diminuir ou ja da a nova hora
        // precisa de logica a mais???
        // preciso remover da ordem??
    }

    public void concluirTarefas(String idTarefa) {
        tarefasRepository.getTarefa(idTarefa).setEstado(true);
    }

    public void removerTarefas(String idTarefa) {
        tarefasRepository.deletaTarefa(idTarefa);
    }

    public String exibirTarefas(String idTarefa) {
        return tarefasRepository.getTarefa(idTarefa).toString();
        // Fazer de acordo com especificação
    }
    public void associarPessoaTarefas(String cpf, String idTarefa) {
        tarefasRepository.getTarefa(idTarefa).addPessoaAssociada(cpf);
    }

    public void removerPessoaTarefas(String cpf, String idTarefa) {
        tarefasRepository.getTarefa(idTarefa).removePessoaAssociada(cpf);
    }

    public Tarefa getTarefa(String idTarefa) {
        return tarefasRepository.getTarefa(idTarefa);
    }
}