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
							
								<form:form   commandName="testValidate" class="form-horizontal" action="${pageContext.request.contextPath}/admin/validator/server" method="post" enctype="multipart/form-data">
							
									<div class="form-group">
										<label class="col-sm-3 control-label">String</label>
										<div class="col-sm-9">
											<form:input path="string"  class="form-control" placeholder="String, min5, max10, not null"/>
											<div class="has-error">
												<form:errors path="string" cssStyle="color: #ff0000;" element="div"/>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">phone</label>
										<div class="col-sm-9">
											<form:input path="phone" class="form-control" placeholder="Not null, Number"/>
											<form:errors path="phone" cssStyle="color: #ff0000;"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">email</label>
										<div class="col-sm-9">
											<form:input path="email" class="form-control" placeholder="email, not null" />
											<form:errors path="email" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">pass</label>
										<div class="col-sm-9">
											<form:input path="pass"   class="form-control" placeholder="pass, not null" />
											<form:errors path="pass" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">url</label>
										<div class="col-sm-9">
											<form:input path="url"   class="form-control" placeholder="url, not null" />
											<form:errors path="url" />
										</div>
									</div>
									
									<%-- <div class="form-group">
										<label class="col-sm-3 control-label">birthday</label>
										<div class="col-sm-9">
											<form:input path="birthday" class="form-control" placeholder="birthday"/>
											<form:errors path="birthday" />
										</div>
									</div> --%>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Action</label>
										<div class="col-sm-9">
											<input type="submit" value="Test" class="btn btn-primary"/>
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
		
		<script type="text/javascript">
		
		</script>
</body>
</html>
