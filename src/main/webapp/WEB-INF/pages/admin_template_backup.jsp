<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/html; charset=utf-8" session="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
		<title>1111</title>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description ????" />
        <meta content="" name="author ?????" />

         <!-- CORE CSS FRAMEWORK - START -->
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/css/animate.min.css" rel="stylesheet" type="text/css"/>
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/plugins/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" type="text/css"/>
		 <!-- CORE CSS FRAMEWORK - END -->
		 
		 <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START --> 
        <link href="<%= request.getContextPath()%>/resources/assetAdmin/plugins/icheck/skins/minimal/white.css" rel="stylesheet" type="text/css" media="screen"/>
        <link href="<%= request.getContextPath()%>/resources/assetAdmin/plugins/jvectormap/jquery-jvectormap-2.0.1.css" rel="stylesheet" type="text/css" media="screen"/>       
         <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 
		
		 <!-- CORE CSS TEMPLATE - START -->
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/css/style.css" rel="stylesheet" type="text/css"/>
		 <link href="<%= request.getContextPath()%>/resources/assetAdmin/css/responsive.css" rel="stylesheet" type="text/css"/>
		 <!-- CORE CSS TEMPLATE - END -->
		 
		 <!-- OTHER CSS INCLUDE -->
		 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/assetAdmin/sweetalert2/sweetalert2.min.css"/>
		 <!-- OTHER CSS INCLUDE END -->
		
        <style type="text/css">
        
        </style>	
</head>
<body>
		<!------------------ START TOOLBAR ------------------>
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
						<!-------START MESSSAGE-------->
                        <li class="">
                            <a href="#" data-toggle="dropdown" class="toggle">
                                <i class="fa fa-envelope"></i>
                                <span class="badge badge-primary">7</span>
                            </a>
                            <ul class="dropdown-menu messages animated fadeIn">

                                <li class="list">

                                    <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                                        <li class="unread status-available">
                                            <a href="javascript:;">
                                                <div class="user-img"><img src="" alt="user-image" class="img-circle img-inline"></div>
                                                <div>
                                                    <span class="name">
                                                        <strong>Clarine Vassar</strong>
                                                        <span class="time small">- 15 mins ago</span>
                                                        <span class="profile-status available pull-right"></span>
                                                    </span>
                                                    <span class="desc small">Sometimes it takes a lifetime to win a battle. </span>
                                                </div>
                                            </a>
                                        </li>
                                        <li class=" status-away">
                                            <a href="javascript:;">
                                                <div class="user-img"><img src="" alt="user-image" class="img-circle img-inline"></div>
                                                <div>
                                                    <span class="name">
                                                        <strong>Brooks Latshaw</strong>
                                                        <span class="time small">- 45 mins ago</span>
                                                        <span class="profile-status away pull-right"></span>
                                                    </span>
                                                    <span class="desc small">Sometimes it takes a lifetime to win a battle.</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li class=" status-busy">
                                            <a href="javascript:;">
                                                <div class="user-img"><img src="" alt="user-image" class="img-circle img-inline"></div>
                                                <div>
                                                    <span class="name">
                                                        <strong>Clementina Brodeur</strong>
                                                        <span class="time small">- 1 hour ago</span>
                                                        <span class="profile-status busy pull-right"></span>
                                                    </span>
                                                    <span class="desc small">Sometimes it takes a lifetime to win a battle.</span>
                                                </div>
                                            </a>
                                        </li>
                                      
                                    </ul>

                                </li>

                                <li class="external">
                                    <a href="javascript:;">
                                        <span>Read All Messages</span>
                                    </a>
                                </li>
								
                            </ul>
                        </li>
						<!-------END MESSSAGE-------->
						
						
						<!-------START RING MESSAGE-------->
                        <li class="">
                            <a href="#" data-toggle="dropdown" class="toggle">
                                <i class="fa fa-bell"></i>
                                <span class="badge badge-orange">3</span>
                            </a>
                            <ul class="dropdown-menu notifications animated fadeIn">
                                <li class="total">
                                    <span class="small">
                                        You have <strong>3</strong> new notifications.
                                        <a href="javascript:;" class="pull-right">Mark all as Read</a>
                                    </span>
                                </li>
                                <li class="list">

                                    <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                                        <li class="unread available"> <!-- available: success, warning, info, error -->
                                            <a href="javascript:;">
                                                <div class="notice-icon"> <i class="fa fa-check"></i></div>
                                                <div>
                                                    <span class="name">
                                                        <strong>Server needs to reboot</strong>
                                                        <span class="time small">15 mins ago</span>
                                                    </span>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="unread away"> <!-- available: success, warning, info, error -->
                                            <a href="javascript:;">
                                                <div class="notice-icon"><i class="fa fa-envelope"></i></div>
                                                <div>
                                                    <span class="name">
                                                        <strong>45 new messages</strong>
                                                        <span class="time small">45 mins ago</span>
                                                    </span>
                                                </div>
                                            </a>
                                        </li>
                                        <li class=" busy"> <!-- available: success, warning, info, error -->
                                            <a href="javascript:;">
                                                <div class="notice-icon"><i class="fa fa-times"></i></div>
                                                <div>
                                                    <span class="name">
                                                        <strong>Server IP Blocked</strong>
                                                        <span class="time small">1 hour ago</span>
                                                    </span>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>

                                </li>

                                <li class="external">
                                    <a href="javascript:;">
                                        <span>Read All Notifications</span>
                                    </a>
                                </li>
								
                            </ul>
                        </li>
						<!-------END RING MESSAGE-------->
                    </ul>
                </div>
				<!-- -------PROFILE RIGHT ----------->
                <div class='pull-right'>
                    <ul class="info-menu right-links list-inline list-unstyled">
                        <li class="profile">
                            <a href="#" data-toggle="dropdown" class="toggle">
                                 <img src="<%= request.getContextPath()%>/resources/images/user/default.png" alt="user-image" class="img-circle img-inline">
                                <span>
                                	Admin
									<i class="fa fa-angle-down"></i>
								</span>
                            </a>
                            <ul class="dropdown-menu profile animated fadeIn">
                                <li><a href="/en/user/profile"> <i class="fa fa-user"></i>Profile </a> </li>
                                <li class="last"><a href="<%= request.getContextPath()%>/logout"><i class="fa fa-lock"></i>Logout</a></li>
                            </ul>
                        </li>
                    </ul>			
                </div>
				<!-- -------PROFILE RIGHT END----------->
				
            </div>
			<!--End Login Section-->
        </div>
        <!-- -------------END TOPBAR ---------------------->

		
        <!--///////////////////////////////////start menu///////////////////////////////////-->
        <!-- START CONTAINER fluid-->
        <div class="page-container row-fluid">
            <!-- SIDEBAR - START -->
            <div class="page-sidebar ">
                <!-- MAIN MENU Sibar - START -->
                <div class="page-sidebar-wrapper" id="main-menu-wrapper"> 
                
                    <!------------ USER PROFILE INFO ABOVE LEFT MENU -------------->
                    <div class="profile-info row">
                        <div class="profile-image col-md-4 col-sm-4 col-xs-4">
                            <a href="#">
                                <img src="<%= request.getContextPath()%>/resources/images/user/default.png" class='img-responsive img-circle'>
                            </a>
                        </div>
                        <div class="profile-details col-md-8 col-sm-8 col-xs-8">
                            <h3>
                                <a href="#">Admin</a>
                                <!-- Available statuses: online, idle, busy, away and offline -->
                                <span class="profile-status online"></span>
                            </h3>
                        </div>

                    </div>
                   <!------------ USER PROFILE INFO ABOVE LEFT MENU END-------------->
                   
				   
				   <!------------ START LEFT MENU -------------->
                    <ul class='wraplist'>	
                    	                    
                        <li class=""> 
                            <a href="<%= request.getContextPath()%>/admin">
                                <i class="fa fa-dashboard"></i>
                                <span class="title">Dashboard</span>
                            </a>
                        </li>
                        <li class=""> <a href="javascript:;"> <i class="fa fa-user"></i> <span class="title">User Management</span> <span class="arrow "></span> </a>
                            <ul class="sub-menu">
								 <li class=""> <a href="<%= request.getContextPath()%>/admin/user/index"> <i class="fa fa-plus-square"></i> <span class="title">Users</span></a> </li>
                            </ul>
                        </li>
                        
                    </ul>
					 <!------------ END LEFT MENU -------------->

                </div>
                <!-- MAIN MENU - END -->

            </div>
			<!--  SIDEBAR - END -->
			
            
            <!-- START CONTENT -->
            <section id="main-content" class=" ">
                <section class="wrapper" style='margin-top:30px;display:inline-block;width:100%;padding:15px 0 0 15px;'>
					<br/>
                    <div class="clearfix"></div>
					<div class="content-body">
						<section class="box ">
								<header class="panel_header">
									<h2 class="title pull-left">Dashboad | Status</h2>
								</header>
						
							<br/>
							<br/>
						
						  <div class="row" id="content-body">
								
								<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" style="padding-left: 50px">
									<a href="/en/status/create" class="btn btn-success">Add Status</a>
								</div>
								
								<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
									<div class="form-group">
									  <select class="form-control" id="txtItem" onchange="page_load()">
										<option>5</option>
										<option>10</option>
										<option>20</option>
										<option>30</option>
										<option>40</option>
										<option>50</option>
										<option>100</option>
									  </select>
									</div>
								</div>
						  
								<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
									<form method="" action="" role="search">
											<div class="form-group">
												<div class="input-group col-sm-12 col-xs-12">
													<input type="text" name="txtSearch" id="txtSearch" class="form-control" placeholder="Search title">
													<div class="input-group-btn">
														<button type="button" class="btn btn-default" id="btnSearch" onclick="btnSearch_click()"><i><span class="glyphicon glyphicon-search"></i></button>
													</div><!-- /itnput-group-btn -->
												</div>	<!-- /input-group -->			
											</div><!-- /form-group -->
									</form>
								</div>
						  
						 
							<div class="col-xs-12">
								
								<div class="table-responsive">
									<table class="table table-border">
										<thead>
											<tr>
												<th>ID</th>
												<th>Title</th>
												<th>Status</th>
												<th>Author</th>
												<th>Created</th>
												<th>Updated</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody id="tbody">

										</tbody>
									</table>
									<div class="text-center" id="pagination"></div>
								</div><!-- /table-responsive -->
							</div><!-- /col-xs-12 -->
							
							
						  </div><!-- /row -->
						 </section>
  
					</div>
                </section>
            </section>
            <!-- END CONTENT --> 
		</div>
		<!-- END CONTAINER fluid-->
    	
	
		
       	<!-- CORE JS FRAMEWORK - START --> 
		<script src="<%= request.getContextPath()%>/resources/assetAdmin/js/jquery-1.11.2.min.js" type="text/javascript"></script> 
		<script src="<%= request.getContextPath()%>/resources/assetAdmin/js/jquery.easing.min.js" type="text/javascript"></script> 
		<script src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script> 
		<script src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/perfect-scrollbar/perfect-scrollbar.min.js" type="text/javascript"></script> 
		<script src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/viewport/viewportchecker.js" type="text/javascript"></script>  
		<!-- CORE JS FRAMEWORK - END -->
		
		<!-- CORE TEMPLATE JS - START -->
		<script src="<%= request.getContextPath()%>/resources/assetAdmin/js/scripts.js" type="text/javascript"></script>
		<!-- END CORE TEMPLATE JS - END -->
                
		<!-- OTHER JS INCLUDE -->
	 	<script  src="<%= request.getContextPath()%>/resources/assetAdmin/js/bootpage.js" type="text/javascript"></script>
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/sweetalert2/sweetalert2.min.js" type="text/javascript"></script>
		<!-- OTHER JS INCLUDE END-->
		
		<script type="text/javascript">
		
		</script>
</body>
</html>
