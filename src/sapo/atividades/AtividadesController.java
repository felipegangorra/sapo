package sapo.atividades;

import sapo.pessoa.Pessoa;
import sapo.tarefas.Tarefa;

import java.util.HashMap;

public class AtividadesController {

    private AtividadesService atividadesService;

    public AtividadesController(AtividadesService atividadesService){

        this.atividadesService = atividadesService;
    }

    public HashMap<String, Atividade> getAllAtividades() {
        return atividadesService.getAllAtividades();
    }

    public String cadastrarAtividade(String nome , String descricao, String cpf){
        return atividadesService.cadastrarAtividade(nome,descricao,cpf);
    }
    public void encerrarAtividade(String id){
        atividadesService.encerrarAtividade(id);
    }
    public void desativarAtividade(String id){
        atividadesService.desativarAtividade(id);
    }
    public void reabrirAtividade(String id){
        atividadesService.reabrirAtividade(id);
    }
    public String exibirAtividade(String id){
        return atividadesService.exibirAtividade(id);
    }
    public void alterarDescricaoAtividade(String id, String descricao){
        atividadesService.alterarDescricaoAtividade(id, descricao);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        atividadesService.alterarResponsavelAtividade(id, cpf);
    }

    public void cadastraTarefaNaAtividade(Tarefa tarefa) {
        atividadesService.cadastraTarefa(tarefa);
    }

    /**
     * Get atividade do repository pelo id
     *
     * @param id
     * @return Atividade
     */
    public Atividade getAtividade(String id){
        return atividadesService.getAtividade(id);
    }

    /**
     * Concede acesso a pessoas p atividades
     *
     * @param allPessoas
     */
    public void setPessoas(HashMap<String, Pessoa> allPessoas) {
        atividadesService.setPessoas(allPessoas);
    }
}

