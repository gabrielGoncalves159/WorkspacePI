NEWCAKE = new Object();

$(document).ready(function() {

    $("header").load("/projeto-new-cake/pages/admin/geral/header.html");
    $("aside").load("/projeto-new-cake/pages/admin/geral/menu.html");
    $("footer").load("/projeto-new-cake/pages/admin/geral/footer.html");

    NEWCAKE.loadPage = function(pagename) {

        if($(".ui-dialog"))
            $(".ui-dialog").remove();

        $("section").empty();
        $("section").load(pagename+"/", function(response, status, info){
            if(status == "error") {
                var msg = `Ocorre um erro ao tentar localizar a pagina ${info.status} - ${info.statusText}`
                $("section").html(msg);
            }
        });
    }

    NEWCAKE.modalAviso = function(texto) {

        var	modal= {
        title: "Aviso!",
        height: 250,
        width: 400,
        modal: true,
        buttons: {
            "OK": function(){
             $(this).dialog("close");
             }
        }
        };
        $("#modalAviso").html(texto);
        $("#modalAviso").dialog(modal);

    }

})