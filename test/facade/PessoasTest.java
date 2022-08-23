package facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PessoasTest extends BaseTest{

//+ cadastrarPessoa(cpf: str, nome: str, habilidades: str[]): void
//+ exibirPessoa(cpf: str): str
//+ alterarNomePessoa(cpf: str, novoNome: str): void
//+ alterarHabilidadesPessoa(cpf: str, novasHabilidades: str[]): void
//+ removerPessoa(cpf: str): void
//+ adicionarComentarioPessoa(cpf: str, comentario: str, autorCpf: str): void
//+ listarComentariosPessoa(cpf: str): str
	@Test
	void cadastrarPessoa() {
		facade.cadastraPessoa(CPF_1, NOME_1, HABILIDADES_1);
		assertEquals(facade.getPessoaController().getPessoasRepo().getPessoa(CPF_1
		).getCpf(),CPF_1,"Se cadastro funciona");
	}
	@Test
	void exibirPessoa() {
		facade.cadastraPessoa(CPF_1, NOME_1, HABILIDADES_1);
		System.out.println(facade.exibirPessoa(CPF_1));
		assertEquals(facade.exibirPessoa(CPF_1),"Leticia Farias - 08907070372\nComentários:\n","exibição pessoa");
	}

	@Test
	void alterarNomePessoa() {
		facade.cadastraPessoa(CPF_1, NOME_1, HABILIDADES_1);
		facade.alterarNomePessoa(CPF_1, NOME_2);
		assertEquals(facade.getPessoaController().getPessoasRepo().getPessoa(CPF_1
		).getNome(),NOME_2,"alterar nome");
	}

	@Test
	void  removerPessoa() {
		facade.cadastraPessoa(CPF_1, NOME_1, HABILIDADES_1);
		facade.removerPessoa(CPF_1);

		try{
			facade.getPessoaController().getPessoasRepo().getPessoa(CPF_1);
			fail("Sem exception");
		}catch(IllegalArgumentException e){
			assertEquals("Não existe essa pessoa", e.getMessage());
		}
	}

	@Test
	void adicionarComentarioPessoa() {
		facade.cadastraPessoa(CPF_1, NOME_1, HABILIDADES_1);
		facade.cadastraPessoa(CPF_2, NOME_2, HABILIDADES_2);
		facade.adicionarComentarioPessoaa(CPF_1, "ótima pessoa", CPF_2);
		assertEquals(facade.getPessoaController().getPessoasRepo().getPessoa(CPF_1
		).getComentariosString(),"- ótima pessoa\n","verifica Comentarios");
	}

	@Test
	void listarComentariosPessoa() {
		facade.cadastraPessoa(CPF_2, NOME_2, HABILIDADES_2);
		facade.adicionarComentarioPessoaa(CPF_2, "ótima pessoa", CPF_1);
		facade.adicionarComentarioPessoaa(CPF_2, "belo profissional", CPF_1);
		assertEquals(facade.listarComentariosPessoa(CPF_2),"- ótima pessoa\n- belo profissional\n","comentarios");
	}

}
