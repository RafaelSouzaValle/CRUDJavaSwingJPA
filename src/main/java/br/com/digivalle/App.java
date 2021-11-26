package br.com.digivalle;

import java.util.List;

import br.com.digivalle.domain.Funcionario;
import br.com.digivalle.repository.FuncionarioRepository;
import br.com.digivalle.view.MainView;

public class App {

	public static void main(String[] args) {
		
		MainView.loadFrame();
		
		Funcionario f1 = new Funcionario(null, "Fulano01", 36);
		Funcionario f2 = new Funcionario(null, "Fulano02", 26);
		Funcionario f3 = new Funcionario(null, "Fulano03", 16);
		
//		FuncionarioRepository.salvar(f1);
//		FuncionarioRepository.salvar(f2);
//		FuncionarioRepository.salvar(f3);
		
		List<Funcionario> lista = FuncionarioRepository.listarFuncionarios();
		
		System.out.println("Lista de funcionários antes");
		for (Funcionario funcionario : lista) {
			System.out.println(funcionario);
		}
		
//		Funcionario f4 = FuncionarioRepository.getFuncionario(2);
//		
////		System.out.println(f4);
//		
//		FuncionarioRepository.apagar(f4);
		
//		Funcionario f5 = new Funcionario(null, "Fulano05", 56);
//		
//		FuncionarioRepository.atualizar(f5, 3);
//		
//		FuncionarioRepository.atualizar(80, "Beltrano", 1);
		
		
	}
}
