<%@include file="../../include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Form</title>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description ????" />
        <meta content="" name="author ?????" />

        <!---------------START CSS INCLUDE-------------->
        <%@include file="../../include/css_header.jsp" %>
        <!---------------END CSS INCLUDE-------------->
		 
		 <!-- OTHER CSS INCLUDE -->
		 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/assetAdmin/sweetalert2/sweetalert2.min.css"/>
		 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/assetAdmin/jasny-bootstrap/css/jasny-bootstrap.min.css">
		 
		 <!-- OTHER CSS INCLUDE END -->
		
        <style type="text/css">
        
        </style>	
</head>
<body>
		<!------------------ START TOOLBAR ------------------>
		<%@include file="../../include/header.jsp" %>
        <!-- -------------END TOPBAR ---------------------->

		
        <!--///////////////////////////////////start menu///////////////////////////////////-->
        <!-- START CONTAINER fluid-->
        <div class="page-container row-fluid">
        
            <!---------------START LEFT BAR-------------->
            <%@include file="../../include/left.jsp" %>
			<!---------------END LEFT BAR-------------->
            
            <!-- START CONTENT -->
            <section id="main-content" class=" ">
                <section class="wrapper" style='margin-top:30px;display:inline-block;width:100%;padding:15px 0 0 15px;'>
					<br/>
                    <div class="clearfix"></div>
					<div class="content-body">
						<section class="box ">
								<header class="panel_header">
									<h2 class="title pull-left">Form </h2>
								</header>
						
							<br/>
							<br/>
						
						  <div class="row" id="content-body">
						  	<!---------------START FORM-------------->
							<form  class="form-horizontal" action="<%= request.getContextPath()%>/admin/user/store" method="post" role="form" id="myform">
								<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
								
									<div class="form-group">
										<label class="col-sm-3 control-label">User Name</label>
										<div class="col-sm-9">
											<input type="text" name="username" id="username" value="" class="form-control" placeholder="User Name" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Email</label>
										<div class="col-sm-9">
											<input type="email" name="email" id="email" value="" class="form-control" placeholder="Email" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Password</label>
										<div class="col-sm-9">
											<input type="password" name="password" id="password" value="" class="form-control" placeholder="password" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Confirm Password</label>
										<div class="col-sm-9">
											<input type="password" name=""confirm"" id="confirm" value="" class="form-control" placeholder="Confirm Password" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Phone</label>
										<div class="col-sm-9">
											<input type="number" name="phone" id="phone" value="" class="form-control" placeholder="phone" >
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Gender</label>
										<div class="col-sm-9">
											<label class="radio-inline"><input type="radio" name="gender" value="MALE" checked>Male</label>
											<label class="radio-inline"><input type="radio" name="gender" value="FEMALE">Female</label>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Date Of Birth</label>
										<div class="col-sm-9">
											<input type="date" name="dob" id="dob" value="" class="form-control" placeholder="dob" >
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Action</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
											<button type="submit" class="btn btn-success" id="btnSave">Save</button>
											<button type="button" class="btn btn-warning"​ onclick="clearForm()">Clear</button>
											<a href="<%= request.getContextPath()%>/admin/user/index" type="button" class="btn btn-danger">Back</a>
										</div>
									</div>
								
								</div>
								
								<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				        			<div class="fileinput fileinput-new" data-provides="fileinput">
										  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
										    	<img data-src="holder.js/100%x100%" alt="">
										  </div>
									  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
									  <div>
										    <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="..."></span>
										    <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
									  </div>
									</div>
				        			
				        		</div>
							</form>
							<!---------------END FORM-------------->
							
						  </div><!-- /row -->
						 </section>
  
					</div>
                </section>
            </section>
            <!-- END CONTENT --> 
		</div>
		<!-- END CONTAINER fluid-->
		
		
    	
		<!------------------ START TOOLBAR ------------------>
		<%@include file="../../include/js_footer.jsp" %>
        <!-- -------------END TOPBAR ---------------------->
		    
		<!-- OTHER JS INCLUDE -->
	 	<script  src="<%= request.getContextPath()%>/resources/assetAdmin/js/bootpage.js" type="text/javascript"></script>
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/sweetalert2/sweetalert2.min.js" type="text/javascript"></script>
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/jasny-bootstrap/js/jasny-bootstrap.min.js" type="text/javascript"></script>
		
		<!-- OTHER JS INCLUDE END-->
		
		<script type="text/javascript">
			function clearForm(){
				$('#txtName').val('');
				$('#txtDescription').val('');
			}
		</script>
</body>
</html>
