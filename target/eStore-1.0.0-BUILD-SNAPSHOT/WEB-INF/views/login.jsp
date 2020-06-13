<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="container-wrapper">
	<div class="container">
		<h2>Login with username and password</h2>

		<c:if test="${errorMsg != ''}">
			<div style="color: red">
				<h3>${errorMsg}</h3>
			</div>
		</c:if>

		<c:if test="${logoutMsg != ''} ">
			<div style="color: blue">
				<h3>${logoutMsg}</h3>
			</div>
		</c:if>
		
		<form action="<c:url value="/login"/>" method="post">

			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter username"
					name="username">
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <!-- html form을 이용하였기 때문에 반드시 따로 csrf 토큰을 날려줘야 함  -->

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>