package br.com.digivalle.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.digivalle.domain.Funcionario;

public class FuncionarioRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudswingpu");
	private static EntityManager em = emf.createEntityManager();
	
	public static List<Funcionario> listarFuncionarios() {
		TypedQuery<Funcionario> resultado = em.createQuery("SELECT f from Funcionario f", Funcionario.class);
		
		return resultado.getResultList();
	}
	
	public static Funcionario getFuncionario(Integer id) {
		return em.find(Funcionario.class, id);
	}
	
	public static void salvar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
	}
	
	public static void apagar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
	}
	
	public static void atualizar(Funcionario funcionario, Integer id) {
		em.getTransaction().begin();
		Funcionario f = getFuncionario(id);
		f.setIdade(funcionario.getIdade());
		f.setNome(funcionario.getNome());
		em.getTransaction().commit();
	}
	
	public static void atualizar(Integer idade, String nome, Integer id) {
		em.getTransaction().begin();
		Funcionario f = getFuncionario(id);
		f.setIdade(idade);
		f.setNome(nome);
		em.getTransaction().commit();
	}
	
}
