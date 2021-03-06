<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Add Product</h1>
		<p class="lead">Fill the below information to add a product</p>

		<!-- 	파일 업로드를 사용할 경우 스프링 form을 사용하더라도 csrf 파일 업로드 input은 csrf 토큰이 안날라가서 오류나므로 쿼리 스트링으로 넣어 줌	 -->
		<sf:form
			action="${ pageContext.request.contextPath}/admin/productInventory/addProduct?${_csrf.parameterName}=${_csrf.token}"
			method="post" modelAttribute="product" enctype="multipart/form-data">

			<div class="form-group">
				<label for="name">Name</label>
				<sf:input path="name" class="form-control" id="name" />
				<sf:errors path="name" cssStyle="color:red" />
			</div>

			<div class="form-group">
				<label for="category">Category: &nbsp;</label>
				<sf:radiobutton path="category" id="category" value="컴퓨터" />
				컴퓨터
				<sf:radiobutton path="category" id="category" value="가전" />
				가전
				<sf:radiobutton path="category" id="category" value="잡화" />
				잡화
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" class="form-control" id="description" />
			</div>

			<div class="form-group">
				<label for="price">Price</label>
				<sf:input path="price" class="form-control" id="price" />
				<sf:errors path="price" cssStyle="color:red" />				
			</div>

			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<sf:input path="unitInStock" class="form-control" id="unitInStock" />
				<sf:errors path="unitInStock" cssStyle="color:red" />				
			</div>

			<div class="form-group">
				<label for="manufacturer">Manufacturer</label>
				<sf:input path="manufacturer" class="form-control" id="manufacturer" />
				<sf:errors path="manufacturer" cssStyle="color:red" />
			</div>
			
			<div class="form-group">
				<label for="productImage">Upload Picture</label>
				<sf:input path="productImage" class="form-control" id="productImage" type="file" />
			</div>
			
			<input type="submit" value="submit" class="btn btn-primary" />
			<a href="<c:url value="/admin/productInventory" />"
				class="btn btn-default">Cancel</a>
		</sf:form>
	</div>
</div>