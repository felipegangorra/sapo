package facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AtividadesTest extends BaseTest{

	@BeforeEach
	void cadastraPessoa(){
		facade.cadastraPessoa(CPF_1, NOME_1, HABILIDADES_1);
	}
	@Test
	void cadastrarAtividade(){
		try{
			facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}

	@Test
	void encerrarAtividade(){
		String IdAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		try{
			facade.encerrarAtividade(IdAtividade);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}

	// criar caso q da fail pq tem tarefa dentro
	@Test
	void desativarAtividade(){
		String idAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		try{
			facade.desativarAtividade(idAtividade);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}
	@Test
	void reabrirAtividade(){
		String idAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		facade.desativarAtividade(idAtividade);
		facade.reabrirAtividade(idAtividade);
		assertEquals(facade.getAtividadesController().getAtividade(idAtividade).getEstado(),
				"ATIVO", "Verifica se ativou a atividade");
	}

	// testar quando com tarefa tiver funcionando
	@Test
	void exibirAtividade(){
		String idAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		System.out.println(facade.exibirAtividade(idAtividade));
		assertEquals(facade.exibirAtividade(idAtividade),
				"PRJT-0: projeto inove\nResponsável: Leticia Farias - 08907070372\n === \n" +
						"Atividade p promover ino  no campus\n === \nTarefas: 0/20\n",
				"comparando Exbição Ativades");
	}
//+ alterarDescricaoAtividade(atividadeId: str, descricao: str): void

	@Test
	void alterarDescricaoAtividade(){
		String idAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		facade.alterarDescricaoAtividade(idAtividade, DESCRICAO_2);
		assertEquals(facade.getAtividadesController().getAtividade(idAtividade).getDescricao(),
				DESCRICAO_2, "Descrição devem ser iguais");
	}

	@Test
	void alteraResponsavelAtividade(){
		String idAtividade = facade.cadastrarAtividade(NOME_ATIVIDADE_1,DESCRICAO_1,CPF_1);
		facade.alterarResponsavelAtividade(idAtividade, CPF_2);
		assertEquals(facade.getAtividadesController().getAtividade(idAtividade).getCpf(),
				CPF_2,"Cpf devem ser iguais");
	}


}
