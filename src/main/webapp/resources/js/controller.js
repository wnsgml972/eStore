var cartApp = angular.module('cartApp', []); //angular module 정의 : 이름은 cartApp

cartApp.controller("cartCtrl", function($scope, $http) { //controller 정의 : 이름은 cartCtrl
														//http를 통해 request를 받기 위해
	
	
	/*
	 * 여기서부터 각각의 method를 정의함!, callback 방식
	 * Angluar JS 는 프레임 워크임!!,   scope는 자동으로 객체가 주입됨!
	 */
	$scope.initCartId = function(cartId) { //initCartId method
		$scope.cartId = cartId;
		$scope.refreshCart();
	};

	$scope.refreshCart = function() { //refreshCart method
		$http.get('/eStore/api/cart/' + $scope.cartId).then( //get 방식의 rest api 호출 controller로 가보면 있음
				function successCallback(response) {
					$scope.cart = response.data;
				}); //이거랑 밑의 $http해서 url 준거랑 똑같은 것임!! 이건 short format 밑에는 long format
	};

	$scope.clearCart = function() { //clearCart method
		
		$scope.setCsrfToken();
		
		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});

	};
	
	$scope.addToCart = function(productId) { //addToCart method
		
		$scope.setCsrfToken();
		
		$http.put('/eStore/api/cart/add/' + productId).then(
				function successCallback() {
					alert("Product successfully added to the cart!");

				}, function errorCallback() {
					alert("Adding to the cart failed!")
				});
	};

	$scope.removeFromCart = function(productId) { //removeFromCart method
		
		$scope.setCsrfToken();
		
		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/cartitem/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.calGrandTotal = function() { //calGrandTotal method
		var grandTotal = 0;

		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}

		return grandTotal;
	};
	
	$scope.setCsrfToken = function() { //setCsrfToken method
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");
		
		$http.defaults.headers.common[csrfHeader] = csrfToken;
	}
	
});