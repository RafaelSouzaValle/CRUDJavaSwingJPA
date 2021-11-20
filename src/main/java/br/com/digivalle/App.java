package br.com.digivalle;

import java.util.List;

import br.com.digivalle.domain.Funcionario;
import br.com.digivalle.repository.FuncionarioRepository;

public class App {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario(null, "Fulano01", 36);
		Funcionario f2 = new Funcionario(null, "Fulano02", 26);
		Funcionario f3 = new Funcionario(null, "Fulano03", 16);
		
//		FuncionarioRepository.salvar(f1);
//		FuncionarioRepository.salvar(f2);
//		FuncionarioRepository.salvar(f3);
		
		List<Funcionario> lista = FuncionarioRepository.listarFuncionarios();
		
		for (Funcionario funcionario : lista) {
			System.out.println(funcionario);
		}
		
		
	}
}
