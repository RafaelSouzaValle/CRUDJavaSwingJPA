/**
 * 
 * @author rafaelsouzavalle
 * 
 * Código elaborado para o curso de Java Swing
 * digivalle.com.br
 * 
 */

package br.com.digivalle.view;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.digivalle.domain.Funcionario;
import br.com.digivalle.repository.FuncionarioRepository;

public class MainView {

	private static final Dimension DIMENSAO_FRAME = new Dimension(500, 300);

	private static final Point POSICAO_FRAME = new Point(150, 150);

	private static JFrame frame;

	public static void loadFrame() {

		// Cria a janela
		frame = new JFrame();

		// Organiza a disposição dos componentes no frame
		frame.setLayout(new GridLayout(3, 1));

		// Define o título da janela
		frame.setTitle("Janela principal");

		// Define o tamanho para a janela (largura, altura) em pixels
		// Pode receber como parâmetro um Dimension ou as medidas x e y em pixels
		frame.setSize(DIMENSAO_FRAME);

		// Define a localização da janela (frame) na tela.
		// Pode receber como parâmetro um Point ou as medidas x e y em pixels
		frame.setLocation(POSICAO_FRAME);

		// Define o que ocorre quando a janela é fechada.
		// No exemplo a aplicação é encerrada quando fecha a janela.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * 
		 * Adicionando componentes
		 */

		// Painel que agrupa componentes
		JPanel panelSalvar = new JPanel();

		// Cria um texto exibido para o usuário.
		JLabel labelNome = new JLabel("Nome:");

		// Adciona o componente ao painel
		panelSalvar.add(labelNome);

		// Cria um campo de texto para o usuário digitar.
		// Recebe como como parâmetro a quantidade de colunas
		// (Sem parâmetros não limita a quantidade de caracteres)
		final JTextField txtNome = new JTextField(10);

		// Adciona o componente ao painel
		panelSalvar.add(txtNome);

		// Cria um texto exibido para o usuário.
		JLabel labelIdade = new JLabel("Idade:");

		// Adciona o componente ao painel
		panelSalvar.add(labelIdade);

		// Cria campo idade
		final JTextField txtIdade = new JTextField(2);

		// Adciona o componente ao painel
		panelSalvar.add(txtIdade);

		// Cria botão
		Button btnSalvar = new Button("Salvar Usuário");

		// Instrução para o botão
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String nome = txtNome.getText();
				Integer idade = Integer.valueOf(txtIdade.getText());

				System.out.println(nome + " " + idade);

				FuncionarioRepository.salvar(new Funcionario(null, nome, idade));

				JOptionPane.showMessageDialog(null, "Funcionário " + nome + " adicionado com sucesso!");

				txtNome.setText("");
				txtIdade.setText("");

			}
		});

		// Painel que agrupa componentes
		JPanel panelConsulta = new JPanel();

		// Cria botão
		Button btnConsulta = new Button("Exibir Funcionários");

		// Instrução para o botão
		btnConsulta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				StringBuilder sb = new StringBuilder();

				List<Funcionario> funcionarios = FuncionarioRepository.listarFuncionarios();

				for (Funcionario f : funcionarios) {
					sb.append(f.toString() + "\n");
				}

				JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Funcionários",
						JOptionPane.INFORMATION_MESSAGE);

			}

		});

		// Painel que agrupa componentes
		JPanel panelAlterar = new JPanel();

		JLabel labelId = new JLabel("Id:");
		panelAlterar.add(labelId);

		final JTextField txtId = new JTextField(4);
		panelAlterar.add(txtId);

		Button btnApagar = new Button("Apagar Funcionário");
		panelAlterar.add(btnApagar);

		btnApagar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				Integer id = Integer.valueOf(txtId.getText());

				Funcionario f = FuncionarioRepository.getFuncionario(id);

				String dadosFuncionario = f.toString();

				FuncionarioRepository.apagar(f);

				JOptionPane.showMessageDialog(null, "Funcionário apagado: " + dadosFuncionario);

			}
		});
		
		Button btnAlterar = new Button("Alterar Funcionário");
		panelAlterar.add(btnAlterar);

		btnAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				Integer idade = Integer.valueOf(txtIdade.getText());
				
				Funcionario f = new Funcionario(null, nome, idade);
				
				Integer id = Integer.valueOf(txtId.getText());
				
				FuncionarioRepository.atualizar(f, id);
				
				JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");

			}
		});

		// Adciona o componente ao painel
		panelSalvar.add(btnSalvar);

		// Adciona o componente ao painel
		panelConsulta.add(btnConsulta);

		// Adiciona o panel ao frame
		frame.add(panelSalvar);

		// Adiciona o panel ao frame
		frame.add(panelConsulta);

		// Adiciona o panel ao frame
		frame.add(panelAlterar);

		// Define a janela como visível
		frame.setVisible(true);

	}

}
