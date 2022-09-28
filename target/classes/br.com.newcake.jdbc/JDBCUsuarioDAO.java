package br.com.newcake.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import br.com.newcake.jdbcInterface.UsuarioDAO;
import br.com.newcake.model.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO {
    
    private Connection conexao;

    public JDBCUsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public boolean inserir(Usuario usuario){

        String sql = "INSERT INTO usuario (nome, CPF, senha, telefone, id_tipo_usuario)" 
                    + "VALUES (?, ?, ?, ?, ?);";
        
        PreparedStatement p;

        try
        {
            p = this.conexao.prepareStatement(sql);

            p.setString(1, usuario.getNome);
            p.setString(2, usuario.getCpf);
            p.setString(3, usuario.getSenha);
            p.setString(4, usuario.getTelefone);
            p.setString(5, usuario.getTipoUsuario);
            
            p.execute();
        }
        catch (SQLException error)
        {
            error.printStackTrace();
			return false;
        }

        return true;

    }

    public boolean alterar(Usuario usuario)
    {
        String sql = "UPDATE usuario SET nome = ?, CPF = ?, senha = ?, telefone = ?, id_tipo_usuario = ?"
                        + "WHERE id_usuario = ?";

        PreparedStatement p;

        try
        {
            p = this.conexao.prepareStatement(sql);

            p.setString(1, usuario.getNome);
            p.setString(2, usuario.getCpf);
            p.setString(3, usuario.getSenha);
            p.setString(4, usuario.getTelefone);
            p.setString(5, usuario.getTipoUsuario);
            p.setInt(6, usuario.getId);

            p.executeUpdate();
        }
        catch(SQLException error) 
        {
            error.printStackTrace();
            return false;
        }
        
        return true;
    }

    public boolean deletar(int id)
    {

        String sql = "DELETE FROM usuario WHERE id = ?";

        PreparedStatement p;

        try
        {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, usuario.getId);

            p.execute();
        }
        catch(SQLException error)
        {
            error.printStackTrace();
            return false;
        }

        return true;
    }

    // public List<JsonObject> listarUsuarios(int id)
    // {
    //     String sql = "SELECT  id, nome, CPF, telefone FROM usuario"
    //                 + "WHERE id_usuario = ?";

        
    // }

}
