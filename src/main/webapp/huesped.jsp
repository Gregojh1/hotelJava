<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>registro huespedes</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
                crossorigin="anonymous">
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.2/font/bootstrap-icons.min.css">

        </head>

        <body>
            <jsp:include page="componentes/nav.jsp" />


            <c:if test="${mensaje} != null">
                <div class="alert alert-success show fade">${msm}</div>
            </c:if>


            <div class="container">
                <form action="huesped?accion=guarda" class="d-flex g-2 flex-column"  method="post">
                    <div class="form-floating mb-3">

                        <input type="text" class="form-control"  id="namehuesped" placeholder="juan" name="nombre">
                        <label for="namehuesped" class="form-label">nombre</label>
                    </div>
                    <div class="form-floating mb-3">

                        <input type="text" class="form-control" id="apellidoHuesped" placeholder="ramirez"
                            name="apellido">
                        <label for="apellidoHuesped" class="form-label">apellido</label>
                    </div>
                    <div class="form-floating mb-3">

                        <input type="email" class="form-control" id="email" placeholder="juan@gmail.com" name="email">
                        <label for="email" class="form-label">email</label>

                    </div>
                    <div class="form-floating mb-3">

                        <input type="number" class="form-control" id="numero_documento" placeholder="95683992"
                            name="numero_documento">
                        <label for="numero_documento" class="form-label">numero de documento</label>
                    </div>
                    <div class="form-floating mb-3">
                        <select class="form-select" id="tipoDocumento" name="tipo_de_documento"
                            aria-label="Floating label select example">
                            <option selected>selecione un rol</option>
                            <option value="DNI">DNI</option>
                            <option value="PASSAPORT">PASSAPORT</option>
                            <option value="CEDULA">CEDULA</option>
                        </select>
                        <label for="tipoDocumento">tipo_documento</label>
                    </div>
                    <div class="form-floating mb-3">
                        <select class="form-select" name="rol" id="rolhuesped"
                            aria-label="Floating label select example">
                            <option selected>selecione un rol</option>
                            <option value="ADMIN">ADMIN</option>
                            <option value="USER">USER</option>
                        </select>
                        <label for="rolhuesped">rol</label>
                    </div>
                    <div class="form-floating mb-3">

                        <input type="text" class="form-control" id="passwordhuesped" placeholder="Mor*2021"
                            name="password">
                        <label for="passwordhuesped" class="form-label">password</label>
                    </div>
                        <div class="form-floating mb-3">

                            <input type="date" class="form-control" id="nacimientohuesped" placeholder="yyyy-MM-dd"
                                name="fecha_nacimiento">
                            <label for="nacimientohuesped" class="form-label">Fecha de nacimiento</label>
                        </div>

                        <div class="container">
                                <button type="submit" class="btn btn-outline-primary d-block w-100">Registrar</button>
                        </div>
                </form>


            </div>



            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
                crossorigin="anonymous"></script>
        </body>

        </html>