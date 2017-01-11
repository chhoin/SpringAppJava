	<div class="page-sidebar-wrapper" id="main-menu-wrapper"> 
	              <!-- USER INFO - START -->
	           <div class="profile-info row">
	               <div class="profile-image col-md-4 col-sm-4 col-xs-4">
	                   <a href="#">
	                       <img src="#" class='img-responsive img-circle'>
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
	                   <a href="<%= request.getContextPath()%>">
	                       <i class="fa fa-dashboard"></i>
	                       <span class="title">Dashboard</span>
	                   </a>
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