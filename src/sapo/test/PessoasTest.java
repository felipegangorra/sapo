package sapo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PessoasTest extends BaseTest{


	@Test
	void cadastrarPessoa() {
		facade.cadastraPessoa(BaseTest.CPF_1, BaseTest.NOME_1, BaseTest.HABILIDADES_1);
		Assertions.assertEquals(facade.getPessoaController().getPessoasRepo().getPessoa(BaseTest.CPF_1
		).getCpf(),BaseTest.CPF_1,"Se cadastro funciona");
	}
	@Test
	void exibirPessoa() {
		facade.cadastraPessoa(BaseTest.CPF_1, BaseTest.NOME_1, BaseTest.HABILIDADES_1);
		System.out.println(facade.exibirPessoa(BaseTest.CPF_1));
		Assertions.assertEquals(facade.exibirPessoa(BaseTest.CPF_1),"Leticia Farias - 08907070372\nComentários:\n","exibição pessoa");
	}

	@Test
	void alterarNomePessoa() {
		facade.cadastraPessoa(BaseTest.CPF_1, BaseTest.NOME_1, BaseTest.HABILIDADES_1);
		facade.alterarNomePessoa(BaseTest.CPF_1, BaseTest.NOME_2);
		Assertions.assertEquals(facade.getPessoaController().getPessoasRepo().getPessoa(BaseTest.CPF_1
		).getNome(),BaseTest.NOME_2,"alterar nome");
	}

	@Test
	void  removerPessoa() {
		facade.cadastraPessoa(BaseTest.CPF_1, BaseTest.NOME_1, BaseTest.HABILIDADES_1);
		facade.removerPessoa(BaseTest.CPF_1);

		try{
			facade.getPessoaController().getPessoasRepo().getPessoa(BaseTest.CPF_1);
			fail("Sem exception");
		}catch(IllegalArgumentException e){
			assertEquals("Não existe essa pessoa", e.getMessage());
		}
	}

	@Test
	void adicionarComentarioPessoa() {
		facade.cadastraPessoa(BaseTest.CPF_1, BaseTest.NOME_1, BaseTest.HABILIDADES_1);
		facade.cadastraPessoa(BaseTest.CPF_2, BaseTest.NOME_2, BaseTest.HABILIDADES_2);
		facade.adicionarComentarioPessoaa(BaseTest.CPF_1, "ótima pessoa", BaseTest.CPF_2);
		Assertions.assertEquals(facade.getPessoaController().getPessoasRepo().getPessoa(BaseTest.CPF_1
		).getComentariosString(),"- ótima pessoa\n","verifica Comentarios");
	}

	@Test
	void listarComentariosPessoa() {
		facade.cadastraPessoa(BaseTest.CPF_2, BaseTest.NOME_2, BaseTest.HABILIDADES_2);
		facade.adicionarComentarioPessoaa(BaseTest.CPF_2, "ótima pessoa", BaseTest.CPF_1);
		facade.adicionarComentarioPessoaa(BaseTest.CPF_2, "belo profissional", BaseTest.CPF_1);
		Assertions.assertEquals(facade.listarComentariosPessoa(BaseTest.CPF_2),"- ótima pessoa\n- belo profissional\n","comentarios");
	}

}
