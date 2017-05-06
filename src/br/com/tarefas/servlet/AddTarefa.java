package br.com.tarefas.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.util.ConnectionFactory;
import br.com.tarefas.dao.TarefaDao;
import br.com.tarefas.modelo.Tarefa;

@WebServlet("/sistema")
public class AddTarefa extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("logica");
		
		if(acao.equals("inserirTarefa")){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/formulario.jsp");
			dispatcher.forward(req, resp);
		}else if(acao.equals("salvarTarefa")){
			
			String titulo = req.getParameter("titulo");
			String descricao = req.getParameter("descricao");
			
			Tarefa tarefa = new Tarefa();
			tarefa.setTitulo(titulo);
			tarefa.setDescricao(descricao);
			
			Connection connection = new ConnectionFactory().getConnection();
			TarefaDao dao = new TarefaDao(connection);
			dao.addTarefa(tarefa);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/tarefaAdicionada.jsp");
			dispatcher.forward(req, resp);
			
		}else if(acao.equals("listaTarefas")){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/listaDeTarefas.jsp");
			dispatcher.forward(req, resp);
		}
	}
}