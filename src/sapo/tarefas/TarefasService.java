package sapo.tarefas;

import sapo.atividades.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;

public class TarefasService {

    private HashMap<String, Atividade> atividades;
    private HashMap<String, Pessoa> allPessoas;
    private TarefaRepository tarefasRepository;
    private int count = -1;

    public TarefasService(){
        this.tarefasRepository = new TarefaRepository();
    }

    /**
     * Gera tarefa id com base do nome da atividade
     *
     * @param atividadeId
     * @param nome
     * @return
     */
    public String geraTarefaId(String atividadeId, String nome){
        count++;
        return atividadeId + "-" + count;
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
        tarefasRepository.getTarefa(idTarefa).addHoras(horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        tarefasRepository.getTarefa(idTarefa).minusHoras(horas);

    }

    public void concluirTarefas(String idTarefa) {
        tarefasRepository.getTarefa(idTarefa).setEstado(true);
    }

    public void removerTarefas(String idTarefa) {
        tarefasRepository.deletaTarefa(idTarefa);
    }

    private String nomeCpf(String idTarefa){
        String[] asssociados = tarefasRepository.getTarefa(idTarefa).getPessoasAssociadas();
        String retorno = new String();
        for(String a: asssociados){
            retorno += allPessoas.get(a).getNome() + " - " + allPessoas.get(a).getCpf() + "\n";
        }
        return retorno;
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

    public void setAtividades(HashMap<String, Atividade> allAtividades) {
        this.atividades = allAtividades;
    }

    public void setPessoas(HashMap<String, Pessoa> allPessoas) {
        this.allPessoas = allPessoas;
    }

    public String exibirTarefas(String idTarefa) {
        return tarefasRepository.getTarefa(idTarefa).getNome() + " - " + tarefasRepository.getTarefa(idTarefa).getIdTarefa()
                + "\n" + atividades.get(tarefasRepository.getTarefa(idTarefa).getIdTarefa()).getNomeAtividade() + "\n" +
                tarefasRepository.getTarefa(idTarefa).getHabilidadesString() + "\n" +
                "(" + tarefasRepository.getTarefa(idTarefa).getHoras() + "horas(s) executada(s))\n" +
                "===\n" +
                "Equipe:\n" + nomeCpf(idTarefa);
    }
}