package br.com.newcake.jdbcInterface;

import java.util.List;

import br.com.newcake.model.Usuario;

public interface UsuarioDAO {
    
    public boolean inserir(Usuario usuario);
    public boolean alterar(Usuario usuario);
    public boolean deletar(int id);
    public List<JsonObject> listarUsuarios(int id);
}
