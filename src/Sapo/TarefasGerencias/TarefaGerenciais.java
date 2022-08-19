package Sapo.TarefasGerencias;

import Sapo.Tarefas.Tarefa;

import java.util.ArrayList;
import java.util.Arrays;

public class TarefaGerenciais extends Tarefa{
    private int horas;
    private ArrayList<String> idTarefas;

    public TarefaGerenciais(String atividadeId, String nome, String[] habilidades, String[] idTarefas, String idTarefaGerencial){
        super(atividadeId, nome, habilidades, idTarefaGerencial);
        this.idTarefas = (ArrayList<String>) Arrays.asList(idTarefas);
    }

    private void contarHoras(){
       // como conseguir as horas das tarefas pelo id, acesso ao repo de tarefas
    }

    public void addTarefa(String idTarefa) {
        idTarefas.add(idTarefa);
    }

    public void removeTarefa(String idTarefa) {
        idTarefas.remove(idTarefa);
    }

    public int contarTodasTarefas() {
        return idTarefas.size();
    }
}
