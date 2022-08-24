package sapo.buscas;

import sapo.pessoa.Pessoa;

import java.util.*;

//A busca deve retornar uma lista de pessoas, em ordem alfabética do nome
//em que a chave de busca esteja contida no CPF, no nome da pessoa, ou que sejam uma das habilidades
// Assim a busca por “Matheus Java” pode retornar a pessoa Matheus Gaudencio do Rêgo,
//caso ela tenha a habilidade Java. A busca por “Ensino Java” por sua vez pode retornar Lívia,
//Matheus e Reinaldo, desde que os 3 tenham as habilidades “Ensino” e “Java”.
public class BuscaPessoa implements Busca{

    private String consulta;
    private HashMap<String, Pessoa> pessoas;

    public BuscaPessoa(String consulta){
    }
    public void setPessoas(HashMap<String, Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    // vai comparar tal string ao msm tempo em em CPF, nome e habilidade

    public String[] busca(String consulta){
        this.consulta = consulta;
        // implementar busca
        // this pessoas
        String[] objConsulta = consulta.split(" ");
        //“Matheus Java” pode retornar a pessoa Matheus Gaudencio do Rêgo, caso ela tenha a habilidade Java.
        //A busca por “Ensino Java” por sua vez pode retornar Lívia, Matheus e Reinaldo,
        // desde que os 3 tenham as habilidades “Ensino” e “Java”
        //pessoa
        // habilidade
        // todas habIDADES
        ArrayList<Pessoa> retornoHabilidade = new ArrayList<>();
        for(Map.Entry<String, Pessoa> pessoa: pessoas.entrySet()){
            int count = 0;
            for(String palavra: objConsulta){
                for(String habilidade: pessoa.getValue().getHabilidades()){
                    if(palavra.toLowerCase().equals(habilidade.toLowerCase())){
                        count++;
                    }
                }
            }
            if(count == objConsulta.length){
                retornoHabilidade.add(pessoa.getValue());
            }
        }
        // nome habilidade
        ArrayList<Pessoa> retornoNomes = new ArrayList<>();
        for(Map.Entry<String, Pessoa> pessoa: pessoas.entrySet()){
            for(String nome: objConsulta){
                if(nome.toLowerCase().equals(pessoa.getValue().getNome().toLowerCase())){
                    retornoNomes.add(pessoa.getValue());
                }
            }
        }
        ArrayList<Pessoa> nomeEhabilidade =new ArrayList<>();
        //filtrou pessoas com msm nome agr a habilidade
        for(Pessoa p: retornoNomes){
            int count = 0;
            for(String consulta1: objConsulta){
                for(String habilidade: p.getHabilidades()){
                    if(habilidade.toLowerCase().equals(consulta1.toLowerCase())){
                        count++;
                    }
                }
            }
            if(count == objConsulta.length - 1){
                nomeEhabilidade.add(p);
            }
        }
        ArrayList<String> retornar = new ArrayList<>();
        if(nomeEhabilidade.size() != 0){
            for(Pessoa p: nomeEhabilidade){
                retornar.add(p.getNome());
            }
        } else if (retornoHabilidade.size() != 0) {
            for(Pessoa p: retornoHabilidade){
                retornar.add(p.getNome());
            }
        }else {
            throw new IllegalArgumentException("Nada Encontrado");
        }
        Collections.sort(retornar, String.CASE_INSENSITIVE_ORDER); // faz sort alfabetico
        String[] asdjklasjdk = retornar.toArray(new String[retornar.size()]);
        return asdjklasjdk;
    }

    @Override
    public Busca getBusca() {
        return null;
    }



}