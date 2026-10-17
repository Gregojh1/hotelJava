<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>registrarse</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    </head>

    <body>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark" data-bs-themes="dark">
            <div class="container">
                <a class="navbar-brand" href="#">Navbar</a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="#">Habitaciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Reservas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Caja</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <c:if test="${mensaje != null}">
            <div class="alert alert-primary" role="alert">
                ${mensaje}
            </div>
        </c:if>

        <div class="container mt-5">
            <form action="registrocliente" method="get">

                <div class="d-flex flex-column px-5">
                    <label for="name" class="form-label">nombre:</label>
                    <input type=text" class="form-control" id="name" placeholder="juan carlos" name="nombre">
                </div>


                <div class="d-flex flex-column px-5">
                    <label for="name" class="form-label">apellido:</label>
                    <input type=text" class="form-control" id="apellido" placeholder="Rodrigo" name="nombre">
                </div>

                <div class="d-flex flex-column px-5">
                    <label for="tipo_documento" class="form-label">tipo_documento:</label>
                    <input type=text" class="form-control" id="tipo_documento" placeholder="Rodrigo"
                        name="tipo_documento">
                </div>

                <div class="d-flex flex-column px-5">
                    <label for="nro_dni" class="form-label">nro_dni:</label>
                    <input type="number" class="form-control" id="nro_dni" placeholder="Rodrigo" name="nro_dni">
                </div>

                <div class="d-flex flex-column px-5">
                    <label for="email" class="form-label">email:</label>
                    <input type="email"" class=" form-control" id="email" placeholder="example@gmail.com" name="email">
                </div>

                <div class="px-5 mt-3 text-center">
                    <button class="btn btn-outline-success">Registrar Cliente</button>
                </div>
            </form>

        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>
    </body>

    </html>