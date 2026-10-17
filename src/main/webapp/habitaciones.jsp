<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
                crossorigin="anonymous">
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.2/font/bootstrap-icons.min.css">

        </head>

        <body>
            <jsp:include page="componentes/nav.jsp">
                <!--<jsp:param name="nombre" value="Carlos" />-->
            </jsp:include>


 <div class="container">
        <div class="row">
            <div class="col-lg-4">

                <form class="d-flex g-2" action="habitaciones?accion=guarda" method="post">

                    <div class="form-floating mb-3">
                        <input type="number" class="form-control" id="numeroHabitacion" placeholder="03">
                        <label for="numeroHabitacion">numero habitacion</label>
                    </div>
                    <div class="form-floating">
                        <input type="number" class="form-control" id="capacidad" placeholder="3">
                        <label for="capacidad">campacidad</label>
                    </div>
                    <div class="form-floating">
                        <select class="form-select" id="estado" aria-label="Floating label select example">
                            <option selected>agregue un estado</option>
                            <option value="disponible">disponible</option>
                            <option value="ocupada">ocupada</option>
                            <option value="fuera de servicio">fuera de servicio</option>
                        </select>
                        <label for="estado">estado</label>
                    </div>

                    <div class="form-floating">
                        <input type="number" step="0.00" class="form-control" id="precio" placeholder="1500.00">
                        <label for="precio"><i class="bi bi-cash-stack p-2"></i>precio</label>
                    </div>
                    <button class="btn btn-outline-success w-100">Registrar habitacion</button>
                </form>


            </div>
            <div class="col-lg-8">
                <table class="table table-primary">
                    <thead>
                        <tr>
                            <th scope="col">numero habitacion</th>
                            <th scope="col">capacidad</th>
                            <th scope="col">estado</th>
                            <th scope="col">precio</th>
                            <th scope="col">accion</th>
                        </tr>
                    </thead>
                    <tbody class="table-light">
                        <tr>
                            <th>1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>
                                <a class="btn btn-warning p-2"><i class="bi bi-arrow-clockwise"></i></a>
                                <a class="btn btn-danger p-2"><i class="bi bi-trash"></i></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>
    </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
                crossorigin="anonymous"></script>
        </body>

        </html>