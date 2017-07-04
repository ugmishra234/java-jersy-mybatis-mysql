<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>API Test Console</title>
<style>
.api-container {
	border: 1px solid black;
	padding: 5px;
	mer font-size: 12px;
}

.api-header {
	text-align: left;
	font-size: 16px;
	font-style: italic;
}

.api-separator {
	margin-top: 20px;
}

.api-container label {
	min-width: 30px;
}

.inne-Content {
	text-align: left;
	margin-top: 10px;
	margin-left: 10px;
}

.label-content {
	width: 30%;
}

#base-url {
	display: none;
}

#hover-content {
	display: none;
}

#parent:hover #hover-content {
	display: block;
}

.fixed-button {
	position: fixed;
	top: 50px;
	right: 100px;
	float: right;
	background-color: gold;
	padding: 5px;
	border-radius: 5px;
}

.fixed-button a {
	color: black;
	text-decoration: none;
}
</style>
</head>
<%!String baseUrl = "localhost:8080";%>
<body>
	<span id='base-url'>http://<%=baseUrl%>/MavenJavaRestApi/restful/
	</span>

	<hr class="api-separator">
	<h1 class="api-header">Merchant New</h1>
	<div class="api-container">
		<form
			action="http://<%=baseUrl%>/MavenJavaRestApi/restful/merchant/new"
			method="POST" id="merchantNewForm">
			<div class="inne-Content">
				<label class="label-content">First Name</label>&nbsp;&nbsp; <input
					type="text" name="FirstName">
			</div>
			<br />
			<div class="inne-Content">
				<label class="label-content">Last Name</label>&nbsp;&nbsp; <input
					type="text" name="LastName">
			</div>
			<br />
			<div class="inne-Content">
				<label class="label-content">Email</label>&nbsp;&nbsp; <input
					type="text" name="Email">
			</div>
			<br />
			<div class="inne-Content">
				<label class="label-content">Password</label>&nbsp;&nbsp; <input
					type="text" name="Password">
			</div>
			<br />
			<div class="inne-Content">
				<label class="label-content">Mobile No</label>&nbsp;&nbsp; <input
					type="text" name="MobileNo">
			</div>
			<br />
			<div class="inne-Content">
				<label class="label-content">Application key</label>&nbsp;&nbsp; <input
					type="text" name="ApplicationKey">
			</div>
			<br />
			<div class="inne-Content">
				<label class="label-content">Developer Key</label>&nbsp;&nbsp; <input
					type="text" name="DeveloperKey">
			</div>
			<br />


			<div class="inne-Content">
				<input type="submit" name="submit" value="submit">
			</div>
		</form>
		<br /> <span>API Before Response: </span> <br /> <span>Action
			: http://<%=baseUrl%>/MavenJavaRestApi/restful/merchant/new
		</span> <br /> <span>Method : POST</span> <br /> <span>Data : </span> <label
			id="merchantnewBeforeResponse"></label> <br /> <br /> <span>API
			Response: </span> <label id="merchantnewResponse"></label>
	</div>

	<div class="api-container">
		<form
			action="http://<%=baseUrl%>/MavenJavaRestApi/restful/auth/merchant"
			method="POST" id="myForm">
			<span>Email: </span> <input type="text" name="email"> <span>Password:
			</span> <input type="text" name="password"> <input type="submit"
				name="submit" value="submit">
		</form>
		<br /> <span>API Before Response: </span> <br /> <span>Action
			: http://<%=baseUrl%>/MavenJavaRestApi/restful/auth/merchant
		</span> <br /> <span>Method : POST</span> <br /> <span>Data : </span> <label
			id="authBeforeResponse"></label> <br /> <br /> <span>API
			Response: </span> <label id="auth_response"></label>
	</div>
</body>

<script src="../js/jquery.js"></script>
<script src="../js/jquery.form.js"></script>
<script src="../js/jquery.cookie.js"></script>
<script src="../js/jquery.serializeObject.js"></script>
<script>
	$(document)
			.ready(
					function() {
							
							var options = {
									beforeSubmit : showAuthRequest,
									success : showResponse
								};

							var merchantNew = {
								beforeSubmit : showRequest,
								success : showMerchantNewResponse
							};
							
							$('#merchantNewForm').submit(function() {
								$(this).ajaxSubmit(merchantNew);
								return false;
							});
							
							$('#myForm').submit(function() {
								$(this).ajaxSubmit(options);
								return false;
							});

							function showMerchantNewResponse(responseText,
									statusText, xhr, $form) {
								console.log(responseText);
								var jsonString = JSON.stringify(responseText);
								$('#merchantnewResponse').html(jsonString);

								var merchantFingerPrintId = responseText['Response']['Data']['MerchantToken']['AuthToken'];
								console.log(merchantFingerPrintId);
							}
							
							function showResponse(responseText, statusText, xhr,
									$form) {
								console.log(responseText);
								var token = responseText['Response']['Data']['MerchantToken']['Token'];
							//	$.cookie("authToken", token);
								// var checkCookie = $.cookie("authToken");
							//	$('#tokenKey').val($.cookie("authToken"));
								//$('#logOutKey').val($.cookie("authToken"));
								//console.log($.cookie("authToken"));
								//alert(authToken);

								var jsonString = JSON.stringify(responseText);
								$('#auth_response').html(jsonString);
							}

							function showRequest(formData, jqForm, options) {
								var queryString = $.param(formData);
								$('#merchantnewBeforeResponse').html(
										queryString);
								return true;
							}
							
							function showAuthRequest(formData, jqForm, options) {
								var queryString = $.param(formData);
								$('#authBeforeResponse').html(queryString);
								return true;
							}
					});
</script>

</html>

