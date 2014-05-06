<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div role="navigation" class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">MakeJournal</a>
		</div>
		<div class="navbar-collapse collapse">
		${sessionScope.user }
			<form role="form" class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Email">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password">
				</div>
				<button class="btn btn-success" type="submit">Sign in</button>
				<a class="btn btn-primary" href="reg.jsp">Sign up</a>
			</form>
		</div>
	</div>
</div>