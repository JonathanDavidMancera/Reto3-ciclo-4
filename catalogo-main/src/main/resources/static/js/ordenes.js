$(document).ready(function () {
    
    const productsOrder = localStorage.getItem('productsOrder');
    console.log(productsOrder);

    // Crear instancia de DataTable
    tabla = $('#tabla_order').DataTable({
        dom: 'Bfrtip',
        "language": {
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });

    // Llamado a función mostrar_order()
    mostrar_order();
});

/*
 * mostrar_order() 
 * Función que llama método API GET a utilizar
 * @param url_pet, la dirección del api a utilizar
 * @return Response, devuelve la respuesta del método API, Listado de ordenes
 */
function mostrar_order() {

    tabla.clear().draw();

    $.ajax({
        method: "GET",
        url: url_pet + "/api/order/all",
        success: function (response) {
            console.log(response);
            if (response.length > 0) {
                for (var a = 0; a < response.length; a++) {
                    
                    var btnEdit = "<a class='btn btn-success text-center text-white' style='cursor: pointer;' onclick='javascript:edit_order(\"" + response[a]['id'] + "\")'><i class='fas fa-pencil-alt fa-1x'></i> Editar</a>";
                    var btnDelete = "<a class='btn btn-danger text-center text-white' style='cursor: pointer;' onclick='javascript:eliminar_order(\"" + response[a]['id'] + "\")'><i class='fas fa-trash-alt fa-1x'></i> Eliminar</a>";

                    if (datos['type'] === "ASE" && datos['zone'] === response[a]['salesMan']['zone'] && datos['id'] === response[a]['salesMan']['id']) {
                        tabla.row.add([
                            response[a]['id'],
                            response[a]['registerDay'],
                            response[a]['status'],
                            response[a]['salesMan']['name'],
                            "<a class='btn btn-info text-center text-white' style='cursor: pointer;' onclick='javascript:ver_detalle(\"" + response[a]['id'] + "\")'><i class='fas fa-eye fa-1x'></i> Ver</a>",
                            btnEdit,
                            btnDelete
                        ]).draw();
                    }else if (datos['type'] === "COORD" && datos['zone'] === response[a]['salesMan']['zone']) {
                        tabla.row.add([
                            response[a]['id'],
                            response[a]['registerDay'],
                            response[a]['status'],
                            response[a]['salesMan']['name'],
                            "<a class='btn btn-info text-center text-white' style='cursor: pointer;' onclick='javascript:ver_detalle(\"" + response[a]['id'] + "\")'><i class='fas fa-eye fa-1x'></i> Ver</a>",
                            btnEdit,
                            ""
                        ]).draw();
                    }else if (datos['type'] === "ADMIN") {
                        tabla.row.add([
                            response[a]['id'],
                            response[a]['registerDay'],
                            response[a]['status'],
                            response[a]['salesMan']['name'],
                            "<a class='btn btn-info text-center text-white' style='cursor: pointer;' onclick='javascript:ver_detalle(\"" + response[a]['id'] + "\")'><i class='fas fa-eye fa-1x'></i> Ver</a>",
                            btnEdit,
                            btnDelete
                        ]).draw();
                    }
                }
            }
        }
    });
}

/*
 * ver_detalle(id) 
 * Función que llama método API GET a utilizar
 * @param Id, Id de la orden
 * @param url_pet, la dirección del api a utilizar
 * @return Response, devuelve la respuesta del método API, Información de la orden
 */
function ver_detalle(id) {
    $.ajax({
        method: "GET",
        url: url_pet + "/api/order/" + id,
        contentType: "application/JSON",
        dataType: "JSON",
        success: function (response) {

            
        }
    });
}

/*
 * registrar_order() 
 * Función que llama método API POST a utilizar
 * @param register_day_order, Fecha de registro de la orden
 * @param status_order, Estado de la orden
 * @param sales_man_order, Usuario que realiza la orden
 * @param products_order, Productos seleccionados
 * @param quantities_order, Cantidad de los productos seleccionados
 * @param url_pet, la dirección del api a utilizar
 * @return statusCode, devuelve la respuesta del método API
 */
function registrar_order() {

    var register_day_order = new Date();
    var status_order = "Pendiente";
    const sales_man_order = {
        "id": datos['id'],
        "identification": datos['identification'],
        "name": datos['name'],
        "birthtDay": datos['birthtDay'],
        "monthBirthtDay": datos['monthBirthtDay'],
        "address": datos['address'],
        "cellPhone": datos['cellPhone'],
        "email": datos['email'],
        "password": datos['password'],
        "zone": datos['zone'],
        "type": datos['type']
    };
    const products_order = {
        
    };
    const quantities_order = {
        
    };
    

    let datos = {
        registerDay: register_day_order,
        status: status_order,
        salesMan: sales_man_order,
        products: products_order,
        quantities: quantities_order
    };

    $.ajax({
        method: "POST",
        url: url_pet + "/api/order/new",
        contentType: "application/JSON",
        dataType: "JSON",
        data: JSON.stringify(datos),
        statusCode: {
            201: function () {
                alert("Se registró correctamente la orden");
                mostrar_order();
            }
        }
    });
}

/*
 * actualizar_order() 
 * Función que llama método API PUT a utilizar
 * @param id_order, Id de la orden
 * @param status_order, Estado de la orden
 * @param url_pet, la dirección del api a utilizar
 * @return statusCode, devuelve la respuesta del método API
 */
function actualizar_order() {

    var id_order = $("#id_order").val();
    var status_order = $("#status_order").val();

    let datos = {
        id: id_order,
        status: status_order
    };

    $.ajax({
        type: "PUT",
        url: url_pet + "/api/order/update",
        contentType: "application/JSON",
        dataType: "JSON",
        data: JSON.stringify(datos),
        statusCode: {
            201: function () {
                alert("Se actualizó correctamente la orden");
                mostrar_order();
            }
        }
    });
}

/*
 * eliminar_order(id) 
 * Función que llama método API DELETE a utilizar
 * @param reference, Referencia del producto
 * @param url_pet, la dirección del api a utilizar
 * @return statusCode, devuelve la respuesta del método API
 */
function eliminar_order(id) {

    $.ajax({
        type: "DELETE",
        url: url_pet + "/api/order/" + id,
        contentType: "application/JSON",
        dataType: "JSON",
        statusCode: {
            204: function () {
                alert("Se eliminó correctamente la orden");
                mostrar_order();
            }
        }
    });
}