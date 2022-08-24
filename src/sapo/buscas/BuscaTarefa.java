package sapo.buscas;

public class BuscaTarefa implements Busca{

    public BuscaTarefa(){}

    public String[] busca(String consulta) {
        return new String[0];
    }

    @Override
    public Busca getBusca() {
        return null;
    }

    public String[] buscaEspecifica(String idAtividade, String nome){
        // em atv especifica
        return null;
    }
}