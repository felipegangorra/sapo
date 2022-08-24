package sapo.buscas;

import sapo.atividades.Atividade;
import sapo.pessoa.Pessoa;

import java.util.HashMap;

public class BuscaService {

    private BuscaPessoa buscaPessoa;
    private BuscaTarefa buscarTarefa;
    private BuscaRepo buscaRepository;
    private BuscaAtividade buscaAtividade;


    public BuscaService(){
        this.buscaRepository = new BuscaRepo();
        this.buscaAtividade= new BuscaAtividade();
        this.buscarTarefa = new BuscaTarefa();
    }

    public String[] exibirPessoas(String consulta){
        Busca buscaPessoa = new BuscaPessoa(consulta);
        buscaRepository.salvaBusca(buscaPessoa);
        return ((BuscaPessoa) buscaPessoa).busca(consulta);
        // crio um objeto novo p cada busca
        // retorno um clone do estado atual p so ter 4 objetos
    }

    public String[] buscarAtividade(String consulta){
        return  buscaAtividade.busca(consulta);
    }

//    public String[] buscarTarefas(String nome){
//        return buscarTarefa.busca(nome);
//    }
//    public String[] buscarTarefas(String idAtividade, String nome){
//        //buscaRepository.salvaBusca();
//
//        return buscarTarefa.buscaEspecifica(idAtividade, nome);
//    }
//
//    public String[] sugerirTarefas(Cpf id){
//        // nao entendi tal metodo
//        return null;
//    }

    public String[] buscasMaisRecentes(int nBuscas){
        return null;
    }

    public String[] exibirHistoricoBusca(int indexBusca){
        // return buscaRepository.getHistoricoBusca()[indexBusca];
        return null;
    }

    public void setPessoas(HashMap<String, Pessoa> pessoas) {
        buscaPessoa.setPessoas(pessoas);
    }

    public void setAtividades(HashMap<String, Atividade> atividades) {
        buscaAtividade.setAtividades(atividades);
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
        return null;
    }
}