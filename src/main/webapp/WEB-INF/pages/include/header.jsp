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
                                 <img src="<%= request.getContextPath()%>/resources/images/user/${session.thumnail}" alt="user-image" class="img-circle img-inline">
                                <span>${session.username}<i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul class="dropdown-menu profile animated fadeIn">
                                <li><a href="" data-toggle='modal' data-target='#profile' > <i class="fa fa-user"></i>Profile </a> </li>
                                <li class="last"><a href="<%= request.getContextPath()%>/logout"><i class="fa fa-lock"></i>Logout</a></li>
                            </ul>
                        </li>
                    </ul>			
                </div>
				<!-- -------PROFILE RIGHT END----------->
				
            </div>
			<!--End Login Section-->
        </div>
        
      <!-- Modal for profile -->
	   <div class="modal fade" id="profile" role="dialog">
	    <div class="modal-dialog modal-md">
	      <div class="modal-content">
		        <div class="modal-header" style="background-color: #4ee499; border-bottom: 7px solid rgba(31, 181, 172, 1.0);">
		          <h4 class="modal-title">View</h4>
		        </div>
		        
		        <div class="modal-body">
		        	<div class="row">
		        		<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
					          Id: <span>${session.id}</span><br/>
					          User Name: <span>${session.username}</span><br/>
					          Email: <span>${session.email}</span><br/>
					          Phone: <span>${session.phone}</span><br/>
					          Gender: <span>${session.gender}</span><br/>
					          Date of Birth: <span>${session.dob}</span><br/>
					          Status: <span>${session.status}</span><br/>
					          Approved Date: <span>${session.approvedDate}</span><br/>
					          Create Date: <span>${session.createdDate}</span><br/>
					          Update Date: <span>${session.updatedDate}</span><br/>
		        		</div>
		        		
		        		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
		        			<img alt='profile' src='${pageContext.request.contextPath}/resources/images/user/${session.thumnail}' class='img-responsive'>
		        		</div>
		        	</div>
		        
		        
		         
		        </div>
		        
		        <div class="modal-footer">
		          <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		        </div>
	      </div>
	    </div>
	  </div>  
       