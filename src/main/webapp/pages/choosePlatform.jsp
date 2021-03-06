<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>makeJournal</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
body {
	padding-top: 50px;
}

.welcome {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="pages/template/header.jsp" />
	<div class="middle">
		<div class="container">
			<div class="row">
				<div class="col-xs-3 col-md-2"></div>
				<div class="col-xs-6 col-md-4">
					<a href="pages/choosePlatform.jsp" class="thumbnail"> <img alt="" src="images/platform_e.jpg">
					</a>
					<h4>Facebook</h4>
				</div>
				<div class="col-xs-6 col-md-4">
					<a href="pages/choosePlatform.jsp" class="thumbnail"> <img alt="" src="images/platform_c.jpg">
					</a>
					<h4>Instagram</h4>
				</div>
				<div class="col-xs-3 col-md-2"></div>
			</div>

		</div>
	</div>
	<!-- /.container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="javascript/jquery-1.11.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>


