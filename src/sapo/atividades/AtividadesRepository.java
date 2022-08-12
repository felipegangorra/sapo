package sapo.atividades;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AtividadesRepository {

    HashMap<String, Atividades> atividades = new HashMap<>();
    Integer count;
    //PessoaRepository ps;

    AtividadesRepository(){}
//    AtividadesRepository(PessoaRepository ps){
//        this.ps = ps;
//    }

    public String cadastraAtividade(String nome , String descricao, String cpf){
        Atividades at = new Atividades(nome, descricao, cpf, geraId(nome))  ;
        adiciona(at);
        return at.getId();
    }
    private String geraId(String nome){
        String[] nomeFilter = nome.toUpperCase().replaceAll("[AEIOU]", " ").split(" ");
        count++;
        return nomeFilter[0] + nomeFilter[1] + nomeFilter[2] + "-" + (count - 1); // -1 pois n te como colocar o c++ dps do retorno
//        Arrays.stream(nome.split(" "))
//                .filter(l -> "AEIOU".indexOf(l) >= 0)
//                .collect(Collectors.toList());

//        Arrays.stream(nome.split(" "))
//                .forEach((v) -> v);

//        for(int i = 0; i < nome.split(" ").length;i++){
//            if(nome[i].equals("a"));
//        }
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
//                ps.getNome(cpf);
                "\n" + "===\n" +
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
}
