package facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TarefasTest extends BaseTest{
	private String idAtividade;

	@BeforeEach
	void criaAtividade(){
		this.idAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_2, DESCRICAO_2, CPF_3);
	}

	@Test
	void cadastraTarefa(){

		try{
			facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}

	@Test
	void codigoTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		assertEquals(idTarefa,"LBR-0-0", "devem ser iguais");
	}
	@Test
	void alterarNomeTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.alterarNomeTarefa(idTarefa, NOME_TAREFA_1);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getNome(),
				NOME_TAREFA_1, "Devem ser iguais");
	}

	@Test
	void alterarHabilidadesTarefas(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.alterarHabilidadesTarefas(idTarefa, HABILIDADES_3);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getHabilidades(),
				HABILIDADES_3, "Devem ser iguais");
	}

	@Test
	void adicionarHorasTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.adicionarHorasTarefas(idTarefa, HORAS_1);
		facade.adicionarHorasTarefas(idTarefa, HORAS_2);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getHoras(),
				HORAS_1 + HORAS_2, "Devem ser iguais");
	}
	@Test
	void removeHorasTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.adicionarHorasTarefas(idTarefa, 10);
		facade.removeHorasTarefas(idTarefa,4);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getHoras(),
				6, "Devem ser iguais");
	}

	@Test
	void concluirTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.concluirTarefa(idTarefa);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getEstado(), true,
				"True p concluido");
	}

	@Test
	void removerTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
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
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.associarPessoaTarefa(CPF_3, idTarefa);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getPessoasAssociadas()[0], CPF_3,
				"devem ser iguais");
	}

	@Test
	void removePessoaTarefa(){
		String idTarefa = facade.cadastraTarefa(idAtividade, NOME_TAREFA_2, HABILIDADES_1);
		facade.associarPessoaTarefa(CPF_3, idTarefa);
		facade.associarPessoaTarefa(CPF_2, idTarefa);
		facade.removePessoaAssociadaTarefa(CPF_3, idTarefa);
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getPessoasAssociadas()[0], CPF_2,
				"devem ser iguais");
		assertEquals(facade.getTarefasController().getTarefa(idTarefa).getPessoasAssociadas().length, 1,
				"devem ser iguais");
	}


}
