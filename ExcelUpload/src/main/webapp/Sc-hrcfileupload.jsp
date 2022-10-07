<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html lang="en">
<head>
<title>HRC Application</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">

<!-- Optional JavaScript -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/hrcstyle.css">
<script src="js/hrcscript.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="topnav" id="nav">
			<a href="#" class="active2">INSIGHT</a>
		</div>
	</div>
<marquee>It is a mandatory to complete self certification in 6 Months</marquee>
	<div class="container">
		<div class="topnav" id="myTopnav">
			<a href="hrpopup.jsp" class="active">HR Compliance</a> <a
				href="branchinformation.jsp">Branch Information</a> <a
				href="inspection.jsp">Inspection</a> <a href="help.jsp">Help</a> <a
				href="javascript:void(0);" class="icon" onclick="myFunction()">
				<i class="fa fa-bars"></i>
			</a>
		</div>
	</div>
	<div class="container">
		<p class="branch">
			<b>Welcome</b> Amit MB <span class="branchname"><b>Branch</b>
				: Mysuru(MY 03) | <b>Zone</b> : South |</span>
		</p>
	</div>
	<div class="container"> 
   <form action="HrUploadExcelFile" enctype='multipart/form-data' method="POST"> 
     <input type="file" name="filePath" id="filePath" class="inputfile inputfile-6" data-multiple-caption="{count} files selected" accept=".xlsx,.xls,.csv" required />
    <input type="button" id="nextpage" value="Upload" class="btn btn-primary py-2">
   </form>   
   </div>     
  <div class="col-md-12 logo-border pb-4">
					<div class="d-flex justify-content-center align-items-center">
						<button type="button" id="empSearch" class="btn d-flex justify-content-center align-items-center empSearch" >
<!-- 							<i class="fa fa-plus-circle plus-icon-active-color"></i> -->
							<span class="plus-icon-active-text">Click to Edit the Scroll Notice</span>
							
						</button>
					</div>
				</div>
	</body>
	<script type="text/javascript">	
	$(document).ready(function(){
		  $("#nextpage").click(function(){
Swal.fire({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Yes, delete it!'
}).then((result) => {
  if (result.isConfirmed) {
    Swal.fire(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    )
  }
})
			  });
			});</script>

</html>