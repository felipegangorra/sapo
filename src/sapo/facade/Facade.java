package sapo.facade;
import sapo.atividades.*;
import sapo.tarefas.*;

public class Facade {
    private  TarefasController tarefasController;
    private AtividadesController atividadesController;
    private PessoaController pessoaController;
    public Facade(){
        var pessoaService = new PessoaService();
        var atividadesService = new AtividadesService();
        var tarefasService = new TarefasService();

        this.pessoaController = new PessoaController(pessoaService);
        this.atividadesController = new AtividadesController(atividadesService);
        this.tarefasController = new TarefasController(tarefasService);
    }

    public TarefasController getTarefasController(){return this.tarefasController;}
    public AtividadesController getAtividadesController(){return this.atividadesController;}
    public PessoaController getPessoasController(){return this.pessoaController;}

    public void pessoasAtividades(){
        atividadesController.setPessoas(pessoaController.getPessoas());
    }

    public void pessoasTarefas(){
        atividadesController.setPessoas(pessoaController.getPessoas());
    }

    public void tarefasAtividades(){}

    public void atividadeTaredas(){}
}
