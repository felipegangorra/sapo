package sapo.atividades;

import java.util.HashMap;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaRepo;
import sapo.tarefas.Tarefa;
import sapo.tarefas.TarefasRepository;
import sapo.tarefas.TarefasService;

public class AtividadesRepository {

    HashMap<String, Atividades> atividades = new HashMap<>();
    Integer count;
    private TarefasService ts;
    private PessoaRepo pr;
    private HashMap<String, Pessoa> pessoas;


    AtividadesRepository() {

    }

    public String cadastraAtividade(String nome , String descricao, String cpf){
        Atividades at = new Atividades(nome, descricao, cpf, geraId(nome));
        adiciona(at);
        return at.getId();
    }
    private String geraId(String nome){
        String[] nomeFilter = nome.toUpperCase().replaceAll("[AEIOU]", " ").split(" ");
        count++;
        return nomeFilter[0] + nomeFilter[1] + nomeFilter[2] + "-" + (count - 1); // -1 pois n te como colocar o c++ dps do retorno
        // solucao com stream
    }
    public void adiciona (Atividades at){
        atividades.put(at.getId(), at);
    }

    public void encerrar (String id){
        //  encerrar atividade
        //Só é possível encerrar ou desativar atividades sem tarefas pendentes.
        // validador atv pendente
        // nao pode receber tarefas
        //change estado to encerrado


    }

    public void desativar(String id){
        //  desativar atividade
        //Só é possível encerrar ou desativar atividades sem tarefas pendentes.
        // validador atv pendente
        // nao pode receber tarefas
        //change estado to deativado
    }
    public void reabrir(String id){
        //  reabrir atividade, estado = ATIVO
        //  pode reveber tarefas
    }
    public String exibir(String id){
        return  id +
                ": " +
                atividades.get(id).getNome() +
                pr.getNome(atividades.get(id).getCpf()) + "\n" +
                "===\n" +
                atividades.get(id).getDescricao() +
                "\n" + "===\n" +
                "Tarefas: ";
                //num Tarefas ativas / totak;
                // ultimas 3 taredas;
    }

    public void alterarDescriçao(String id, String descriçao){
        atividades.get(id).setDescricao(descriçao);
    }

    public void alterarResposavel(String id, String cpf){
        atividades.get(id).setCpf(cpf);
    }

    public HashMap<String, Tarefa> getTarefas(TarefasRepository tr){
        return tr.getAllTarefas(); // wont works
    }
//    public HashMap<String, Pessoa> getPessoas(PessoaRepo pr) {
//        retur
//    }

    public void setPessoas(HashMap<String, Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    // verificar tarefas Pendentes
    // num total de tarefas ativas
    // ultimas 3 tarefas

    // cpf cnoseguir o nome

    //
}
