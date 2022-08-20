package Sapo.TarefasGerencias;

public class TarefasGerenciaisController {

    private TarefasGenrenciaisService tarefasGenrenciaisService;

    public TarefasGerenciaisController(TarefasGenrenciaisService tarefasGenrenciaisService){

        this.tarefasGenrenciaisService = tarefasGenrenciaisService;
    }

    public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[]  idTarefas){
        return tarefasGenrenciaisService.cadastrarTarefaGerencial(atividadeId, nome, habilidades, idTarefas);
    }

    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa){
        tarefasGenrenciaisService.adicionarNaTarefaGerencial(idTarefaGerencial, idTarefa);
    }


    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa){
        tarefasGenrenciaisService.removerDaTarefaGerencial(idTarefaGerencial, idTarefa);
    }

    public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial){
        return tarefasGenrenciaisService.contarTodasTarefasNaTarefaGerencial(idTarefaGerencial);
    }
}
