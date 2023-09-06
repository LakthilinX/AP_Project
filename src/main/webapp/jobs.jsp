<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="utf-8">
      <meta content="width=device-width, initial-scale=1.0" name="viewport">

      <title>The Jobs</title>
      <meta content="" name="description">
      <meta content="" name="keywords">

      <!-- Favicons -->
      <link href="assets/img/favicon.png" rel="icon">
      <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

      <!-- Google Fonts -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link
        href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Raleway:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
        rel="stylesheet">

      <!-- Vendor CSS Files -->
      <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
      <link href="assets/vendor/aos/aos.css" rel="stylesheet">
      <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
      <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
      <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">

      <!-- Template Main CSS File -->
      <link href="assets/css/main.css" rel="stylesheet">

    </head>

    <body class="page-services">

      <!-- ======= Header ======= -->
      <header id="header" class="header d-flex align-items-center fixed-top">
        <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

          <a href="index.html" class="logo d-flex align-items-center">
            <!-- Uncomment the line below if you also wish to use an image logo -->
            <!-- <img src="assets/img/logo.png" alt=""> -->
            <h1 class="d-flex align-items-center">The Jobs</h1>
          </a>

          <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
          <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>

          <nav id="navbar" class="navbar">
            <ul>
              <li><a href="services.html">Go back</a></li>
              <!-- <li><a href="about.html">About</a></li>
          <li><a href="services.html" class="active">Services</a></li>
          <li><a href="team.html">Team</a></li>
          <li><a href="team.html">Login</a></li> -->

            </ul>
          </nav><!-- .navbar -->

        </div>
      </header><!-- End Header -->

      <main id="main">

        <!-- ======= Breadcrumbs ======= -->
        <div class="breadcrumbs d-flex align-items-center"
          style="background-image: url('assets/img/services-header.jpg');">
          <div class="container position-relative d-flex flex-column align-items-center">

            <h2>Jobs</h2>
            <ol>
              <li><a href="index.html">Home</a></li>
              <li>Jobs</li>
            </ol>

          </div>
        </div><!-- End Breadcrumbs -->


        <!-- ======= Our Services Section ======= -->
        <section id="services-list" class="services-list">
          <div class="container" data-aos="fade-up">

            <div class="section-header">
              <h2>Make an Appoinment</h2>

            </div>

            <div class="row gy-5">
              <form action="IndexServlet?action=createCustomerIndex" method="Post" class="row g-3">
                <div class="col-md-6">
                  <label for="inputFname" class="form-label">Consultent Id</label>
                  <input type="text" class="form-control" id="ConsultentID" name="conName" disabled
                    value="<c:out value='${name}' />">
                  <input type="text" class="form-control" id="ConsultentID" name="ConsultentID" hidden
                    value="<c:out value='${ConsID}' />">
                </div>
                <div class="col-md-6">
                  <label for="inputLname" class="form-label">Country</label>
                  <input type="text" class="form-control" name="Country" disabled value="<c:out value='${Country}' />">
                </div>
                <div class="col-md-6">
                  <label for="inputFname" class="form-label">First Name</label>
                  <input type="text" class="form-control" name="inputFname">
                </div>
                <div class="col-md-6">
                  <label for="inputLname" class="form-label">Last Name</label>
                  <input type="text" class="form-control" name="inputLname">
                </div>
                <div class="col-md-6">
                  <label for="inputMnumber" class="form-label">Mobile Number</label>
                  <input type="text" class="form-control" name="inputMnumber">
                </div>
                <div class="col-md-6">
                  <label for="inputEmail" class="form-label">E-Mail</label>
                  <input type="email" class="form-control" name="inputEmail">
                </div>
                <div class="col-md-6">
                  <label for="inputState" class="form-label">Job</label>
                  <input type="text" class="form-control" name="jtype">
                </div>
                <div class="col-md-6">
                  <label for="inputState" class="form-label">Date</label>
                  <input type="date" class="form-control" name="date">
                </div>

                <div class="col-12">
                  <button type="submit" class="btn btn-primary">Make a Appoinment</button>
                </div>
              </form>

      </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">

    <div class="footer-content">
      <div class="container">
        <div class="row gy-4">
          <div class="col-lg-5 col-md-12 footer-info">
            <a href="index.html" class="logo d-flex align-items-center">
              <span>The Jobs</span>
            </a>
            <p>We, The Jobs, are the leading consulting company in the country for jobs abroad. We offer you free consulting for your jobs, step by step.</p>
            <div class="social-links d-flex  mt-3">
              <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
              <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
              <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
              <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
            </div>
          </div>

          <div class="col-lg-2 col-6 footer-links">
            <h4>Useful Links</h4>
            <ul>
              <li><i class="bi bi-dash"></i> <a href="#">Home</a></li>
              <li><i class="bi bi-dash"></i> <a href="#">About us</a></li>
              <li><i class="bi bi-dash"></i> <a href="#">Services</a></li>
              <li><i class="bi bi-dash"></i> <a href="#">Login</a></li>
            
            </ul>
          </div>

          <div class="col-lg-3 col-md-12 footer-contact text-center text-md-start">
            <h4>Contact Us</h4>
            <p>
              No. 25/2 <br>
              Main street, Colombo 10<br>
              Sri lanka <br><br>
              <strong>Phone:</strong> +94 716538943<br>
              <strong>Email:</strong> info@thejobs.com<br>
            </p>

          </div>

        </div>
      </div>
    </div>

    <div class="footer-legal">
      <div class="container">
        <div class="copyright">
          &copy; Copyright <strong><span>The Jobs</span></strong>. All Rights Reserved
        </div>
        </div>
      </div>
    </div>
  </footer><!-- End Footer --><!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>