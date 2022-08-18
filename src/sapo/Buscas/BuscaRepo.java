package sapo.Buscas;


//+ exibirPessoas(consulta: str): str[]
//
//        + buscarAtividade(consulta: str): str[]
//
//        + buscarTarefas(nome: str): str[]
//
//        + buscarTarefas(idAtividade: str, nome: str): str[]
//
//        + sugerirTarefas(id: cpf): str[]
//
//        + buscasMaisRecentes(nBuscas: int): str[]
//
//        + exibirHistóricoBusca(indexBusca: int): str[]
import java.util.ArrayList;

public class BuscaRepo {

    private ArrayList<Busca> historicoBusca = new ArrayList<Busca>();

    public BuscaRepo(){}

    public String[] exibirHistóricoBusca(int indexBusca){
        // o usuário deve retornar por padrão um array onde a primeira linha indica o tipo de
        // busca feita (PESSOA, ATIVIDADE, TAREFA ou SUGESTÃO), e os demais elementos
        // no array representam os elementos encontrados na busca.
        return null;
    }
    // dentro vem a busca pessoa
    public String[] exibirPessoas(){
        return null;
    }

    public String[] buscarAtividade(){ return null;}

    public String[] buscarTarefa(){ return null;}

    public String[] sugerirTarefa(){ return null;}
}
