<%@include file="../../include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>User</title>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description ????" />
        <meta content="" name="author ?????" />

        <!---------------START CSS INCLUDE-------------->
        <%@include file="../../include/css_header.jsp" %>
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
									<h2 class="title pull-left">Dashboad | User</h2>
								</header>
						
							<br/>
							<br/>
						
						  <div class="row" id="content-body">
								
								<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" style="padding-left: 50px">
									<a href="${pageContext.request.contextPath}/admin/user/create" class="btn btn-success">Add Status</a>
								</div>
								
								<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
									<div class="form-group">
									  <select id="limitplaylist" onclick="chooseUser();" class="form-control">
										<option value="10"  selected="selected">10</option>
										<option value="20">20</option>
										<option value="30">30</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
									</div>
								</div>
						  
								<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
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
		<%@include file="../../include/js_footer.jsp" %>
        <!-- -------------END TOPBAR ---------------------->
		    
		<!-- OTHER JS INCLUDE -->
	 	<script  src="${pageContext.request.contextPath}/resources/assetAdmin/js/bootpage.js" type="text/javascript"></script>
		<script  src="${pageContext.request.contextPath}/resources/assetAdmin/sweetalert2/sweetalert2.min.js" type="text/javascript"></script>
		<script  src="${pageContext.request.contextPath}/resources/assetAdmin/alertify/js/alertify.min.js" type="text/javascript"></script>
		<!-- OTHER JS INCLUDE END-->
		
		<script type="text/javascript">
		
		var limit=0;
		var offset=1;
		//var totalofrecord =0;
		var numofpage=1;
		var url="${pageContext.request.contextPath}";

		/**
		* choice for you search or list
		**/
		function chooseUser() {
			var key =$("#search").val();
			if(key.length == 0){
				mystart();
			}else{
				searchUser();
			}
		} 
		
		/*
		* start process
		*/
		mystart();
		function mystart() {
			limit = $("#limitplaylist").val();
			//alert(limit);
			$.ajax({   
		            url 		: 	url+'/admin/user/all/page/'+offset+'/item/'+limit,
		            type 		: 	'get',
		            contentType	: 	'application/json;charset=utf-8',
		            success 	: 	 function(data) {
		            	if(data.STATUS == true) {
		            		//totalofrecord	=	data.PAGINATION.totalRecord;
			            	numofpage		=	data.PAGINATION.totalPage;
			            	listAllUser(1);
			            	loadPaginationStatus();
			            }
		            },
		            error: function(data) {
		            		console.log(data);
		            }
		        });	  
		}
		
		/*
		* bootpage show pagination
		*/
		function loadPaginationStatus() {
			$('#pagination').bootpag({
		        total 		: numofpage,
		        maxVisible	: 5,
		        leaps		: true,
		        firstLastUse: true,
		        first 		: '&#8592;',
		        last 		: '&#8594;',
		        wrapClass 	: 'pagination',
		        activeClass : 'active',
		        disabledClass: 'disabled',
		        nextClass 	: 'next',
		        prevClass 	: 'prev',
		        lastClass 	: 'last',
		        firstClass 	: 'first'
		    }).on("page", function(event, num) {
		    	listAllUser(num);
		    }); 
		}
		
		/*
		* listAllUser
		*/
		function listAllUser(offset) {
	    	$.ajax({
	    		url 		: url+'/admin/user/all/page/'+offset+'/item/'+limit,
	            type 		: 'get',
	            contentType : 'application/json;charset=utf-8',
	            success 	: function(data) {
				            	if(data.STATUS == true) {
				            		$("tbody").html(listUserDetail(data));
				            	}
	            },
	            error 		: function(data) {
	            				console.log(data);
	            }
	        });	    	   
		}
		
		/*
		* list Status detail
		*/
		function listUserDetail(data) {
			var status = "";
			var str="";
				for(var i=0; i<data.DATA.length ; i++) {
				
					if (data.DATA[i].status == 2) {
						status = "Delete";
					}else if(data.DATA[i].status == 3) {
						status = "Pendding";
					} else  {
						status = "Active";
					}

					str +="<tr>"
							+"<td>"+data.DATA[i].id+"</td>"
							+"<td><img src="+url+"/resources/images/user/"+data.DATA[i].thumnail+" width='80%'/></td>"
							+"<td>"+data.DATA[i].username+"</td>"
							+"<td>"+data.DATA[i].email+"</td>"
							+"<td>"+data.DATA[i].phone+"</td>"
							+"<td>"+data.DATA[i].gender+"</td>"
							+"<td>"+status+"</td>"
							+"<td>"+data.DATA[i].createdDate+"</td>"
							+"<td>"+data.DATA[i].updatedDate+"</td>"
							+"<td>"
								+"<a title='view status' data-toggle='modal' data-target='#myModal' onclick=viewUser('"+data.DATA[i].id+"') class='btn btn-primary'>View</a> &nbsp;"
								+"<a title='edit status'  href='"+url+'/admin/user/edit/'+data.DATA[i].id+"' class='btn btn-success'>Edit</a> &nbsp;"              
								+"<a title='delete playlist'  onclick=deleteUser('"+data.DATA[i].id+"') class='btn btn-danger'>Delete</a> &nbsp;"    
							+"<td>"
						+"</tr>" ;
				}
			return str;
		}
		
		/*
	    *use to view status
	    */
	    function viewUser(id) {
	    	var status = "";
	    	 $.ajax({  
                    url 	: url+'/admin/user/show/'+id,
                    type 	:'get',
                    contentType: 'application/json;charset=utf-8', 
                    success : function(data) { 
                            if(data.STATUS ==  true ) {
                            	
                            	if (data.DATA.status == 2) {
            						status = "Delete";
            					}else if(data.DATA.status == 3) {
            						status = "Pendding";
            					} else  {
            						status = "Active";
            					}
                            	
                            	$("#viewId").text(data.DATA.id);
                            	$("#viewName").text(data.DATA.username);
                            	$("#viewEmail").text(data.DATA.email);
                            	$("#viewPhone").text(data.DATA.phone);
                            	$("#viewGender").text(data.DATA.gender);
                            	$("#viewDob").text(data.DATA.dob);
                            	$("#viewStatus").text(status);
                            	$("#viewApprove").text(data.DATA.approvedDate);
                            	$("#viewCreate").text(data.DATA.createdDate);
                            	$("#viewUpdate").text(data.DATA.updatedDate);
                            	
                            	var profile = "<img alt='profile' src='${pageContext.request.contextPath}/resources/images/user/"+data.DATA.thumnail+"' class='img-responsive'> ";
                            	$("#viewProfile").html(profile);
                            }
                       }  ,  
                            error: function(data) {
                            console.log("ERROR..." + JSON.stringify(data));
                    }
                });  
	    }
		
		function deleteUser(id){
			swal({
			  title 			: 'Are you sure?',
			  text 				: "You won't be able to revert this!",
			  type 				: 'warning',
			  showCancelButton 	: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor : '#d33',
			  confirmButtonText : 'Yes, delete it!'
			}).then(function () {

				 $.ajax({  
	                    url 	: url+'/admin/user/delete/'+id,
	                    type 	:'get',
	                    contentType: 'application/json;charset=utf-8', 
	                    success : function(data) { 
	                            if(data.STATUS ==  true ) {
	                                mystart();
	                                swal(
										    'Deleted!',
										    'Your file has been deleted.',
										    'success'
										  )
	                            }
	                       }  ,  
	                            error: function(data) {
	                            console.log("ERROR..." + JSON.stringify(data));
	                    }
	                });  
			})
	    }
		
		function searchUser() {
	        key 	= $('#search').val();
	        limit 	= $("#limitplaylist").val();
	        
	        /**
	        *if string search is empty sould be go to list
	        **/
	        if (key.length == 0 ){
	        	mystart();
	        } else {
	        	$.ajax({
		            url 		: url+'/admin/user/search/page/'+ offset +'/item/'+ limit + '/' + key,
		            type 		: 'get',
		            contentType : 'application/json;charset=utf-8', 
		            success 	: function( data ) {
		                if( data.STATUS == true ){
		                    numofpage = data.PAGINATION.totalPage;
		                    $("tbody").html(listUserDetail(data));
		                    loadPaginationStatus();

		            } else {
		                    $('tbody').html('<h2>Search Not Found</h2>');
		                    $('#pagination').html('');
		            }
		        },
		        error: function( data ) {
		            console.log("ERROR..." + JSON.stringify(data));
		        	}
		        });
	        }
	}
		
	</script>
</body>
</html>
