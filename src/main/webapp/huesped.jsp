<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro Huéspedes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
        crossorigin="anonymous">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.2/font/bootstrap-icons.min.css">
</head>

<body>
    <jsp:include page="componentes/nav.jsp" />

    <div class="container mt-3">
        <%-- Mensaje de éxito / alerta flash --%>
        <c:if test="${not empty msm}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${msm}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>

        <%-- FORMULARIO SUPERIOR: REGISTRAR O ACTUALIZAR --%>
        <c:choose>
            <c:when test="${huespedBD != null}">
                <form action="huesped?accion=updatenow" class="d-flex g-2 flex-column" method="post">
                    <input type="hidden" name="id" value="${huespedBD.id}">
            </c:when>
            <c:otherwise>
                <form action="huesped?accion=guarda" class="d-flex g-2 flex-column" method="post">
            </c:otherwise>
        </c:choose>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="namehuesped" placeholder="Juan" name="nombre" value="${huespedBD.nombre}" required>
                <label for="namehuesped" class="form-label">Nombre</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="apellidoHuesped" placeholder="Ramirez" name="apellido" value="${huespedBD.apellido}" required>
                <label for="apellidoHuesped" class="form-label">Apellido</label>
            </div>

            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" placeholder="juan@gmail.com" name="email" value="${huespedBD.email}" required>
                <label for="email" class="form-label">Email</label>
            </div>

            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="numero_documento" placeholder="95683992" name="numero_documento" value="${huespedBD.numeroDocumento}" required>
                <label for="numero_documento" class="form-label">Número de documento</label>
            </div>

            <div class="form-floating mb-3">
                <select class="form-select" id="tipoDocumento" name="tipo_de_documento" required>
                    <option value="" ${empty huespedBD.tipoDocumento ? 'selected' : ''}>Seleccione un tipo</option>
                    <option value="DNI" ${huespedBD.tipoDocumento == 'DNI' ? 'selected' : ''}>DNI</option>
                    <option value="PASSAPORT" ${huespedBD.tipoDocumento == 'PASSAPORT' ? 'selected' : ''}>PASAPORTE</option>
                    <option value="CEDULA" ${huespedBD.tipoDocumento == 'CEDULA' ? 'selected' : ''}>CEDULA</option>
                </select>
                <label for="tipoDocumento">Tipo de documento</label>
            </div>

            <div class="form-floating mb-3">
                <select class="form-select" name="rol" id="rolhuesped" required>
                    <option value="" ${empty huespedBD.rol ? 'selected' : ''}>Seleccione un rol</option>
                    <option value="ADMIN" ${huespedBD.rol == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
                    <option value="USER" ${huespedBD.rol == 'USER' ? 'selected' : ''}>USER</option>
                </select>
                <label for="rolhuesped">Rol</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="passwordhuesped" placeholder="Mor*2021" name="password" value="${huespedBD.password}" required>
                <label for="passwordhuesped" class="form-label">Password</label>
            </div>

            <div class="form-floating mb-3">
                <input type="date" class="form-control" id="nacimientohuesped" name="fecha_nacimiento" value="${huespedBD.fechaNacimiento}" required>
                <label for="nacimientohuesped" class="form-label">Fecha de nacimiento</label>
            </div>

            <div class="mb-4">
                <button type="submit" class="btn btn-outline-primary d-block w-100">
                    ${huespedBD != null ? 'Guardar Cambios' : 'Registrar'}
                </button>
            </div>
        </form>

        <hr class="my-4">

        <%-- FORMULARIO INFERIOR: TABLA Y ACCIONES DE SELECCIÓN --%>
        <form method="post">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th scope="col" class="text-center">Seleccionar</th>
                            <th scope="col">ID</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Eliminado</th>
                            <th scope="col">Email</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Fecha Nacimiento</th>
                            <th scope="col">Tipo Doc</th>
                            <th scope="col">N° Documento</th>
                            <th scope="col">Rol</th>
                            <th scope="col">Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${huespedes}" var="hu">
                            <tr>
                                <td class="text-center">
                                    <input class="form-check-input" type="radio" name="id" value="${hu.id}" required>
                                </td>
                                <td>${hu.id}</td>
                                <td>${hu.apellido}</td>
                                <td>${hu.delete}</td>
                                <td>${hu.email}</td>
                                <td>${hu.nombre}</td>
                                <td>${hu.fechaNacimiento}</td>
                                <td>${hu.tipoDocumento}</td>
                                <td>${hu.numeroDocumento}</td>
                                <td>${hu.rol}</td>
                                <td>${hu.password}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <%-- BOTONES DE ACCIÓN DENTRO DEL FORMULARIO DE LA TABLA --%>
            <div class="d-flex justify-content-start gap-2 mt-3 mb-5">
                <button class="btn btn-warning" type="submit" formaction="huesped?accion=update">
                    <i class="bi bi-arrow-clockwise"></i> Modificar
                </button>

                <button class="btn btn-danger" type="submit" formaction="huesped?accion=delete">
                    <i class="bi bi-trash"></i> Eliminar
                </button>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>

</html>