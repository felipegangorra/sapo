package Funções;

public class FunçõesController {

    private FunçõesService funçõesService;

    public FunçõesController(){
        this.funçõesService = new FunçõesService();
    }

    public void cadastrarAluno(String cpf, String nome, String matricula, int periodo, String[] habilidades){
        funçõesService.cadastrarAluno(cpf, nome, matricula, periodo, habilidades);
    }

    public void cadastrarProfessor(String cpf, String nome, String siape, String[] diciplinas, String[] habilidades){
        funçõesService.cadastraProfessor(cpf, nome, siape, diciplinas, habilidades);
    }

    public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas){
        funçõesService.definirFuncaoProfessor(cpf, siape, disciplinas);
    }

    public void definirFuncaoAluno(String cpf, String matricula, int periodo){
        funçõesService.definirFuncaoAluno(cpf, matricula, periodo);
    }

    public void removerFuncao(String cpf){
        funçõesService.removeFuncao(cpf);
    }

    public int pegarNivel(String cpf){
        return funçõesService.pegarNivel(cpf);
    }

    public String[] listarPessoas(){
        return funçõesService.listarPessoas();
    }
}
