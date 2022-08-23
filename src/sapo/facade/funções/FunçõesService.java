package sapo.facade.funções;

public class FunçõesService {

    private FunçõesRepository funcaoRepository;

    public FunçõesService(){
        this.funcaoRepository = new FunçõesRepository();
    }
    public void cadastrarAluno(String cpf, String nome, String matricula, int periodo, String[] habilidades) {
    }

    public void cadastraProfessor(String cpf, String nome, String siape, String[] diciplinas, String[] habilidades) {
    }

    public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {
    }

    public void definirFuncaoAluno(String cpf, String matricula, int periodo) {
    }

    public void removeFuncao(String cpf) {
    }

    public int pegarNivel(String cpf) {
		return 0;
    }

    public String[] listarPessoas() {
		return null;
    }
}
