package br.com.newcake.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.newcake.bd.Conexao;
import br.com.newcake.jdbc.JDBCUsuarioDAO;
import br.com.newcake.model.Usuario;

@Path("usuario")
public class UsuarioRest extends UtilRest {

    @POST
    @Path("/inserir")
    @Consumes("application/*")
    public Response inserir(String parametro){
        try
        {

            Conexao conect = new Conexao();
            Connection conexao = conect.openConnection();
            JDBCUsuarioDAO jdbcUsuario = new JDBCUsuarioDao(conexao);
            boolean retorno = jdbcUsuario.inserir(parametro);

            var msg = "";

            if(retorno) 
            {
                msg = "Usuário cadastrado com sucesso!";
            } 
            else 
            {
                msg = "Erro ao cadastrar usuário!";
            }
    
            conect.closeConnection();
    
            return buildResponse();
    
        } catch (Excepiton e)
        {
            e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
        }
    };

    @PUT
    @Path("/alterar")
    @Consumes("application/*")
    public Response alterar(String parametro){
        try
        {

            Conexao conect = new Conexao();
            Connection conexao = conect.openConnection();
            JDBCUsuarioDAO jdbcUsuario = new JDBCUsuarioDao(conexao);
            boolean retorno = jdbcUsuario.alterar(parametro);

            var msg = "";

            if(retorno) 
            {
                msg = "Usuário alterado com sucesso!";
            } 
            else 
            {
                msg = "Erro ao alterar dados do usuário!";
            }
    
            conect.closeConnection();
    
            return buildResponse();
    
        } catch (Excepiton e)
        {
            e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
        }
    };

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/*")
    public Response deletar(@PathParam("id") int id){
        try
        {

            Conexao conect = new Conexao();
            Connection conexao = conect.openConnection();
            JDBCUsuarioDAO jdbcUsuario = new JDBCUsuarioDao(conexao);
            boolean retorno = jdbcUsuario.alterar(id);

            var msg = "";

            if(retorno) 
            {
                msg = "Usuário deletado com sucesso!";
            } 
            else 
            {
                msg = "Erro ao deletar dados do usuário!";
            }
    
            conect.closeConnection();
    
            return buildResponse();
    
        } catch (Excepiton e)
        {
            e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
        }
    };
};
