package sapo.tarefasGerencias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sapo.tarefas.Tarefa;

public class TarefaGerenciais extends Tarefa{
    private int horas;
    private ArrayList<String> idTarefas;

    private static String habilidadePadrão = "gestão";

    public TarefaGerenciais(String atividadeId, String nome, String[] habilidades, String[] idTarefas, String idTarefaGerencial){
        super(atividadeId, nome, habilidades, idTarefaGerencial);
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public ArrayList<String> getIdTarefas(){
        return this.idTarefas;
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

    public String[] getHabilidadesGerenciais(){
        List<String> habilidades = Arrays.stream(getHabilidades()).toList();
        habilidades.add("gestão");
        return (String[]) habilidades.toArray();
    }
}
