package sapo.tarefas;

import sapo.atividades.AtividadesRepository;
import sapo.atividades.AtividadesService;
//import sapo.pessoa.PessoaRepo;
//import sapo.pessoa.PessoaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TarefasRepository {

    private HashMap<String, Tarefa> tarefas = new HashMap<>();
    private ArrayList<Tarefa> ordem = new ArrayList<>();

    private int count = 0;
    //private PessoaRepo pr;
    private AtividadesRepository ar;

    public TarefasRepository() {

    }

    public String cadastraTarefas(String atividadeId, String nome, String[] habilidades) {
        Tarefa t = new Tarefa(atividadeId,nome,habilidades);
        String id = geraTarefaID(atividadeId, nome);
        t.setIdTarefas(id);
        ordem.add(t);
        tarefas.put(id, t);
        return id;
    }

    /**
     * Gera id de Tarefas, só deve ser chamado 1 ver por criação de tarefa.
     *
     * @param atividadeId
     * @param nome
     * @return o id da Tareda em String
     */
    private String geraTarefaID(String atividadeId, String nome){
        String idTarefa = atividadeId + "-" + count;
        count++;
        return idTarefa;
    }
    public void alterarNomeTarefas(String idTarefa, String novoNome) {
        tarefas.get(idTarefa).setNome(novoNome);
    }

    public void alterarHabilidadeTarefas(String idTarefa, String[] habilidades) {
        tarefas.get(idTarefa).setHabilidades(habilidades);
    }

    public void adicionarHorasTarefas(String idTarefa, int horas) {
        tarefas.get(idTarefa).setHoras(horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        tarefas.get(idTarefa).setHoras(horas); // vai diminuir ou ja da a nova hora
        // precisa de logica a mais???
        // preciso remover da ordem??
    }

    public void concluirTarefas(String idTarefa) {
        tarefas.get(idTarefa).setEstado(true);
    }

    public void removerTarefas(String idTarefa) {
        tarefas.remove(idTarefa);
    }

    public String exibirTarefas(String idTarefa) {
        // fazer exibir
        return null;
    }

    public void associarPessoaTarefas(String cpf, String idTarefa) {
        tarefas.get(idTarefa).addPessoaAssociada(cpf);
    }

    public void removerPessoaTarefas(String cpf, String idTarefa) {
        tarefas.get(idTarefa).removePessoaAssociada(cpf);
    }

    public HashMap<String, Tarefa> getAllTarefas() {
        return this.tarefas;
    }
}