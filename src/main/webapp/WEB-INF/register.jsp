<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register/Login</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="container-sm col-4 d-flex justify-content-around"
			style="margin-top: 100px; margin-left: 42%">
			<div>
			<h1 class="text-center mb-3">Register</h1>
			<form:form action="/register" method="post" modelAttribute="Register">
				<div>
					<div class="row mb-1">
						<div class="col">
							<form:label path="userName" class="form-label">UserName:</form:label>
							<form:input type="text" path="userName" class="form-control"
								placeholder="UserName" />
							<form:errors path="userName"></form:errors>
						</div>
					</div>
					<div class="row mb-1">
						<div class="col">
							<form:label path="email" class="form-label">Email:</form:label>
							<form:input type="email" path="email" class="form-control"
								placeholder="Email" />
							<form:errors path="email"></form:errors>
						</div>
					</div>
					<div class="row mb-1">
						<div class="col">
							<form:label path="password" class="form-label">Password:</form:label>
							<form:input type="password" path="password" class="form-control"
								placeholder="Password" />
							<form:errors path="password"></form:errors>
						</div>
					</div>
					<div class="row mb-1">
						<div class="col">
							<form:label path="confirm" class="form-label">Confirm:</form:label>
							<form:input type="text" path="confirm" class="form-control"
								placeholder="Confirm Password" />
							<form:errors path="confirm"></form:errors>
						</div>
					</div>
				<button type="submit" class="btn btn-primary mt-2">Submit</button>
				</div>
			</form:form>
			</div>
			<div>
			<h1 class="text-center mb-3">Login</h1>
			<form:form action="/login" method="post" modelAttribute="Login">
				<div class="row mb-1">
					<div class="col">
						<form:label path="email" class="form-label">Email:</form:label>
						<form:input type="email" path="email" class="form-control"
							placeholder="Email" />
						<form:errors path="email"></form:errors>
					</div>
				</div>
				<div class="row mb-1">
					<div class="col">
						<form:label path="password" class="form-label">Password:</form:label>
						<form:input type="password" path="password" class="form-control"
							placeholder="Password" />
						<form:errors path="password"></form:errors>
						<button type="submit" class="btn btn-primary mt-2">Submit</button>
					</div>
				</div>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>