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
            <jsp:include page="componentes/nav.jsp" />


            <c:if test="${msm != null}">
                <div class="alert alert-success alert-dismissible fade show">
                    ${msm}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>


            <div class="container">
                <div class="row">
                    <div class="col-lg-4">

                        <c:choose>
                            <c:when test="${param.accion == 'update'}">

                                <form class="d-flex g-2 flex-column" action="habitaciones?accion=updatenow"
                                    method="post">
                            </c:when>

                            <c:otherwise>
                                <form class="d-flex g-2 flex-column" action="habitaciones?accion=guardar" method="post">
                            </c:otherwise>
                        </c:choose>




                        <c:if test="${param.accion == 'update'}">
                            <div class="form-floating mb-3">
                                <input type="number" class="form-control disabled" id="numeroHabitacion"  value="${habitacionBD.numeroHabitacion}" placeholder="03"
                                    name="numero_habitacion" readonly>
                                <label for="numeroHabitacion">numero habitacion</label>
                            </div>
                        </c:if>

                        <div class="form-floating">
                            <input type="number" class="form-control" value="" value="${habitacionBD.capacidad}" id="capacidad" placeholder="3" name="capacidad">
                            <label for="capacidad">capacidad</label>
                        </div>
                        <div class="form-floating">
                            <select class="form-select text-seccondary" id="estado" aria-label="Floating label select example"
                                name="estado" required>
                                <option selected>agregue un estado</option>
                                <option value="disponible">disponible</option>
                                <option value="ocupada">ocupada</option>
                                <option value="fuera de servicio">fuera de servicio</option>
                            </select>
                            <label for="estado">estado</label>
                        </div>

                        <div class="form-floating">
                            <input type="number" step="0.00" class="form-control" id="precio" placeholder="1500.00"
                                name="precio" value="${habitacionBD.precio}">
                            <label for="precio"><i class="bi bi-cash-stack p-2"></i>precio</label>
                        </div>
                        <button type="submit" class="btn btn-outline-success w-100">Registrar habitacion</button>
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

                                <c:forEach items="${habitaciones}" var="h">
                                    <tr>
                                        <th>${h.numeroHabitacion}</th>
                                        <td>${h.capacidad}</td>
                                        <td>${h.estado}</td>
                                        <td>${h.precio}</td>
                                        <td>
                                            <form class="d-inline"
                                                action="habitaciones?accion=update&id=${h.numeroHabitacion}"
                                                method="post">
                                                <button class="btn btn-warning" type="submit"><i
                                                        class="bi bi-arrow-clockwise"></i></button>
                                            </form>
                                            <form class="d-inline"
                                                action="habitaciones?accion=delete&id=${h.numeroHabitacion}"
                                                method="post">
                                                <button class="btn btn-danger" type="submit"><i
                                                        class="bi bi-trash"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>

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