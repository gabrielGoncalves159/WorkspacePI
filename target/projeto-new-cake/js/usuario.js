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
                "Salvar": function(){},
            }
        }

        $("#modalCadastroUsuario").dialog(modalCadastrarUsuario);
    }
})