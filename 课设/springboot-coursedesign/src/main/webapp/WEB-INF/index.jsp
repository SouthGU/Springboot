<%--
  Created by IntelliJ IDEA.
  User: lueshen
  Date: 2019/11/21
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Home</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta tag Keywords -->

    <!-- Custom-Files -->
    <link rel="stylesheet" href="index/bootstrap.css">
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="index/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link href="index/font-awesome.min.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //Custom-Files -->

    <!-- Web-Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <!-- //Web-Fonts -->
</head>

<body>
<!-- header -->
<header id="home">
    <div class="container">
        <div class="header d-lg-flex justify-content-between align-items-center py-sm-3 py-2 px-sm-2 px-1">
            <!-- logo -->
            <div id="logo">
                <h1><a href="index.html">Freight</a></h1>
            </div>
            <!-- //logo -->
            <!-- nav -->
            <div class="nav_w3ls ml-lg-5">
                <nav>
                    <label for="drop" class="toggle">Menu</label>
                    <input type="checkbox" id="drop" />
                    <ul class="menu">
                        <li><a href="index.html">用户</a></li>
                        <li><a href="/login">快递员</a></li>
                        <li><a href="/adminlogin1">系统管理员</a></li>
                        <li>
                            <!-- First Tier Drop Down -->
                            <label for="drop-2" class="toggle toogle-2"><span class="fa fa-angle-down" aria-hidden="true"></span>
                            </label>
                            <input type="checkbox" id="drop-2" />
                            <ul>
                                <li><a href="#blog" class="drop-text">Blog</a></li>
                                <li><a href="single.html" class="drop-text">Single Page</a></li>
                                <li><a href="#services" class="drop-text">Services</a></li>
                                <li><a href="#more" class="drop-text">More</a></li>
                            </ul>
                        </li>
                        <li class="ml-xl-5 ml-lg-2 mt-lg-0 mt-sm-4 mt-3">
                            <a href="login.html" class="reqe-button text-uppercase">Login</a>
                            <a href="register.html" class="reqe-button text-uppercase">Register</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <!-- //nav -->
        </div>
    </div>
</header>
<!-- //header -->

<!-- banner -->
<section class="banner">
    <!-- banner text -->
    <div class="container">
        <div class="banner_text_wthree_pvt">
            <h3 class="home-banner-w3">World Wide <br>Transportation</h3>
            <p class="bnr-txt">Lorem ipsum dolor sit amet,Stet clita kasd gubergren, Lorem ipsum dolor sit
                amet,Stet clita kasd gubergren,
            </p>
            <form action="#" method="post" class="d-flex serching-styles-w3pvt">
                <input type="search" class="serach-input" placeholder="Enter Your Track Id" name="search" required>
                <button class="btn bg-theme button-w3" type="button">Track Now</button>
            </form>
        </div>
    </div>
    <!-- //banner text -->
    <!-- banner-bottom -->
    <div class="banner-bottom-w3ls">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-6">
                    <div class="bb-img">
                        <img src="index/a2.jpg" class="img-fluid img-thumbnail" alt="" />
                        <h3>caption goes here</h3>
                    </div>
                </div>
                <div class="col-sm-4 col-6">
                    <div class="bb-img">
                        <img src="index/a1.jpg" class="img-fluid img-thumbnail" alt="" />
                        <h3>caption goes here</h3>
                    </div>
                </div>
                <div class="col-sm-4 col-6 mx-auto mt-sm-0 mt-4">
                    <div class="bb-img">
                        <img src="index/a3.jpg" class="img-fluid img-thumbnail" alt="" />
                        <h3>caption goes here</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- //banner-bottom -->
</section>
<!-- //banner -->

<!-- about-->
<section class="single_grid_w3_main align-w3-abt" id="about">
    <div class="container">
        <div class="wthree_pvt_title text-center">
            <h4 class="w3pvt-title">What we Offer</h4>
            <p class="sub-title">Subheadings stand out because they are like mini titles. They make your post stand
                out and
                make it more readable.</p>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="abt-grid">
                    <div class="row">
                        <div class="col-3">
                            <div class="abt-icon">
                                <span class="fa fa-subway"></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="abt-txt">
                                <h4>takimata sanctus</h4>
                                <p>Lo sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 my-lg-0 my-4">
                <div class="abt-grid">
                    <div class="row">
                        <div class="col-3">
                            <div class="abt-icon">
                                <span class="fa fa-ship"></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="abt-txt">
                                <h4>takimata sanctus</h4>
                                <p>Lo sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="abt-grid">
                    <div class="row">
                        <div class="col-3">
                            <div class="abt-icon">
                                <span class="fa fa-plane"></span>
                            </div>
                        </div>
                        <div class="col-9">
                            <div class="abt-txt">
                                <h4>takimata sanctus</h4>
                                <p>Lo sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <a href="about.html" class="btn w3ls-btn">view more</a>
        </div>
    </div>
</section>
<!-- //about -->

<!-- services -->
<section class="bg-services position-relative align-w3" id="services">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="services-bg-color">
                    <div class="wthree_pvt_title mb-3">
                        <h4 class="w3pvt-title w3pvt-titl-sec text-wh">what we provide
                        </h4>
                        <span class="sub-title text-li">add your caption here</span>
                    </div>
                    <div class="row">
                        <div class="col-md-6 service-title my-4">
                            <h4 class="home-title text-theme">Sub heading</h4>
                            <p class="sec-4">Itaque earum rerum hic tenetur a sapiente delectusum hic
                                tenetur yua.
                            </p>
                        </div>
                        <div class="col-md-6 service-title my-md-4">
                            <h4 class="home-title text-theme">Sub heading</h4>
                            <p class="sec-4">Itaque earum rerum hic tenetur a sapiente delectusum hic
                                tenetur ap.
                            </p>
                        </div>
                        <div class="col-md-6 service-title mt-4">
                            <h4 class="home-title text-theme">Sub heading</h4>
                            <p class="sec-4">Itaque earum rerum hic tenetur a sapiente delectusum hic
                                tenetur ar.
                            </p>
                        </div>
                        <div class="col-md-6 service-title mt-4">
                            <h4 class="home-title text-theme">Sub heading</h4>
                            <p class="sec-4">Itaque earum rerum hic tenetur a sapiente delectusum hic
                                tenetur as.
                            </p>
                        </div>
                    </div>
                    <div class="d-flex justify-content-start">
                        <a href="about.html" class="btn w3ls-btn">view more</a>
                    </div>
                </div>

            </div>
            <div class="offset-lg-2"></div>
        </div>
    </div>
</section>
<!-- //services -->

<!-- portfolio -->
<section class="portfolio-wthree align-w3 py-5" id="portfolio">
    <div class="container py-xl-5 py-lg-3">
        <div class="wthree_pvt_title text-center">
            <h4 class="w3pvt-title">Portfolio
            </h4>
            <p class="sub-title">Subheadings stand out because they are like mini titles. They make your post stand
                out and
                make it more readable.</p>
        </div>
        <div>
            <ul class="demo row">
                <li class="col-lg-4">
                    <div class="img-grid">
                        <div class="Portfolio-grid1">
                            <a href="#gal1">
                                <img src="index/g1.jpg" alt=" " class="img-fluid" />
                            </a>
                        </div>
                        <div class="port-desc text-center">
                            <h6 class="main-title-w3pvt text-center">Some Description</h6>
                            <p> Lorem ipsum dolor sit amet,Stet clita kasd gubergren, sed diam voluptua. sed
                                diam
                                nonumy eirmod tempor invidunt ut.
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-lg-4">
                    <div class="img-grid">
                        <div class="Portfolio-grid1">
                            <a href="#gal2">
                                <img src="index/g2.jpg" alt=" " class="img-fluid" />
                            </a>
                        </div>
                        <div class="port-desc text-center">
                            <h6 class="main-title-w3pvt text-center">Some Description</h6>
                            <p> Lorem ipsum dolor sit amet,Stet clita kasd gubergren, sed diam voluptua. sed
                                diam
                                nonumy eirmod tempor invidunt ut.
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-lg-4">
                    <div class="img-grid">
                        <div class="Portfolio-grid1">
                            <a href="#gal3">
                                <img src="index/g3.jpg" alt=" " class="img-fluid" />
                            </a>
                        </div>
                        <div class="port-desc text-center">
                            <h6 class="main-title-w3pvt text-center">Some Description</h6>
                            <p> Lorem ipsum dolor sit amet,Stet clita kasd gubergren, sed diam voluptua. sed
                                diam
                                nonumy eirmod tempor invidunt ut.
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-lg-4">
                    <div class="img-grid">
                        <div class="Portfolio-grid1">
                            <a href="#gal4">
                                <img src="index/g4.jpg" alt=" " class="img-fluid" />
                            </a>
                        </div>
                        <div class="port-desc text-center">
                            <h6 class="main-title-w3pvt text-center">Some Description</h6>
                            <p> Lorem ipsum dolor sit amet,Stet clita kasd gubergren, sed diam voluptua. sed
                                diam
                                nonumy eirmod tempor invidunt ut.
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-lg-4">
                    <div class="img-grid">
                        <div class="Portfolio-grid1">
                            <a href="#gal5">
                                <img src="index/g5.jpg" alt=" " class="img-fluid" />
                            </a>
                        </div>
                        <div class="port-desc text-center">
                            <h6 class="main-title-w3pvt text-center">Some Description</h6>
                            <p> Lorem ipsum dolor sit amet,Stet clita kasd gubergren, sed diam voluptua. sed
                                diam
                                nonumy eirmod tempor invidunt ut.
                            </p>
                        </div>
                    </div>
                </li>
                <li class="col-lg-4">
                    <div class="img-grid">
                        <div class="Portfolio-grid1">
                            <a href="#gal6">
                                <img src="index/g6.jpg" alt=" " class="img-fluid" />
                            </a>
                        </div>
                        <div class="port-desc text-center">
                            <h6 class="main-title-w3pvt text-center">Some Description</h6>
                            <p> Lorem ipsum dolor sit amet,Stet clita kasd gubergren, sed diam voluptua. sed
                                diam
                                nonumy eirmod tempor invidunt ut.
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <!-- popup-->
        <div id="gal1" class="popup-effect animate">
            <div class="popup">
                <img src="index/g1.jpg" alt="Popup Image" class="img-fluid" />
                <p class="editContent mt-4">Nulla viverra pharetra se, eget pulvinar neque pharetra ac int. placerat placerat
                    dolor.</p>
                <a class="close" href="#gallery">&times;</a>
            </div>
        </div>
        <!-- //popup -->
        <!-- popup-->
        <div id="gal2" class="popup-effect animate">
            <div class="popup">
                <img src="index/g2.jpg" alt="Popup Image" class="img-fluid" />
                <p class="editContent mt-4">Nulla viverra pharetra se, eget pulvinar neque pharetra ac int. placerat placerat
                    dolor.</p>
                <a class="close" href="#gallery">&times;</a>
            </div>
        </div>
        <!-- //popup -->
        <!-- popup-->
        <div id="gal3" class="popup-effect animate">
            <div class="popup">
                <img src="index/g3.jpg" alt="Popup Image" class="img-fluid" />
                <p class="editContent mt-4">Nulla viverra pharetra se, eget pulvinar neque pharetra ac int. placerat placerat
                    dolor.</p>
                <a class="close" href="#gallery">&times;</a>
            </div>
        </div>
        <!-- //popup3 -->
        <!-- popup-->
        <div id="gal4" class="popup-effect animate">
            <div class="popup">
                <img src="index/g4.jpg" alt="Popup Image" class="img-fluid" />
                <p class="editContent mt-4">Nulla viverra pharetra se, eget pulvinar neque pharetra ac int. placerat placerat
                    dolor.</p>
                <a class="close" href="#gallery">&times;</a>
            </div>
        </div>
        <!-- //popup -->
        <!-- popup-->
        <div id="gal5" class="popup-effect animate">
            <div class="popup">
                <img src="index/g5.jpg" alt="Popup Image" class="img-fluid" />
                <p class="editContent mt-4">Nulla viverra pharetra se, eget pulvinar neque pharetra ac int. placerat placerat
                    dolor.</p>
                <a class="close" href="#gallery">&times;</a>
            </div>
        </div>
        <!-- //popup -->
        <!-- popup-->
        <div id="gal6" class="popup-effect animate">
            <div class="popup">
                <img src="index/g6.jpg" alt="Popup Image" class="img-fluid" />
                <p class="editContent mt-4">Nulla viverra pharetra se, eget pulvinar neque pharetra ac int. placerat placerat
                    dolor.</p>
                <a class="close" href="#gallery">&times;</a>
            </div>
        </div>
        <!-- //popup -->
    </div>
</section>
<!-- //portfolio -->

<!-- slide -->
<section class="wthree-slie-btm py-lg-5" id="more">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="slide-banner pl-0">
                </div>
            </div>
            <div class="col-lg-6 mt-lg-0 mt-4">
                <div class="container">
                    <div class="wthree_pvt_title">
                        <h4 class="w3pvt-title">Industry Solutions
                        </h4>
                        <span class="sub-title">add your caption here</span>
                    </div>
                    <div class="row flex-column">
                        <div class="abt-grid">
                            <div class="row">
                                <div class="col-3">
                                    <div class="abt-icon">
                                        <span class="fa fa-fighter-jet"></span>
                                    </div>
                                </div>
                                <div class="col-9">
                                    <div class="abt-txt ml-0">
                                        <h4>sanctus takimata </h4>
                                        <p>Lo sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="abt-grid mt-4 pt-lg-2">
                            <div class="row">
                                <div class="col-3">
                                    <div class="abt-icon">
                                        <span class="fa fa-truck"></span>
                                    </div>
                                </div>
                                <div class="col-9">
                                    <div class="abt-txt ml-0">
                                        <h4>takimata sanctus</h4>
                                        <p>Lo sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-start">
                        <a href="about.html" class="btn w3ls-btn">view more</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- //slide -->

<!-- blog -->
<section class="blog_w3ls align-w3" id="blog">
    <div class="container">
        <div class="wthree_pvt_title text-center">
            <h4 class="w3pvt-title">latest posts
            </h4>
            <p class="sub-title">Subheadings stand out because they are like mini titles. They make your post stand
                out and
                make it more readable.</p>
        </div>
        <div class="row space-sec">
            <!-- blog grid -->
            <div class="col-lg-4 col-md-6 mt-sm-0 mt-4">
                <div class="card">
                    <div class="card-header p-0 position-relative">
                        <a href="single.html">
                            <img class="card-img-bottom" src="index/g1.jpg" alt="Card image cap">
                            <span class="post-icon">blog post</span>
                        </a>
                    </div>
                    <div class="card-body">
                        <h5 class="blog-title card-title font-weight-bold">
                            <a href="single.html">Cras ultricies ligula sed.</a>
                        </h5>
                        <p>At vero eos et accusam et justo duo dolores et ea rebum. Lorem ipsum dolor sit
                            ametLorem ipsum dolor sit amet,sed diam nonumy.</p>
                        <a href="single.html" class="blog_link">Read more</a>
                    </div>
                </div>
            </div>
            <!-- //blog grid -->
            <!-- blog grid -->
            <div class="col-lg-4 col-md-6 mt-md-0  mt-4">
                <div class="card">
                    <div class="card-header p-0 position-relative">
                        <a href="single.html">
                            <img class="card-img-bottom" src="index/g2.jpg" alt="Card image cap">
                            <span class="post-icon">blog post</span>
                        </a>
                    </div>
                    <div class="card-body">
                        <h5 class="blog-title card-title font-weight-bold">
                            <a href="single.html">magna porta au blandita.</a>
                        </h5>
                        <p>At vero eos et accusam et justo duo dolores et ea rebum. Lorem ipsum dolor sit
                            ametLorem ipsum dolor sit amet,sed diam nonumy.</p>
                        <a href="single.html" class="blog_link">Read more</a>
                    </div>
                </div>
            </div>
            <!-- //blog grid -->
            <!-- blog grid -->
            <div class="col-lg-4 col-md-6 mt-lg-0 mt-4 mx-auto blog-end">
                <div class="card">
                    <div class="card-header p-0  position-relative">
                        <a href="single.html">
                            <img class="card-img-bottom" src="index/g3.jpg" alt="Card image cap">
                            <span class="post-icon">blog post</span>
                        </a>
                    </div>
                    <div class="card-body">
                        <h5 class="blog-title card-title font-weight-bold">
                            <a href="single.html">Cras ultricies ligula sed.</a>
                        </h5>
                        <p>At vero eos et accusam et justo duo dolores et ea rebum. Lorem ipsum dolor sit
                            ametLorem ipsum dolor sit amet,sed diam nonumy.</p>
                        <a href="single.html" class="blog_link">Read more</a>
                    </div>
                </div>
            </div>
            <!-- //blog grid -->
        </div>
    </div>
</section>
<!-- //blog -->

<!-- footer -->
<footer class="footer py-md-5 pt-md-3 pb-sm-5">
    <div class="container">
        <div class="row p-sm-4 px-3 py-3">
            <div class="col-lg-4 footer-top mt-md-0 mt-sm-5">
                <h2>
                    <a class="navbar-brand" href="index.html">
                        Freight
                    </a>
                </h2>
                <div class="fv3-contact mt-2">
                    <p>
                        <a href="mailto:example@email.com">info@example.com</a>
                    </p>
                </div>
                <div class="fv3-contact my-2">
                    <p>+456 123 7890</p>
                </div>
                <div class="fv3-contact">
                    <p>+90 nsequursu dsdesdc,
                        <br>xxx Street State 34789.</p>
                </div>
            </div>
            <div class="col-lg-2  col-md-6 mt-lg-0 mt-4">
                <div class="footerv2-w3ls">
                    <h3 class="mb-3 w3f_title">Navigation</h3>
                    <hr>
                    <ul class="list-w3pvtits">
                        <li>
                            <a href="index.html">
                                Home
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="about.html">
                                About Us
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="portfolio.html">
                                Portfolio
                            </a>
                        </li>
                        <li class="mb-2">
                            <a href="single.html">
                                Blog
                            </a>
                        </li>
                        <li>
                            <a href="contact.html">
                                Contact Us
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2  col-md-6 mt-lg-0 mt-4">
                <div class="footerv2-w3ls">
                    <h3 class="mb-3 w3f_title">Links</h3>
                    <hr>
                    <ul class="list-w3pvtits">
                        <li>
                            <a href="about.html">
                                Our Mission
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="single.html">
                                Latest posts
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="portfolio.html">
                                Explore
                            </a>
                        </li>
                        <li class="mb-2">
                            <a href="contact.html">
                                Find us
                            </a>
                        </li>
                        <li>
                            <a href="index.html">
                                Privacy Policy
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-6 mt-lg-0 mt-4">
                <div class="footerv2-w3ls">
                    <h3 class="mb-3 w3f_title">Links</h3>
                    <hr>
                    <ul class="list-w3pvtits">
                        <li>
                            <a href="single.html">
                                more
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="portfolio.html">
                                our work
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="about.html">
                                Explore
                            </a>
                        </li>
                        <li class="mb-2">
                            <a href="contact.html">
                                contact us
                            </a>
                        </li>
                        <li>
                            <a href="index.html">
                                references
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2  col-md-6 mt-lg-0 mt-4">
                <div class="footerv2-w3ls">
                    <h3 class="mb-3 w3f_title">Links</h3>
                    <hr>
                    <ul class="list-w3pvtits">
                        <li class="my-2">
                            <a href="portfolio.html">
                                Explore
                            </a>
                        </li>
                        <li>
                            <a href="about.html">
                                Our Mission
                            </a>
                        </li>
                        <li class="my-2">
                            <a href="single.html">
                                Latest posts
                            </a>
                        </li>

                        <li class="mb-2">
                            <a href="contact.html">
                                Find us
                            </a>
                        </li>
                        <li>
                            <a href="index.html">
                                Privacy Policy
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- //footer bottom -->
</footer>
<!-- //footer -->
<!-- copyright -->
<div class="cpy-right text-center bg-theme">
    <p class="text-wh">Copyright &copy; 2019.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
</div>
<!-- //copyright -->
<!-- move top icon -->
<a href="#home" class="move-top text-center">
    <span class="fa fa-level-up" aria-hidden="true"></span>
</a>
<!-- //move top icon -->

</body>

</html>