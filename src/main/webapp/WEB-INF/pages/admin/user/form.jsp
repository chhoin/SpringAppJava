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
									<h2 class="title pull-left">${title}</h2>
								</header>
						
							<br/>
							<br/>
						
						  <div class="row" id="content-body">
						  	
						  	<!---------------START FORM-------------->
							<form  class="form-horizontal" action="<%= request.getContextPath()%>/admin/user/${action}" method="post" role="form" id="myform" enctype="multipart/form-data">
								
								<div class="col-xs-12">
									<p class="text-center">${message}</p>
								</div>
								
								<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
								
									<div class="form-group">
										<label class="col-sm-3 control-label">User Name</label>
										<div class="col-sm-9">
											<input type="text" name="username" id="username" value="${user.username }" class="form-control" placeholder="User Name" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Email</label>
										<div class="col-sm-9">
											<input type="email" name="email" id="email" value="${user.email }" class="form-control" placeholder="Email" required>
										</div>
									</div>
									
									<!-- START PASSWORD -->
									<c:if test="${not edit}">
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
									</c:if>
									
									<!-- START PASSWORD -->
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Phone</label>
										<div class="col-sm-9">
											<input type="text" name="phone" id="phone" value="${user.phone }" class="form-control" placeholder="phone" >
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Gender</label>
										<div class="col-sm-9">
										<c:choose>
												<c:when test="${user.gender == 'MALE' }">
													<label class="radio-inline"><input type="radio" name="gender" value="MALE" checked>Male</label>
													<label class="radio-inline"><input type="radio" name="gender" value="FEMALE">Female</label>
												</c:when>
												<c:otherwise>
													<label class="radio-inline"><input type="radio" name="gender" value="MALE" >Male</label>
													<label class="radio-inline"><input type="radio" name="gender" value="FEMALE" checked>Female</label>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Date Of Birth</label>
										<div class="col-sm-9">
											<input type="date" name="dob" id="dob" value="${user.dobDate }" class="form-control" placeholder="dob" >
										</div>
									</div>
									<!-- check if edit true will show status -->
									<c:if test="${edit}">
										<div class="form-group">
											<label class="col-sm-3 control-label">Status</label>
											<div class="col-sm-9">
												<select name="status" class="form-control">
													<c:forEach items="${status }" var="status">
														<c:choose>
															<c:when test="${user.status == status.value}">
																<option value="${status.value }" selected>${status.title }</option>
															</c:when>
															<c:otherwise>
																<option value="${status.value }">${status.title }</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</div>
										</div>
									</c:if>
									
									<c:if test="${not edit}">
										<div class="form-group">
											<label class="col-sm-3 control-label">Role</label>
											<div class="col-sm-9">
												<select name="userRole" class="form-control">
													<c:forEach items="${role }" var="role">
														<option value="${role.id }" selected>${role.name }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</c:if>
									
									
									<div class="form-group">
										<label class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Action</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
											<c:choose>
													<c:when test="${edit}">
														<input type="hidden" name="id" id="id" value="${user.id }"/>
														<input type="hidden" name="thumnail" value="${user.thumnail }"/>
														<input type="submit" value="Update" class="btn btn-success"/>
													</c:when>
													<c:otherwise>
														<input type="submit" value="Add" class="btn btn-success" />
													</c:otherwise>
												</c:choose>
											
												<button type="button" class="btn btn-warning"​ onclick="clearForm()">Clear</button>
												<a href="<%= request.getContextPath()%>/admin/user/index" type="button" class="btn btn-danger">Back</a>
										</div>
									</div>
								
								</div>
								
								<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
				        			<div class="fileinput fileinput-new" data-provides="fileinput">
										  <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
										  		<c:choose>
													<c:when test="${empty user.thumnail }">
														<img data-src="holder.js/100%x100%" alt="">
													</c:when>
													<c:otherwise>
														<img data-src="holder.js/100%x100%" src="<%= request.getContextPath()%>/resources/images/user/${user.thumnail }">
													</c:otherwise>
												</c:choose>
										    	
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
						 
					<!-- IF UPDATE ALLOW TO SEE -->
					<c:if test="${edit}">
						<div class="content-body">
						<section class="box ">
								<header class="panel_header">
									<h2 class="title pull-left">PASSWORD </h2>
								</header>
						
							<br/>
							<br/>
							  <div class="row" id="content-body">
							  		<div class="col-xs-12">
										<form id="formResetPass">
											<div class="form-group">
												<label class="col-sm-3 control-label">New Password</label>
												<div class="col-sm-9">
													<input type="password" name="password" id="password" value="" class="form-control" placeholder="New password" required>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-sm-3 control-label">Confirm Password</label>
												<div class="col-sm-9">
													<input type="password" name="confirm" id="confirm" value="" class="form-control" placeholder="Confirm Password" required>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label">Action</label>
												<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
													<input type="hidden" name="id" value="${user.id }"/>
													<input type="button" id="btnReset" value="Update" class="btn btn-success" />
													<a href="<%= request.getContextPath()%>/admin/user/index" type="button" class="btn btn-danger">Back</a>
												</div>
											</div>
										</form>
							  		</div>
							  </div>
							</section>
						</div>
					</c:if>
					<!-- END IF UPDATE ALLOW TO SEE -->
						
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
			$('#btnReset').click(function(){
				if($("#formResetPass").valid() ){	
					
					var userId = $('#id').val();
					var pass = $('#password').val();
					var url = "${pageContext.request.contextPath}";
					 $.ajax({  
		                    url 	: url+"/admin/user/reset/userId/"+userId+"/pass/"+pass,
		                    type 	:'get',
		                    contentType: 'application/json;charset=utf-8', 
		                    success : function(data) { 
		                            if(data.STATUS ==  true ) {
		                            	//sweet alert
		                            	swal({
		                            		  title: 'Reset Passsword',
		                            		  text: 'successfully',
		                            		  timer: 2000
		                            		}).then(
		                            		  function () {},
		                            		  // handling the promise rejection
		                            		  function (dismiss) {
		                            		    if (dismiss === 'timer') {
		                            		      console.log('I was closed by the timer')
		                            		    }
		                            		  }
		                            		)
		                            	//clear reset from
		                            	clearResetForm();
		                            }
		                       },  
                            error: function(data) {
                            console.log("ERROR..." + JSON.stringify(data));
		                    }
		              });  
				}
			});
		});
			
			
		
		resetPassValidate();
		function resetPassValidate(){
			$( "#formResetPass" ).validate( {
				rules: {
					password: {
						required	: true,
						minlength	: 6
					},
					confirm:	{
						required	: true,
						minlength	: 6,
						equalTo		: "#password"
					}
				},
				messages: {
					password: {
						required	: "Field is require!",
						minlength	: "Your PassWord must consist of at least 6 characters"
					},
					confirm: {
						required	: "Field is require!",
						minlength	: "Your PassWord must consist of at least 2 characters",
						equalTo		: "Please enter the same password "
					}
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
		
		function clearResetForm() {
			$('#password').val('');
			$('#confirm').val('');
		}
		
			function clearForm(){
				//$('#txtName').val('');
				//$('#txtDescription').val('');
			}
		</script>
</body>
</html>
