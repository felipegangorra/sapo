package sapo.pessoa;

public class PessoaService {

    private PessoaRepository pr;

    public PessoaService(){
        this.pr = new PessoaRepository();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades){
        Pessoa pessoa = new Pessoa(cpf, nome, habilidades);
        this.pr.salvaPessoa(pessoa);
    }

    /**
     * Retorna uma exibiçao da pessoa
     *
     * @param cpf
     * @return
     */
    public String exibirPessoa(String cpf){
        String retorno = pr.getPessoa(cpf).getNome() + " - " + cpf +
                "\nComentários:\n";
        for(Comentario a: pr.getPessoa(cpf).getComentarios()) {
            retorno += "-" + a.getTexto() + "(" + pr.getPessoa(a.getAutorCpf()).getNome() + ")";
        }
        return retorno;
    }

    public void alterarNomePessoa(String cpf, String novoNome){
        Pessoa pessoa = this.pr.getPessoa(cpf);
        pessoa.setNome(novoNome);
    }

    public void alterarHabilidadePessoa(String cpf, String[] novasHabilidades){
        Pessoa pessoa = this.pr.getPessoa(cpf);
        pessoa.setHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf){
        pr.deletaPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf){
        pr.getPessoa(cpf).setComentario(new Comentario(comentario, autorCpf));
    }

    public String listarComentariosPessoa(String cpf){
        return pr.getPessoa(cpf).getComentariosString();
    }

    public PessoaRepository getPessoasRepo(){return this.pr;}

}