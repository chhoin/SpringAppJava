<%@include file="../../../include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Status Main</title>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description ????" />
        <meta content="" name="author ?????" />

        <!---------------START CSS INCLUDE-------------->
        <%@include file="../../../include/css_header.jsp" %>
        <!---------------END CSS INCLUDE-------------->
		 
		 <!-- OTHER CSS INCLUDE -->
		 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assetAdmin/sweetalert2/sweetalert2.min.css"/>
		 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assetAdmin/alertify/css/alertify.min.css">
		 <!-- OTHER CSS INCLUDE END -->
		
        <style type="text/css">
        
        </style>	
</head>
<body>
		<!------------------ START TOOLBAR ------------------>
		<%@include file="../../../include/header.jsp" %>
        <!-- -------------END TOPBAR ---------------------->

		
        <!--///////////////////////////////////start menu///////////////////////////////////-->
        <!-- START CONTAINER fluid-->
        <div class="page-container row-fluid">
        
            <!---------------START LEFT BAR-------------->
            <%@include file="../../../include/left.jsp" %>
			<!---------------END LEFT BAR-------------->
            
            <!-- START CONTENT -->
            <section id="main-content" class=" ">
                <section class="wrapper" style='margin-top:30px;display:inline-block;width:100%;padding:15px 0 0 15px;'>
					<br/>
                    <div class="clearfix"></div>
					<div class="content-body">
						<section class="box ">
								<header class="panel_header">
									<h2 class="title pull-left">Dashboad | Statu Main</h2>
								</header>
						
							<br/>
							<br/>
						
						  <div class="row" id="content-body">
								
								<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" style="padding-left: 50px">
									<a href="${pageContext.request.contextPath}/admin/user/create" class="btn btn-success">Add Status</a>
								</div>
							
								<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
									<form method="" action="" role="search">
											<div class="form-group">
												<div class="input-group col-sm-12 col-xs-12">
													<input type="text" name="txtSearch" id="search" onkeyup="searchUser()" class="form-control" placeholder="Search UserName Email and Phone">
													<div class="input-group-btn">
														<button type="button" class="btn btn-default"  id="btnSearch" onclick="searchUser()"><i><span class="glyphicon glyphicon-search"></i></button>
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
												<th width="10px">Profile</th>
												<th>Name</th>
												<th>Email</th>
												<th>Phone</th>
												<th>Gender</th>
												<th>Status</th>
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
		
	  <!-- Modal -->
	   <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog modal-md">
	      <div class="modal-content">
		        <div class="modal-header" style="background-color: #4ee499; border-bottom: 7px solid rgba(31, 181, 172, 1.0);">
		          <h4 class="modal-title">View</h4>
		        </div>
		        
		        <div class="modal-body">
		        	<div class="row">
		        		<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
					          Id: <span id="viewId"></span><br/>
					          User Name: <span id="viewName"></span><br/>
					          Email: <span id="viewEmail"></span><br/>
					          Phone: <span id="viewPhone"></span><br/>
					          Gender: <span id="viewGender"></span><br/>
					          Date of Birth: <span id="viewDob"></span><br/>
					          Status: <span id="viewStatus"></span><br/>
					          Approved Date: <span id="viewApprove"></span><br/>
					          Create Date: <span id="viewCreate"></span><br/>
					          Update Date: <span id="viewUpdate"></span><br/>
		        		</div>
		        		
		        		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
		        			<span id="viewProfile"></span>
		        		</div>
		        	</div>
		        
		        
		         
		        </div>
		        
		        <div class="modal-footer">
		          <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		        </div>
	      </div>
	    </div>
	  </div>
		
		
    	
		<!------------------ START TOOLBAR ------------------>
		<%@include file="../../../include/js_footer.jsp" %>
        <!-- -------------END TOPBAR ---------------------->
		    
		<!-- OTHER JS INCLUDE -->
	 	<script  src="${pageContext.request.contextPath}/resources/assetAdmin/js/bootpage.js" type="text/javascript"></script>
		<script  src="${pageContext.request.contextPath}/resources/assetAdmin/sweetalert2/sweetalert2.min.js" type="text/javascript"></script>
		<script  src="${pageContext.request.contextPath}/resources/assetAdmin/alertify/js/alertify.min.js" type="text/javascript"></script>
		<!-- OTHER JS INCLUDE END-->
		
		<script type="text/javascript">
		

		</script>
</body>
</html>
