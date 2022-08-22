package sapo.buscas;

import sapo.atividades.Atividade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BuscaAtividade implements Busca {
    private String consulta;
    private HashMap<String, Atividade> atividades;

    public BuscaAtividade() {
    }

    public void setAtividades(HashMap<String, Atividade> atividades) {
        this.atividades = this.atividades;
    }

    public String[] busca(String consulta) {
        this.consulta = consulta;
        // A busca retorna uma lista de representações com cada atividade, ordenadas pelo ID
        //buscar tais palavras no nome da atividade,
        String[] objConsulta = consulta.split(" ");
        ArrayList<Atividade> retorno = new ArrayList<>();
        // filtrar nomes
        ArrayList<Atividade> retornoNome = new ArrayList<>();
        for (Map.Entry<String, Atividade> atividade : atividades.entrySet()) {
            int count = 0;
            for (String nome : objConsulta) {
                if (nome.toLowerCase().equals(atividade.getValue().getNomeAtividade().toLowerCase())) {
                    count++;
                }
                if (nome.toLowerCase().equals(atividade.getValue().getId().toLowerCase())) {
                    count++;
                }
                boolean contem = false;
                for (String a : atividade.getValue().getDescricao().toLowerCase().split(" ")) {
                    if (nome.toLowerCase().equals(a)) {
                        contem = true;
                    }
                }
                if (contem == true) {
                    count++;
                }
            }
            if (count > 1) {
                retornoNome.add(atividade.getValue());
            }
        }
        Atividade[] arrayOrdem = retornoNome.toArray(new Atividade[0]);
        for (int i = 0; i < arrayOrdem.length - 1; i++){
            for(int o = 0; o < retornoNome.size() - 1 - i; o++){
                if(arrayOrdem[o].getNumero() > arrayOrdem[o + 1].getNumero()){
                    Atividade swap  = arrayOrdem[o];
                    arrayOrdem[o] =  arrayOrdem[o + 1];
                    arrayOrdem[o + 1] = arrayOrdem[o];
                }
            }
        }
        String[] resposta = new String[arrayOrdem.length];
        int a = 0;
        for(Atividade atividade : arrayOrdem){
            resposta[a] = atividade.toString();
            a++;
        }
        return resposta;
    }

    @Override
    public Busca getBusca() {
        return null;
    }

}
