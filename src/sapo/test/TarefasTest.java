package sapo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TarefasTest extends BaseTest{
	private String idAtividade;

	@BeforeEach
	void criaAtividade(){
		this.idAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_2, BaseTest.DESCRICAO_2, BaseTest.CPF_3);
	}

	@Test
	void cadastraTarefa(){

		try{
			facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}

	@Test
	void codigoTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		assertEquals(idTarefa,"LBR-0-0", "devem ser iguais");
	}
	@Test
	void alterarNomeTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.alterarNomeTarefa(idTarefa, BaseTest.NOME_TAREFA_1);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getNome(),
				BaseTest.NOME_TAREFA_1, "Devem ser iguais");
	}

	@Test
	void alterarHabilidadesTarefas(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.alterarHabilidadesTarefas(idTarefa, BaseTest.HABILIDADES_3);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getHabilidades(),
				BaseTest.HABILIDADES_3, "Devem ser iguais");
	}

	@Test
	void adicionarHorasTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.adicionarHorasTarefas(idTarefa, BaseTest.HORAS_1);
		facade.adicionarHorasTarefas(idTarefa, BaseTest.HORAS_2);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getHoras(),
				BaseTest.HORAS_1 + BaseTest.HORAS_2, "Devem ser iguais");
	}
	@Test
	void removeHorasTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.adicionarHorasTarefas(idTarefa, 10);
		facade.removeHorasTarefas(idTarefa,4);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getHoras(),
				6, "Devem ser iguais");
	}

	@Test
	void concluirTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.concluirTarefa(idTarefa);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getEstado(), true,
				"True p concluido");
	}

	@Test
	void removerTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.removerTarefa(idTarefa);

		try{
			facade.getTarefasController().getTarefa(idTarefa);
			fail("Deveria ter jogado Exception");
		}catch (Exception e){
			assertEquals("Id não existe", e.getMessage());
		}
	}
	@Test
	void associarPessoaTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.associarPessoaTarefa(BaseTest.CPF_3, idTarefa);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getPessoasAssociadas()[0], BaseTest.CPF_3,
				"devem ser iguais");
	}

	@Test
	void removePessoaTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, BaseTest.NOME_TAREFA_2, BaseTest.HABILIDADES_1);
		facade.associarPessoaTarefa(BaseTest.CPF_3, idTarefa);
		facade.associarPessoaTarefa(BaseTest.CPF_2, idTarefa);
		facade.removePessoaAssociadaTarefa(BaseTest.CPF_3, idTarefa);
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getPessoasAssociadas()[0], BaseTest.CPF_2,
				"devem ser iguais");
		Assertions.assertEquals(facade.getTarefasController().getTarefa(idTarefa).getPessoasAssociadas().length, 1,
				"devem ser iguais");
	}


}
