package sapo.atividades;

import java.util.HashMap;

public class AtividadesRepository {

    HashMap<Atividades,String> atividades = new HashMap<>();

    AtividadesRepository(){}

    public void adiciona (Atividades at){
        // add atividade
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
