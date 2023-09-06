<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <link rel="stylesheet" href="css/bootstrap.min.css" />
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />
            <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css" />
            <link rel="stylesheet" href="css/style.css" />
            <title>Dashboard</title>
        </head>

        <body>
            <!-- top navigation bar -->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebar"
                        aria-controls="offcanvasExample">
                        <span class="navbar-toggler-icon" data-bs-target="#sidebar"></span>
                    </button>
                    <a class="navbar-brand me-auto ms-lg-0 ms-3 text-uppercase fw-bold" href="#">The Jobs</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#topNavBar"
                        aria-controls="topNavBar" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <!-- <div class="collapse navbar-collapse" id="topNavBar">
          <form class="d-flex ms-auto my-3 my-lg-0">
            <div class="input-group">
              <input
                class="form-control"
                type="search"
                placeholder="Search"
                aria-label="Search"
              /> -->
                    <!-- <button class="btn btn-primary" type="submit">
                <i class="bi bi-search"></i>
              </button> -->
                </div>
                </form>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle ms-2" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            <i class="bi bi-person-fill"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li>
                                <c:if test="${empty sessionScope.loggedInAdmin}">
                                    <%response.sendRedirect("login.jsp"); %>
                                </c:if>
                                <c:if test="${sessionScope.loggedInAdmin ne null}">
                                    <a class="dropdown-item">Hello, ${sessionScope.loggedInAdmin.getFname()} !</a>
                                </c:if>
                            </li>
                            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/login.jsp">Logout</a></li>
                            <!-- <li>
                  <a class="dropdown-item" href="#">Something else here</a>
                </li> -->
                        </ul>
                    </li>
                </ul>
                </div>
                </div>
            </nav>
            top navigation bar
            <!-- offcanvas -->
            <div class="offcanvas offcanvas-start sidebar-nav bg-dark" tabindex="-1" id="sidebar">
                <div class="offcanvas-body p-0">
                    <nav class="navbar-dark">
                        <ul class="navbar-nav">
                            <li>
                                <div class="text-muted small fw-bold text-uppercase px-3">
                                    Panel
                                </div>
                            </li>
                            <li>
                                <a href="#" class="nav-link px-3 active">
                                    <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                    <span>Dashboard</span>
                                </a>
                            </li>
                            <li class="my-4">
                                <hr class="dropdown-divider bg-light" />
                            </li>
                            <li>
                                <div class="text-muted small fw-bold text-uppercase px-3 mb-3">
                                    Menu
                                </div>
                            </li>
                            <li>
                                <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#layouts">
                                    <span class="me-2"><i class="bi bi-layout-split"></i></span>
                                    <span>Appoinments</span>
                                    <span class="ms-auto">
                                        <span class="right-icon">
                                            <i class="bi bi-chevron-down"></i>
                                        </span>
                                    </span>
                                </a>
                                <div class="collapse" id="layouts">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>View Appoinment</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="collapse" id="layouts">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>Create Appoinment</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>

                            <li>
                                <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#layouts1">
                                    <span class="me-2"><i class="bi bi-layout-split"></i></span>
                                    <span>Customers</span>
                                    <span class="ms-auto">
                                        <span class="right-icon">
                                            <i class="bi bi-chevron-down"></i>
                                        </span>
                                    </span>
                                </a>
                                <div class="collapse" id="layouts1">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>View Customers</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="collapse" id="layouts1">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>Create Customer</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>

                            </li>

                            <li>
                                <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#layouts2">
                                    <span class="me-2"><i class="bi bi-layout-split"></i></span>
                                    <span>Consultants</span>
                                    <span class="ms-auto">
                                        <span class="right-icon">
                                            <i class="bi bi-chevron-down"></i>
                                        </span>
                                    </span>
                                </a>
                                <div class="collapse" id="layouts2">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>View Consultant</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="collapse" id="layouts2">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>Create Consultant</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>

                            </li>
                            <li>
                                <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#layouts3">
                                    <span class="me-2"><i class="bi bi-layout-split"></i></span>
                                    <span>Users</span>
                                    <span class="ms-auto">
                                        <span class="right-icon">
                                            <i class="bi bi-chevron-down"></i>
                                        </span>
                                    </span>
                                </a>
                                <div class="collapse" id="layouts3">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>View User</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>

                                <div class="collapse" id="layouts3">
                                    <ul class="navbar-nav ps-3">
                                        <li>
                                            <a href="#" class="nav-link px-3">
                                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                                <span>Create User</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>

                            </li>
                            <li class="my-4">
                                <hr class="dropdown-divider bg-light" />
                            </li>
                            <li>
                                <div class="text-muted small fw-bold text-uppercase px-3 mb-3">
                                    Reports
                                </div>
                            </li>
                            <li>
                                <a href="#" class="nav-link px-3">
                                    <span class="me-2"><i class="bi bi-graph-up"></i></span>
                                    <span>Report 1</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="nav-link px-3">
                                    <span class="me-2"><i class="bi bi-table"></i></span>
                                    <span>Report 2</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <!-- offcanvas -->
            <main class="mt-5 pt-3">
                <div class="container-fluid">
                    <div class="row">
                        <h2>Add New Consultant</h2>
                    </div>
                    <form action="<%=request.getContextPath()%>/ConsultantServlet?action=Ctrate" method="post">
                        <div class="row mt-5">
                            <div class="col-md-6">
                                <label for="inputMnumber" class="form-label">First Name</label>
                                <input type="text" class="form-control" name="Fname">
                            </div>
                            <div class="col-md-6">
                                <label for="inputMnumber" class="form-label">Last Name</label>
                                <input type="text" class="form-control" name="Lname">
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col-md-6">
                                <label for="inputMnumber" class="form-label">Mobile Number</label>
                                <input type="text" class="form-control" name="MNumber">
                            </div>
                            <div class="col-md-6">
                                <label for="inputMnumber" class="form-label">Email</label>
                                <input type="text" class="form-control" name="email">
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col-md-6">
                                <label for="inputMnumber" class="form-label">Country</label>
                                <input type="text" class="form-control" name="country">
                            </div>
                        </div>
                        <div class="row mt-5">
                        <div class="col-6">
	                		<ul class="error text text-danger">
		                <c:forEach var="error" items="${errors1}">
		                	<li>${error}</li>
		                </c:forEach>
	                	</ul>
	                	</div>
                </div>
                        <div class="row mt-5">
                            <div class="col">
                                <input type="submit" value="Submit" class="btn btn-success">
                            </div>
                        </div>
                    </form>
                </div>
            </main>
            <script src="./js/bootstrap.bundle.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
            <script src="./js/jquery-3.5.1.js"></script>
            <script src="./js/jquery.dataTables.min.js"></script>
            <script src="./js/dataTables.bootstrap5.min.js"></script>
            <script src="./js/script.js"></script>
        </body>

        </html>