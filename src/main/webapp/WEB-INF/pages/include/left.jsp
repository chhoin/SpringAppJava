<div class="page-sidebar ">
                <!-- MAIN MENU Sibar - START -->
                <div class="page-sidebar-wrapper" id="main-menu-wrapper"> 
                
                    <!------------ USER PROFILE INFO ABOVE LEFT MENU -------------->
                    <div class="profile-info row">
                        <div class="profile-image col-md-4 col-sm-4 col-xs-4">
                            <a href="#">
                                <img src="<%= request.getContextPath()%>/resources/images/user/${session.thumnail}" class='img-responsive img-circle'>
                            </a>
                        </div>
                        <div class="profile-details col-md-8 col-sm-8 col-xs-8">
                            <h3>
                                <a href="#">${session.username}</a>
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