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

    /**
     * Cadastra Pessoa no Sistema
     *
     * @param cpf
     * @param nome
     * @param habilidades
     */
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

    public PessoaController getPessoaController(){return this.pessoaController;}

    public String exibirPessoa(String cpf){
        return pessoaController.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String nome){
        pessoaController.alterarNomePessoa(cpf, nome);
    }
    public void removerPessoa(String cpf){
        pessoaController.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoaa(String cpf, String comentario, String autorCpf){
        pessoaController.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf){
        return pessoaController.listarComentariosPessoa(cpf);
    }
}
