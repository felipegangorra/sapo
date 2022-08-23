package sapo.atividades;

import sapo.pessoa.Pessoa;
import sapo.tarefas.Tarefa;

import java.util.HashMap;

public class AtividadesService {

    private HashMap<String, Pessoa> pessoas;
    private AtividadesRepository atividadesRepository;
    int count = 0;

    public AtividadesService(){

        this.atividadesRepository = new AtividadesRepository();
    }

    public String cadastrarAtividade(String nome , String descricao, String cpf){

        Atividade atividade = new Atividade(nome, descricao, cpf, geraIdAtividade(nome));
        this.atividadesRepository.salvaAtividade(atividade);
        return atividade.getId();
    }
    public void encerrarAtividade(String id){
        if (atividadesRepository.getAtividade(id).getTarefas().size() == 0){
            atividadesRepository.getAtividade(id).setEstado("ENCERRADO");
        }else{
            throw new IllegalArgumentException("Ainda existe tarefas pendentes");
        }
    }
    public void desativarAtividade(String id){
        if (atividadesRepository.getAtividade(id).getTarefas().size() == 0){
            atividadesRepository.getAtividade(id).setEstado("DESATIVADO");
        }else{
            throw new IllegalArgumentException("Ainda existe tarefas pendentes");
        }
    }
    public void reabrirAtividade(String id){
        if (atividadesRepository.getAtividade(id).getTarefas().size() == 0){
            atividadesRepository.getAtividade(id).setEstado("ATIVO");
        }else{
            throw new IllegalArgumentException("Ainda existe tarefas pendentes");
        }
    }
    public String exibirAtividade(String id){
        return atividadesRepository.getAtividade(id).getId() +": " +atividadesRepository.getAtividade(id).getNomeAtividade()+
                "\nResponsável: " + pessoas.get(atividadesRepository.getAtividade(id).getCpf()).getNome() + " - "
                + atividadesRepository.getAtividade(id).getCpf() +
                "\n === \n"
                + atividadesRepository.getAtividade(id).getDescricao() + "\n === \n" + "Tarefas: "
                + atividadesRepository.getAtividade(id).getTarefas().size() + "/20\n" +
                atividadesRepository.getAtividade(id).tarefasFormatoExibicao();
    }
    public void alterarDescricaoAtividade(String id, String descricao){
        atividadesRepository.getAtividade(id).setDescricao(descricao);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        atividadesRepository.getAtividade(id).setCpf(cpf);
    }

    public String geraIdAtividade(String nome){
        String[] nomeFilter = nome.toUpperCase().replaceAll("[AEIOU]", " ").split(" ");
        count++;
        return nomeFilter[0] + nomeFilter[1] + nomeFilter[2] + "-" + (count - 1);
    }

    public void cadastraTarefa(Tarefa tarefa) {
        atividadesRepository.getAtividade(tarefa.getAtividadeId()).addTarefa(tarefa);
    }

    public HashMap<String, Atividade> getAllAtividades() {
        return atividadesRepository.getAllAtividades();
    }

    public Atividade getAtividade(String id){
        return atividadesRepository.getAtividade(id);
    }

    public void setPessoas(HashMap<String, Pessoa> allPessoas) {
        this.pessoas = allPessoas;
    }
}
