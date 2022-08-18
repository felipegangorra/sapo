package sapo.Buscas;

import sapo.pessoa.Pessoa;

//A busca deve retornar uma lista de pessoas, em ordem alfabética do nome
//em que a chave de busca esteja contida no CPF, no nome da pessoa, ou que sejam uma das habilidades
// Assim a busca por “Matheus Java” pode retornar a pessoa Matheus Gaudencio do Rêgo,
//caso ela tenha a habilidade Java. A busca por “Ensino Java” por sua vez pode retornar Lívia,
//Matheus e Reinaldo, desde que os 3 tenham as habilidades “Ensino” e “Java”.
public class BuscaPessoa implements Busca{

    private String consulta;
    private Pessoa[] pessoas;

    public BuscaPessoa(){

    }

    // vai comparar tal string ao msm tempo em em CPF, nome e habilidade

    public String[] busca(String consulta){
        this.consulta = consulta;
        // implementar busca
        // this pessoas
    }

    @Override
    public Busca getBusca() {
        return null;
    }

    // classe p ordenar em alfabetico
}
