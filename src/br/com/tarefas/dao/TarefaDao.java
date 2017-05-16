package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void alterarTarefa(Tarefa tarefa){
		String sql = "update tarefa set titulo=?,descricao=? where id=?";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, tarefa.getTitulo());
			pstm.setString(2, tarefa.getDescricao());
			pstm.setLong(3, tarefa.getId());
			pstm.execute();
			pstm.close();
			System.out.println("alterado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Tarefa> listaTarefas(){
		String sql = "select * from tarefa";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			List<Tarefa> lista = new ArrayList<Tarefa>();
			
			while (result.next()) {
				Tarefa T = new Tarefa();
				T.setId(result.getLong("id"));
				T.setTitulo(result.getString("titulo"));
				T.setDescricao(result.getString("descricao"));
				
				lista.add(T);
			}
			pstm.close();
			result.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remover(Long id){
		String sql = "delete from tarefa where id=?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			pstm.setLong(1, id);
			pstm.execute();
			pstm.close();
			System.out.println("removido com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tarefa buscarTarefa(Long id){
		String sql = "select * from tarefa where id=?";
		Tarefa tarefa = new Tarefa();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);			
			pstm.setLong(1, id);
			ResultSet result = pstm.executeQuery();
			if(result.next()){
				Tarefa T = new Tarefa();
				T.setId(result.getLong("id"));
				T.setTitulo(result.getString("titulo"));
				T.setDescricao(result.getString("descricao"));
				tarefa=T;
			}
			
			pstm.close();
			result.close();
			return tarefa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
