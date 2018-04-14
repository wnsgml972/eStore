<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="container-wrapper">
	<div class="container">
		<h2>Product Detail</h2>
		<p>Here is the detail information of the product!</p>
		<div class="row">
			<div class="col-sm-8">
				<c:set var="imageFilename"
					value="/resources/images/${product.id}.png" />

				<img src="<c:url value="${imageFilename}" />" alt="image"
					style="width: 80%" />
			</div>
			<div class="col-sm-4">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<b>Manufacturer</b> : ${ product.manufacturer }
				</p>
				<p>
					<b>Category</b> : ${ product.category }
				</p>
				<h3>${ product.price }</h3>
			</div>
		</div>

	</div>
</div>