// Variable para inicializar el DataTable
var tabla, tabla1, tabla2, tabla3, session, datos;

//productos.push({reference: "AP-904", quantity: 1});
// Variable para guardar la URL de las peticiones
var url_pet = "";

$(document).ready(function () {
    session = localStorage.getItem('session');
    
    if (session == 'true') {
        datos = JSON.parse(localStorage.getItem('datos'));
        $("#ident_usu").text(datos['identification']);
        $("#nomb_usu").text(datos['name']);
        $("#ema_usu").text(datos['email']);
        $("#perf_usu").text(datos['type']);
        $("#zon_usu").text(datos['zone']);

        if (datos['type'] === 'ADMIN') {
            $("#menu_usu").show();
        } else if (datos['type'] === 'COORD') {
            $("#menu_usu").hide();
            $("#contentAdicc").hide();
            $("#contentList").removeAttr('class').attr('class', 'col-md-12');
        } else if (datos['type'] === 'ASE') {
            $("#menu_usu").hide();
            $("#contentAdicc").hide();
            $("#contentList").removeAttr('class').attr('class', 'col-md-12');
        }else{
            $("#menu_usu").hide();
        }
    } else {
        localStorage.setItem('session', false);
        localStorage.setItem('datos', Array());
        window.location.href = 'index.html';
    }

});



function cerrar() {
    localStorage.setItem('session', false);
    localStorage.setItem('datos', Array());
    window.location.href = 'index.html';
}