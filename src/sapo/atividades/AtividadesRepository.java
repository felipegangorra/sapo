package sapo.atividades;

import java.util.HashMap;

public class AtividadesRepository {

    HashMap<Atividades,String> atividades = new HashMap<>();
    Integer count;

    AtividadesRepository(){}

    public String cadastraAtividade(String nome , String descricao, String cpf){

        // filtrar 3 primeira iniciaiss
        adiciona(new Atividades(nome, descricao, cpf));
        return null; // vou arrumar
    }
//    private String geraId(String nome){
////        for(int i = 0; i < nome.split(" ").length;i++){
////            if(nome[i].equals("a"));
////        }
//        count++; // Gera o id
//        return null;
//    }
    public void adiciona (Atividades at){
        //atividades.add(at, at.getId());
        // how to add somethin on a hash map
    }

    public void encerrar (String id){
        //  encerrar atividade
    }

    public void desativar(String id){
        //  desativar atividade
    }
    public void reabrir(String id){
        //  reabrir atividade
    }
    public String exibir(String id){
       // exibir
        return null;
    }

    public void alterarDescriçao(String id, String descriçao){
        //
    }

    public void alterarResposavel(String id, String cpf){
        //
    }
}
