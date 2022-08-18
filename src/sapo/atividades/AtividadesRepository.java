package sapo.atividades;

import java.util.HashMap;

public class AtividadesRepository {

    HashMap<String, Atividade> atividades = new HashMap<>();

    public AtividadesRepository(){
        this.atividades = new HashMap<>();
    }

    public void salvaAtividade(Atividade atividades){
        this.atividades.put(atividades.getId(), atividades); // gera id no service
    }

    public Atividade getAtividade(String id) {
        return atividades.get(id);
    }

    public void deletaPessoa(String id) {
        if (atividades.containsKey(id)) {
            atividades.remove(id);
        }else{
            throw new IllegalArgumentException("Id não existe");
        }
    }
}
