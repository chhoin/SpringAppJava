<?xml version="1.0" encoding="UTF-8"?>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> --%>
<%@ page isELIgnored="false"%>


<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description" />
        <meta content="" name="author" />

        <!-- CORE CSS FRAMEWORK - START -->
        <link href="${pageContext.request.contextPath}/assetAdmin/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/assetAdmin/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/assetAdmin/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/assetAdmin/css/animate.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/assetAdmin/plugins/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS FRAMEWORK - END -->

        <!-- CORE CSS TEMPLATE - START -->
        <link href="${pageContext.request.contextPath}/assetAdmin/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/assetAdmin/css/responsive.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS TEMPLATE - END -->

        <style type="text/css">

        </style>
   		 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assetAdmin/sweetalert/sweetalert.css">
	</head>
<body>
		<div class='page-topbar '>
			<!--Top Title on Menu-->
            <div class='logo-area'>

            </div>
			
			<!--Login Sextion-->
            <div class='quick-area'>
                <div class='pull-left'>
                    <ul class="info-menu left-links list-inline list-unstyled">
                        <li class="sidebar-toggle-wrap">
                            <a href="#" data-toggle="sidebar" class="sidebar_toggle">
                                <i class="fa fa-bars"></i>
                            </a>
						</li>
                    </ul>
                </div>
                <div class='pull-right'>
                    <ul class="info-menu right-links list-inline list-unstyled">
                        <li class="profile">
                            <a href="#" data-toggle="dropdown" class="toggle">
                                 <img src= alt="user-image" class="img-circle img-inline">
                                <span>
                                	
									<i class="fa fa-angle-down"></i>
								</span>
                            </a>
                            <ul class="dropdown-menu profile animated fadeIn">
                                <li><a href="/en/user/profile"> <i class="fa fa-user"></i>Profile </a> </li>
                                <li class="last"><a href="http://localhost:8000/logout"><i class="fa fa-lock"></i>Logout</a></li>
                            </ul>
                        </li>
                    </ul>			
                </div>
            </div>
			<!--End Login Section-->
        </div>
        <!-- END TOPBAR -->

        <!--///////////////////////////////////start menu///////////////////////////////////-->
        <!-- START CONTAINER -->
        <div class="page-container row-fluid">
            <!-- SIDEBAR - START -->
            <div class="page-sidebar ">
                <!-- MAIN MENU Sibar - START -->
                <div class="page-sidebar-wrapper" id="main-menu-wrapper"> 
                       <!-- USER INFO - START -->
                    <div class="profile-info row">
                        <div class="profile-image col-md-4 col-sm-4 col-xs-4">
                            <a href="#">
                                <img src= class='img-responsive img-circle'>
                            </a>
                        </div>
                        <div class="profile-details col-md-8 col-sm-8 col-xs-8">
                            <h3>
                                <a href="#"></a>
                                <!-- Available statuses: online, idle, busy, away and offline -->
                                <span class="profile-status online"></span>
                            </h3>
                        </div>

                    </div>
                    <!-- USER INFO - END -->
                    <ul class='wraplist'>	
                    	
                    
                        <!-- Dashboard -->
                        <li class=""> 
                            <a href="http://localhost:8000/admin">
                                <i class="fa fa-dashboard"></i>
                                <span class="title">Dashboard</span>
                            </a>
                        </li>
                        <!-- Status -->
                         <li class=""> <a href="javascript:"> <i class="fa fa-wrench"></i> <span class="title">Satus</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
                                <li class=""> <a href="http://localhost:8000/main/status.html"> <i class="fa fa-plus-square"></i> <span class="title">MainController Status</span></a> </li>
                                <li class=""> <a href="http://localhost:8000/json/status.html"> <i class="fa fa-plus-square"></i> <span class="title">JSONController Status</span></a> </li>
                            </ul>
                        </li>

    
                        <!-- USER -->
                        <li class=""> <a href="javascript:"> <i class="fa fa-user"></i> <span class="title">User</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
                                <li class=""> <a href="http://localhost:8000/en/user"> <i class="fa fa-plus-square"></i> <span class="title">MainController Users</span></a> </li>
                                <li class=""> <a href="http://localhost:8000/en/user"> <i class="fa fa-plus-square"></i> <span class="title">JSONController Users</span></a> </li>
                            </ul>
                        </li>

                    </ul>

                </div>
                <!-- MAIN MENU - END -->

				<!--End Count End User-->
            </div>
			
			
            <!--  SIDEBAR - END -->
            <!-- START CONTENT -->
            <section id="main-content" class=" ">
                <section class="wrapper" style='margin-top:30px;display:inline-block;width:100%;padding:15px 0 0 15px;'>
                    <div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>
                        <div class="page-title">
                            <div class="pull-left">
                            	                        
						    </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
					<div class="content-body">
						<section class="box ">
		        			<div class="content-body">
		              			<h1>Dashboard</h1>
		                                <p>Guest</p>  


		                    </div>
		        	</div>
    			</section>
					</div>
               </section>
            </section>
            <!-- END CONTENT --> 
		</div>
    	
	
	<!-- END CONTAINER -->
        <!-- LOAD FILES AT PAGE END FOR FASTER LOADING -->
        <!-- CORE JS FRAMEWORK - START --> 
        <script src="http://localhost:8000/assetAdmin/assets/js/jquery-1.11.2.min.js" type="text/javascript"></script> 
        <script src="http://localhost:8000/assetAdmin/assets/js/jquery.easing.min.js" type="text/javascript"></script> 
        <script src="http://localhost:8000/assetAdmin/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="http://localhost:8000/assetAdmin/assets/plugins/perfect-scrollbar/perfect-scrollbar.min.js" type="text/javascript"></script> 
        <script src="http://localhost:8000/assetAdmin/assets/plugins/viewport/viewportchecker.js" type="text/javascript"></script>  
        <!-- CORE JS FRAMEWORK - END -->

        <!-- CORE TEMPLATE JS - START -->
        <script src="http://localhost:8000/assetAdmin/assets/js/scripts.js" type="text/javascript"></script>
        <!-- END CORE TEMPLATE JS - END -->

        <script src="http://localhost:8000/assetAdmin/assets/js/bootpage.js"></script>
		<script src="http://localhost:8000/assetAdmin/assets/sweetalert/sweetalert.min.js"></script>
		<script type="text/javascript">
        
   
</script>
</body>
</html>
