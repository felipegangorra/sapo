package sapo.buscas;

public class BuscaAtividade implements Busca{
    private String consulta;

    public BuscaAtividade() {
    }

    public String[] busca(String consulta) {
        this.consulta = consulta;
        // impplementar busca
    }

}
