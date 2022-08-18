package sapo.Buscas;

public class BuscaTarefa implements Busca{

    public BuscaTarefa(){}

    @Override
    public String[] busca(String consulta) {
        return new String[0];
    }

    public String[] buscaEspecifica(String idAtividade, String nome){
        // em atv especifica
    }
}
