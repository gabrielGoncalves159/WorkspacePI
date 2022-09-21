package br.com.newcake.bd;

import java.sql.Connection;

public class Conexao {

    private Connection conexao;

    public Connection openConnection() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/bdcoldigo?"
			+"user=root&password=root&useTimezone=true&serverTimezone=UTC");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
	
	public void closeConexao() {
		try {
			conexao.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    }
    
}
