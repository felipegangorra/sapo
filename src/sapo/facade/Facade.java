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

    /**
     * Cadastra Atividade
     *
     * @param nome
     * @param descricao
     * @param cpf
     * @return AtividadeId
     */
    public String cadastrarAtividade(String nome , String descricao, String cpf){
        return atividadesController.cadastrarAtividade(nome,descricao,cpf);
    }

    /**
     * Cadastra Tarefa
     *
     * @param atividadeId
     * @param nome
     * @param habilidades
     * @return
     */
    public String cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
        String tarefaID = tarefasController.cadastraTarefas(atividadeId,nome,habilidades);
        atividadesController.cadastraTarefaNaAtividade(tarefasController.getTarefa(tarefaID));

        return tarefaID;
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

    /**
     * Exbibe pessoa no formato
     * Nome - cpf
     * Comentários:
     * - coment  1
     * - coment 2
     *
     * @param cpf
     * @return
     */
    public String exibirPessoa(String cpf){
        return pessoaController.exibirPessoa(cpf);
    }

    /**
     * Altera nome da pessoa
     *
     * @param cpf
     * @param nome
     */
    public void alterarNomePessoa(String cpf, String nome){
        pessoaController.alterarNomePessoa(cpf, nome);
    }

    /**
     * Remove pessoa, se cpf não cadastrado joga Exception
     *
     * @param cpf
     */
    public void removerPessoa(String cpf){
        pessoaController.removerPessoa(cpf);
    }

    /**
     * Adiciona comentarios a uma pessoa
     *
     * @param cpf
     * @param comentario
     * @param autorCpf
     */
    public void adicionarComentarioPessoaa(String cpf, String comentario, String autorCpf){
        pessoaController.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    /**
     * Lista Comentários no formato
     * - coment 1
     * - coment 2
     *
     * @param cpf
     * @return lista de comentarios
     */
    public String listarComentariosPessoa(String cpf){
        return pessoaController.listarComentariosPessoa(cpf);
    }
    /**
     * Remove atividade, caso tenha tarefas pedentes joga Exption
     *
     * @param id
     */
    public void encerrarAtividade(String id){
        atividadesController.encerrarAtividade(id);
    }

    /**
     * Desativa atividade, caso tenha tarefas pedentes joga Exption
     *
     * @param id
     */
    public void desativarAtividade(String id){
        atividadesController.desativarAtividade(id);
    }

    /**
     * Reabre atividade
     *
     * @param id
     */
    public void reabrirAtividade(String id){
        atividadesController.reabrirAtividade(id);
    }

    /**
     * Retorna Atividades Controller do Facade
     *
     * @return
     */
    public AtividadesController getAtividadesController(){
        return this.atividadesController;
    }

    /**
     * Passa hashmap de cpf, pessoas p/ atividades
     */
    private void acessoPessoasAtividades(){
        atividadesController.setPessoas(pessoaController.getPessoasRepo().getAllPessoas());
    }

    /**
     * Retorna uma exbição textual da Atividade
     *
     * @param id
     * @return
     */
    public String exibirAtividade(String id){
        acessoPessoasAtividades();
        return atividadesController.exibirAtividade(id);
    }

    /**
     * Altera Descricao da Atividade
     *
     * @param id
     * @param descricao
     */
    public void alterarDescricaoAtividade(String id, String descricao){
        atividadesController.alterarDescricaoAtividade(id, descricao);
    }

    /**
     * Altera o reponsavel pela atividade pelo cpf
     *
     * @param id
     * @param descricao
     */
    public void alterarResponsavelAtividade(String id, String descricao){
        atividadesController.alterarResponsavelAtividade(id, descricao);
    }

    /**
     * Alterar Nome Tarefa
     *
     * @param idTarefa
     * @param novoNome
     */
    public void alterarNomeTarefa(String idTarefa, String novoNome){
        tarefasController.alterarNomeTarefas(idTarefa, novoNome);
    }

    /**
     * Retorna o tareffasController
     *
     * @return
     */
    public TarefasController getTarefasController(){
        return this.tarefasController;
    }

    /**
     * Altera Habilidade Tarefas
     *
     * @param idTarefa
     * @param habilidades
     */
    public void alterarHabilidadesTarefas(String idTarefa, String[] habilidades){
        tarefasController.alterarHabilidadeTarefas(idTarefa, habilidades);
    }

    /**
     * Adiciona Horas a tarefa
     *
     * @param idTarefa
     * @param horas
     */
    public void adicionarHorasTarefas(String idTarefa, int horas){
        tarefasController.adicionarHorasTarefas(idTarefa, horas);
    }

    /**
     * Remove horas da tareda
     *
     * @param idTarefa
     * @param horas
     */
    public void removeHorasTarefas(String idTarefa, int horas) {
        tarefasController.removeHorasTarefas(idTarefa, horas);
    }

    /**
     * Conclui, se tarefas pendentes joga Exeption
     * @param idTarefa
     */
    public void concluirTarefa(String idTarefa) {
        tarefasController.concluirTarefas(idTarefa);
    }

    /**
     * Remove, se Id inexistente joga exception
     *
     * @param idTarefa
     */
    public void removerTarefa(String idTarefa){
        tarefasController.removerTarefas(idTarefa);
    }

    /**
     * Associa pessoa a tarefa
     * @param cpf
     * @param idTarefa
     */
    public void associarPessoaTarefa(String cpf, String idTarefa) {
        tarefasController.associarPessoaTarefas(cpf,idTarefa);
    }

    /**
     * Remove determinada pessoa associada
     * @param cpf
     * @param idTarefa
     */
    public void removePessoaAssociadaTarefa(String cpf, String idTarefa) {
        tarefasController.removerPessoaTarefas(cpf, idTarefa);
    }

    /**
     * Da acesso de atividades p tarefas
     */
    private void acessoAtividadesTarefas(){
        tarefasController.setAtividades(atividadesController.getAllAtividades());
    }

    private void acessoPessoasTarefas(){
        tarefasController.setPessoas(pessoaController.getPessoasRepo().getAllPessoas());
    }

    /**
     *
     * @param idTarefa
     * @return
     */
    public String exibirTarefa(String idTarefa) {
        acessoAtividadesTarefas();
        acessoPessoasTarefas();
        return tarefasController.exibirTarefas(idTarefa);
    }
}
