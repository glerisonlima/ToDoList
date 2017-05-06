package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.tarefas.modelo.Tarefa;

public class TarefaDao {
	
	private Connection connection;
	
	public TarefaDao(Connection connection) {
		this.connection = connection;
	}
	
	public void addTarefa(Tarefa tarefa){
		String sql = "insert into tarefa (titulo, descricao) values (?,?)";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, tarefa.getTitulo());
			pstm.setString(2, tarefa.getDescricao());
			pstm.execute();
			pstm.close();
			System.out.println("cadastrado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
