package sapo.atividades;

import sapo.pessoa.Pessoa;
import sapo.tarefas.Tarefa;
import sapo.tarefas.TarefasRepository;

import java.util.HashMap;

public class AtividadesController {

    private AtividadesService ats;

    public AtividadesController(AtividadesService ats){

        this.ats = ats;
    }
    public String cadastrarAtividade(String nome , String descricao, String cpf){
        ats.cadastrarAtividade(nome,descricao,cpf);
        return null;
    }
    public void adicionaAtividade(Atividades at){
        ats.adicionaAtividade(at);
    }
    public void encerrarAtividade(String id){
        ats.encerrarAtividade(id);
    }
    public void desativarAtividade(String id){
        ats.desativarAtividade(id);
    }
    public void reabrirAtividade(String id){
        ats.reabrirAtividade(id);
    }
    public String exibirAtividade(String id){
        ats.exibirAtividade(id);
        return null;
    }
    public void alterarDescricaoAtividade(String id, String cpf){
        ats.alterarDescricaoAtividade(id, cpf);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        ats.alterarResponsavelAtividade(id, cpf);
    }
    public HashMap<String, Tarefa> getTarefas(TarefasRepository tr){
        return ats.getTarefas(tr); // wont works
    }

    public void setPessoas(HashMap<String, Pessoa> pessoas){
        ats.setPessoas(pessoas);
    }
}
