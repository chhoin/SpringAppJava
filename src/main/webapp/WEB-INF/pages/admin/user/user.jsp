<%@include file="../../include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>1111</title>
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
