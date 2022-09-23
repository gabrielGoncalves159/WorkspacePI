NEWCAKE.usuario = new Object();

$(document).ready(function(){

    NEWCAKE.usuario.modalCadastrarUsuario = function() {

        var modalCadastrarUsuario = {
            title: "Cadastrar Marca",
            width: 400,
            height: 300,
            modal: true,
            buttons: {
                "Cancelar": function(){},
                "Salvar": function(){

                    NEWCAKE.usuario.cadastrarUsuario()
                },
            }
        };

        $("#modalCadastroUsuario").dialog(modalCadastrarUsuario);
    };

    NEWCAKE.usuario.cadastrarUsuario = function() {

        var usuario = new Object();

        usuario.nome = document.frmCadastrarUsuario.nome.value;
        usuario.tipoUsuario = document.frmCadastrarUsuario.tipo-usuario.value;
        usuario.cpf = document.frmCadastrarUsuario.cpf.value;
        usuario.telefone = document.frmCadastrarUsuario.telefone.value;
        usuario.senha = document.frmCadastrarUsuario.senha.value;

        // if((usuario.nome == "") || (usuario.tipoUsuario == "") || (usuario.cpf == "")
        // || (usuario.telefone == "") || (usuario.senha == "")){
        // COLDIGO.exibirAviso("Preencha todos os campos!");

        $.ajax({

            type: "POST",
				url: NEWCAKE.PATH + "usario/inserir",
				data:JSON.stringify(usuario),
				success: function (msg) {
					NEWCAKE.modalAviso(msg);
					NEWCAKE.usuario.getListUsuario();
					$("#cadastrarUsuario").trigger("reset");
				},
				error: function (into) {
					NEWCAKE.modalAviso("Erro ao cadastrar um novo usuario: "+ info.status + " - " + info.statusText);
				}
        });
    };

    NEWCAKE.usuario.alterarDadosDoUsuario = function() {

        var usuario = new Object();

        usuario.nome = document.frmCadastrarUsuario.nome.value;
        usuario.tipoUsuario = document.frmCadastrarUsuario.tipo-usuario.value;
        usuario.cpf = document.frmCadastrarUsuario.cpf.value;
        usuario.telefone = document.frmCadastrarUsuario.telefone.value;
        usuario.senha = document.frmCadastrarUsuario.senha.value;

        $.ajax({

            type: "PUT",
				url: NEWCAKE.PATH + "usario/alterar",
				data: JSON.stringify(usuario),
				success: function (msg) {
                    NEWCAKE.modalAviso(msg);
                    NEWCAKE.usuario.getListUsuario();
					$("#cadastrarUsuario").trigger("reset");

				},
				error: function (into) {
					NEWCAKE.modalAviso("Erro ao cadastrar um novo usuario: "+ info.status + " - " + info.statusText);
				}
        });
    };

    NEWCAKE.usuario.getListUsuario = function() {
        

    };
})