package Sapo.TarefasGerencias;

import java.util.HashMap;

public class TarefasGerenciaisRepository {

    private HashMap<String, TarefaGerenciais> tarefasGerencais;

    public TarefasGerenciaisRepository(){
        this.tarefasGerencais = new HashMap<>();
    }

    public void salvaTarefaGerencial(TarefaGerenciais tarefaGerenciais){
        this.tarefasGerencais.put(tarefaGerenciais.getIdTarefa(), tarefaGerenciais);
    }

    public TarefaGerenciais getTarefaGerencial(String id) {
        return tarefasGerencais.get(id);
    }

    public void deletaTarefa(String id) {
        if (tarefasGerencais.containsKey(id)) {
            tarefasGerencais.remove(id);
        }else{
            throw new IllegalArgumentException("Id não existe");
        }
    }
}
