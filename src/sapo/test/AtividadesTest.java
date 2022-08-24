package sapo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AtividadesTest extends BaseTest{

	@BeforeEach
	void cadastraPessoa(){
		facade.cadastraPessoa(BaseTest.CPF_1, BaseTest.NOME_1, BaseTest.HABILIDADES_1);
	}
	@Test
	void cadastrarAtividade(){
		try{
			facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}
	@Test
	void codigoAtividade(){
		String id = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		assertEquals(id,"PRJT-0", "devem ser iguais");
	}
	@Test
	void encerrarAtividade(){
		String IdAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		try{
			facade.encerrarAtividade(IdAtividade);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}

	// criar caso q da fail pq tem tarefa dentro
	@Test
	void desativarAtividade(){
		String idAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		try{
			facade.desativarAtividade(idAtividade);
		}catch (Exception e){
			fail("Deveria ter funcionado");
		}
	}
	@Test
	void reabrirAtividade(){
		String idAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		facade.desativarAtividade(idAtividade);
		facade.reabrirAtividade(idAtividade);
		Assertions.assertEquals(facade.getAtividadesController().getAtividade(idAtividade).getEstado(),
				"ATIVO", "Verifica se ativou a atividade");
	}

	// testar quando com tarefa tiver funcionando
	@Test
	void exibirAtividade(){
		String idAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		System.out.println(facade.exibirAtividade(idAtividade));
		Assertions.assertEquals(facade.exibirAtividade(idAtividade),
				"PRJT-0: projeto inove\nResponsável: Leticia Farias - 08907070372\n === \n" +
						"Atividade p promover ino  no campus\n === \nTarefas: 0/20\n",
				"comparando Exbição Ativades");
	}

	@Test
	void alterarDescricaoAtividade(){
		String idAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		facade.alterarDescricaoAtividade(idAtividade, BaseTest.DESCRICAO_2);
		Assertions.assertEquals(facade.getAtividadesController().getAtividade(idAtividade).getDescricao(),
				BaseTest.DESCRICAO_2, "Descrição devem ser iguais");
	}

	@Test
	void alteraResponsavelAtividade(){
		String idAtividade = facade.cadastrarAtividade(BaseTest.NOME_ATIVIDADE_1,BaseTest.DESCRICAO_1,BaseTest.CPF_1);
		facade.alterarResponsavelAtividade(idAtividade, BaseTest.CPF_2);
		Assertions.assertEquals(facade.getAtividadesController().getAtividade(idAtividade).getCpf(),
				BaseTest.CPF_2,"Cpf devem ser iguais");
	}


}
