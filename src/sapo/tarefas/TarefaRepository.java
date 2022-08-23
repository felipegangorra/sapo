package sapo.tarefas;

import java.util.HashMap;

public class TarefaRepository {
    private HashMap<String, Tarefa> tarefas = new HashMap<>();

    public TarefaRepository(){
       this.tarefas = new HashMap<>();
    }

    public void salvaTarefa(Tarefa tarefa) {
        this.tarefas.put(tarefa.getIdTarefa(), tarefa);
    }

    public Tarefa getTarefa(String id) {
        if (tarefas.containsKey(id)) {
            return tarefas.get(id);
        }else{
            throw new IllegalArgumentException("Id não existe");
        }

    }

    public void deletaTarefa(String id) {
        if (tarefas.containsKey(id)) {
            tarefas.remove(id);
        }else{
            throw new IllegalArgumentException("Id não existe");
        }
    }
}
