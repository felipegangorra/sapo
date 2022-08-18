package sapo.TarefasGerencias;

import sapo.tarefas.Tarefa;

import java.util.ArrayList;

public class TarefasGerenciais {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private int horas;

    public TarefasGerenciais(){
        this.tarefas = new ArrayList<>();
    }

    private void horas(){
        for(Tarefa t: tarefas){
            this.horas += t.getHoras();
        }
    }
}
