package sapo.atividades;

public class AtividadesController {

    private AtividadesService atividadesService;

    public AtividadesController(AtividadesService ats){

        this.atividadesService = ats;
    }
    public String cadastrarAtividade(String nome , String descricao, String cpf){
        return atividadesService.cadastrarAtividade(nome,descricao,cpf);
    }
    public void encerrarAtividade(String id){
        atividadesService.encerrarAtividade(id);
    }
    public void desativarAtividade(String id){
        atividadesService.desativarAtividade(id);
    }
    public void reabrirAtividade(String id){
        atividadesService.reabrirAtividade(id);
    }
    public String exibirAtividade(String id){
        return atividadesService.exibirAtividade(id);
    }
    public void alterarDescricaoAtividade(String id, String cpf){
        atividadesService.alterarDescricaoAtividade(id, cpf);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        atividadesService.alterarResponsavelAtividade(id, cpf);
    }
}
