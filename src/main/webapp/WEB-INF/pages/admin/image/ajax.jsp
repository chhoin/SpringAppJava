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
									<h2 class="title pull-left">Ajax Upload Image</h2>
								</header>
						
							<br/>
							<br/>
						
						  <div class="row" id="content-body">
						  	
						  	<!---------------START FORM-------------->
							<form  class="form-horizontal"  role="form" id="myform" enctype="multipart/form-data">
								
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									<div class="form-group">
										<label class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Image</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
											<!-- jasny-bootstrap -->
											<div class="fileinput fileinput-new" data-provides="fileinput">
											  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
												  	<img data-src="holder.js/100%x100%" alt="">
												  </div>
											  <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
											  <div>
												    <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span>
												    <span class="fileinput-exists">Change</span><input type="file" name="image"></span>
												    <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
											  </div>
											</div>
											
										</div>
									</div>
								
									<div class="form-group">
										<label class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Action</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
											<input type="button" id="btnSave" value="Add" class="btn btn-success" />
										</div>
									</div>
								
								</div>
								
								<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
									<h3>Result:</h3>${image }
									<img src="<%= request.getContextPath()%>/resources/images/user/${image }" class="img-rounded" alt="" width="250" height="180"> 
				        			
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
		
		<!-- Jquery Validator --> 
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script> 
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
		<!-- Jquery Validator END --> 
		
		<script type="text/javascript">
		$(document).ready(function(){
			$('#btnSave').click(function(){
					 $.ajax({
				        url 		: "${pageContext.request.contextPath}/admin/upload",
				        method		: "POST",
			 			data		: $('#myform').serialize(),
			 			//dataType	: "json",
				        success 	: function(data) {
							           	if(data.STATUS == true){
							           		swal("Status Was created", "You clicked the button!", "success");
							           	}
			           },
			           error 		: function(data){
										swal(
										  'Oops...',
										  'Something went wrong!',
										  'error'
										);
			           					console.log("check controller" + JSON.stringify(data));
			           }
			       });	 
			});
		});
		</script>
</body>
</html>
