package sapo.atividades;

public class AtividadesService {

    private AtividadesRepository atr;

    public AtividadesService(){

        this.atr = new AtividadesRepository();
    }

    public void cadastrarAtividade(String nome , String descricao, String cpf){
        atr.cadastraAtividade(nome,descricao,cpf);
    }
    public void adicionaAtividade(Atividades at){
        atr.adiciona(at);
    }
    public void encerrarAtividade(String id){
        atr.encerrar(id);
    }
    public void desativarAtividade(String id){
        atr.desativar(id);
    }
    public void reabrirAtividade(String id){
        atr.reabrir(id);
    }
    public String exibirAtividade(String id){
        return atr.exibir(id);
    }
    public void alterarDescricaoAtividade(String id, String cpf){
        atr.alterarDescriçao(id, cpf);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        atr.alterarResposavel(id, cpf);
    }
}
