package br.com.tarefas.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

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
			String id = req.getParameter("id");
			String titulo = req.getParameter("titulo");
			String descricao = req.getParameter("descricao");
			if(id.equals("")){
				Tarefa tarefa = new Tarefa();
				tarefa.setTitulo(titulo);
				tarefa.setDescricao(descricao);
				
				Connection connection = new ConnectionFactory().getConnection();
				TarefaDao dao = new TarefaDao(connection);
				dao.addTarefa(tarefa);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/tarefaAdicionada.jsp");
				dispatcher.forward(req, resp);
			}else{
				Tarefa tarefa = new Tarefa();
				tarefa.setId(Long.valueOf(id));
				tarefa.setTitulo(titulo);
				tarefa.setDescricao(descricao);
				
				Connection connection = new ConnectionFactory().getConnection();
				TarefaDao dao = new TarefaDao(connection);
				dao.alterarTarefa(tarefa);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/tarefaAlterada.jsp");
				dispatcher.forward(req, resp);
			}
		}else if(acao.equals("listaTarefas")){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/listaDeTarefas.jsp");
			Connection connection = new ConnectionFactory().getConnection();
			TarefaDao dao = new TarefaDao(connection);
			List<Tarefa> tarefas = dao.listaTarefas();
			req.setAttribute("tarefas", tarefas);
			dispatcher.forward(req, resp);
		
		}else if(acao.equals("removerTarefa")){
			String id = req.getParameter("id");
			Connection connection = new ConnectionFactory().getConnection();
			TarefaDao dao = new TarefaDao(connection);
			dao.remover(Long.valueOf(id));
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/listaDeTarefas.jsp");
			Connection connection2 = new ConnectionFactory().getConnection();
			TarefaDao dao2 = new TarefaDao(connection2);
			List<Tarefa> tarefas = dao2.listaTarefas();
			req.setAttribute("tarefas", tarefas);
			dispatcher.forward(req, resp);
		}else if(acao.equals("alterarTarefa")){
			String id = req.getParameter("id");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/alterarTarefa.jsp");
			Connection connection = new ConnectionFactory().getConnection();
			TarefaDao dao = new TarefaDao(connection);
			Tarefa tarefas = dao.buscarTarefa(Long.valueOf(id));
			req.setAttribute("tarefas", tarefas);
			dispatcher.forward(req, resp);
		}
	}
}
