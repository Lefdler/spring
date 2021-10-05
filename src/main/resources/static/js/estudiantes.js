// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarEstudiantes();
  $('#estudiantes').DataTable();
});

async function cargarEstudiantes() {

    const request = await fetch('api/estudiantes', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const estudiantes = await request.json();


    let listadoHtml = '';
    for(let estudiante of estudiantes) {
        let botonEliminar = "<a href=\"#\" onclick='eliminarUsuario('+estudiante.id+')' class=\"btn btn-danger btn-circle btn-sm\"><i class=\"fas fa-trash\"></i></a>";

        let estudianteHtml = '<tr><td>'+estudiante.id+'</td><td>'+estudiante.nombre+'</td><td>'+estudiante.apellido+'</td><td>'+estudiante.promedio+'</td><td>'+estudiante.carrera+'</td><td>'+botonEliminar+'</td></tr>';
        listadoHtml += estudianteHtml;
    }

    document.querySelector('#estudiantes tbody').outerHTML = listadoHtml;
}

async function eliminarUsuario(id){

    if (!confirm('¿Desea eliminar este estudiante?')){
        return;
    }

    const request = await fetch('api/estudiantes'+ id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    location.reload()
}