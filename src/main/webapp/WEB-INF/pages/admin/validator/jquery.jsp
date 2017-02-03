<%@include file="../../include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Sever</title>
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
									<h2 class="title pull-left">Server Validator </h2>
								</header>
							<br/>
							<br/>
							<div class="col-xs-12">
									<p class="text-center">${message}</p>
							</div>
						
						  <div class="row" id="content-body">
							<div class="col-xs-12">
							
								<form:form id="myForm"  modelAttribute="student" class="form-horizontal" action="${pageContext.request.contextPath}/admin/validator/server" method="post" enctype="multipart/form-data">
							
									<div class="form-group">
										<label class="col-sm-3 control-label">name</label>
										<div class="col-sm-9">
											<form:input path="name" class="form-control" id="name" placeholder="name"/>
											<form:errors path="name" cssStyle="color: #ff0000;"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">email</label>
										<div class="col-sm-9">
											<form:input path="email" id="email" class="form-control" placeholder="email" />
											<form:errors path="email" cssStyle="color: #ff0000;" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">phone</label>
										<div class="col-sm-9">
											<form:input path="phone" id="phone"  class="form-control" placeholder="phone, number" />
											<form:errors path="phone" cssStyle="color: #ff0000;"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">url</label>
										<div class="col-sm-9">
											<form:input path="url"  id="url" class="form-control" placeholder="url, not null" />
											<form:errors path="url" cssStyle="color: #ff0000;"/>
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Action</label>
										<div class="col-sm-9">
											<input type="button" value="Test" id="btnTest" class="btn btn-primary"/>
										</div>
									</div>
									
							</form:form>
							
								
							</div><!-- /col-xs-12 -->
							
							
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
		<!-- OTHER JS INCLUDE END-->
		
		<!-- Jquery Validator --> 
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script> 
		<script  src="<%= request.getContextPath()%>/resources/assetAdmin/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
		<!-- Jquery Validator END --> 
		
		<script type="text/javascript">
		$(document).ready(function(){
			$('#btnTest').click(function(){
				if($("#myForm").valid() ){	
					
					alert("Test Success");
				}
			});
		});
		
		myValidate();
		function myValidate(){
			$( "#myForm" ).validate( {
				rules: {
					name: {
						required	: true,
						minlength	: 2
					},
					email:	{
						required	: true,
						email		: true
					},
					phone:	{
						required 	: true,
						number		: true,
						minlength	: 9,
						maxlength	: 10
					},
					url:	{
						required	: true
					}
				},
				messages: {
				
				},
				invalidHandler: function(event, validator) {
	                //display error alert on form submit    
	            },
	            errorPlacement: function(label, element) { // render error placement for each input type   
	                console.log(label);
	                $('<span class="error"></span>').insertAfter(element).append(label)
	                var parent = $(element).parent().parent('.form-group');
	                parent.removeClass('has-success').addClass('has-error');
	            },
	            success: function(label, element) {
	                var parent = $(element).parent().parent('.form-group');
	                parent.removeClass('has-error').addClass('has-success');
	            }
			} );
		}
		</script>
</body>
</html>
