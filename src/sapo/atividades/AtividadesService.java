package sapo.atividades;

public class AtividadesService {

    private AtividadesRepository atividadesRepository;
    int count = 0;

    public AtividadesService(){

        this.atividadesRepository = new AtividadesRepository();
    }

    public String cadastrarAtividade(String nome , String descricao, String cpf){

        Atividade atividade = new Atividade(nome, descricao, cpf, geraIdAtividade(nome));
        this.atividadesRepository.salvaAtividade(atividade);
        return atividade.getId();
    }
    public void encerrarAtividade(String id){
        if (atividadesRepository.getAtividade(id).getTarefas().size() == 0){
            atividadesRepository.getAtividade(id).setEstado("ENCERRADO");
        }else{
            throw new IllegalArgumentException("Ainda existe tarefas pendentes");
        }
    }
    public void desativarAtividade(String id){
        if (atividadesRepository.getAtividade(id).getTarefas().size() == 0){
            atividadesRepository.getAtividade(id).setEstado("DESATIVADO");
        }else{
            throw new IllegalArgumentException("Ainda existe tarefas pendentes");
        }
    }
    public void reabrirAtividade(String id){
        if (atividadesRepository.getAtividade(id).getTarefas().size() == 0){
            atividadesRepository.getAtividade(id).setEstado("ATIVO");
        }else{
            throw new IllegalArgumentException("Ainda existe tarefas pendentes");
        }
    }
    public String exibirAtividade(String id){
        return atividadesRepository.getAtividade(id).toString();
        // formatar o to string preciso de cpf
    }
    public void alterarDescricaoAtividade(String id, String descricao){
        atividadesRepository.getAtividade(id).setDescricao(descricao);
    }
    public void alterarResponsavelAtividade(String id, String cpf){
        atividadesRepository.getAtividade(id).setCpf(cpf);
    }

    public String geraIdAtividade(String nome){
        String[] nomeFilter = nome.toUpperCase().replaceAll("[AEIOU]", " ").split(" ");
        count++;
        return nomeFilter[0] + nomeFilter[1] + nomeFilter[2] + "-" + (count - 1);
    }
}
