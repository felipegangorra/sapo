package sapo.buscas;

import java.util.ArrayList;

public class BuscaRepo {

    private ArrayList<Busca> historicoBusca = new ArrayList<Busca>();

    public BuscaRepo(){
        this.historicoBusca = new ArrayList<>();
    }

    public void salvaBusca(Busca busca){
        historicoBusca.add(busca);
    }

    public String[] getHistoricoBusca(){
        //this.historicoBusca.toArray();
        return null;
    }
}
