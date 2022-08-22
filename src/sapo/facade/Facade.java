package sapo.facade;
import sapo.atividades.*;
import sapo.buscas.BuscaController;
import sapo.buscas.BuscaService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.tarefas.*;

public class Facade {
    private BuscaController buscaController;
    private TarefasController tarefasController;
    private AtividadesController atividadesController;
    private PessoaController pessoaController;
    public Facade(){
        var pessoaService = new PessoaService();
        var atividadesService = new AtividadesService();
        var tarefasService = new TarefasService();
        var buscaService = new BuscaService();

        this.pessoaController = new PessoaController(pessoaService);
        this.atividadesController = new AtividadesController(atividadesService);
        this.tarefasController = new TarefasController(tarefasService);
        this.buscaController = new BuscaController(buscaService);
    }

    public void cadastraPessoa(String cpf, String nome, String[] habilidades){
        pessoaController.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String cadastrarAtividade(String nome , String descricao, String cpf){
        return atividadesController.cadastrarAtividade(nome,descricao,cpf);
    }

    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        String tarefaID = tarefasController.cadastraTarefas(atividadeId,nome,habilidades);
        atividadesController.cadastraTarefaNaAtividade(tarefasController.getTarefa(tarefaID));

        return tarefaID;
    }

    public String exibirAtividades(String atividadeId){
        return atividadesController.exibirAtividade(atividadeId);
    }

    public String[] exibirPessoas(String consulta){
        buscaController.setPessoas(pessoaController.getPessoasRepo().getAllPessoas());
        return buscaController.exibirPessoas(consulta);
    }

    public String[] busca(String consulta){
        buscaController.setPessoas(pessoaController.getPessoasRepo().getAllPessoas());
        return buscaController.exibirPessoas(consulta);
    }

    public String[] buscaAtividade(String consulta){
        buscaController.setAtividades(atividadesController.getAllAtividades());
        return buscaController.buscarAtividade(consulta);
    }
}
