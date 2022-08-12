package sapo.atividades;

public class AtividadesController {

    private AtividadesService ats;

    public AtividadesController(AtividadesService ats){

        this.ats = ats;
    }
    public String cadastrarAtividade(String nome , String descricao, String cpf){
        ats.cadastrarAtividade(nome,descricao,cpf);
        return null;
    }
    public void adicionaAtividade(Atividades at){
        ats.adicionaAtividade(at);
    }
    public void encerrarAtividade(String id){
        ats.encerrarAtividade(id);
    }
    public void desativarAtividade(String id){
        ats.desativarAtividade(id);
    }
    public void reabrirAtividade(String id){
        ats.reabrirAtividade(id);
    }
    public String exibirAtividade(String id){
        ats.exibirAtividade(id);
        return null;
    }
    public void alterarDescricaoAtividade(String id, String cpf){
        ats.alterarDescricaoAtividade(id, cpf);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        ats.alterarResponsavelAtividade(id, cpf);
    }

}
