<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
    <div>
    <c:import url="../templetes/header.jsp"></c:import>   
    </div>


	<section class="vh-100" style="background-color: #eee;">
	  <div class="container h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-lg-12 col-xl-11">
	        <div class="card text-black" style="border-radius: 25px;">
	          <div class="card-body p-md-5">
	            <div class="row justify-content-center">
	              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
	
	                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login</p>
	
	                <form class="mx-1 mx-md-4" action="./login.mg" method="post">
	
	                  <div class="d-flex flex-row align-items-center mb-4">
	                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
	                    <div class="form-outline flex-fill mb-0">
	                      <label class="form-label" for="id"> ID</label>
	                      <input type="text" name="id" class="form-control" />
	                    </div>
	                  </div>
	                  
	                  <div class="d-flex flex-row align-items-center mb-4">
	                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
	                    <div class="form-outline flex-fill mb-0">
	                      <label class="form-label" for="form3Example4c">Password</label>
	                      <input type="password" name=pw class="form-control" />
	                    </div>
	                  </div>
	
	
	                  <div class="form-check d-flex justify-content-center mb-5">
	                    <input class="form-check-input me-2" type="checkbox" name="remind" id="form2Example3c" />
	                    <label class="form-check-label" for="form2Example3">
	                      아이디 저장
	                    </label>
	                  </div>
	
	                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
	                    <button type="submit" class="btn btn-dark btn-lg">Login</button>
	                  </div>
	
	                </form>
	
	              </div>
	
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
   
   <div>   
	    <c:import url="../templetes/footer.jsp"></c:import>
   </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    	
</body>
</html>