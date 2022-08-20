package sapo.buscas;

public class BuscaController {

    private BuscaService buscaService;

    public BuscaController(BuscaService buscaService){

        this.buscaService = buscaService;
    }

    public String[] exibirPessoas(String consulta){
       return buscaService.exibirPessoas(consulta);
    }

    public String[] buscarAtividade(String consulta){
        return buscaService.buscarAtividade(consulta);
    }

    public String[] buscarTarefas(String nome){
        return buscaService.buscarTarefas(nome);
    }
    public String[] buscarTarefas(String idAtividade, String nome){
        return buscaService.buscarTarefas(idAtividade, nome);
    }

    public String[] sugerirTarefas(Cpf id){
        return buscaService.sugerirTarefas(Cpf id);
    }

    public String[] buscasMaisRecentes(int nBuscas){
        return buscaService.buscasMaisRecentes(nBuscas);
    }

    public String[] exibirHistoricoBusca(int indexBusca){
        return buscaService.exibirHistoricoBusca(indexBusca);
    }
}
