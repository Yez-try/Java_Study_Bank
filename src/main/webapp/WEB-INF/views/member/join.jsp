<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 아래코드가 한글 안깨져 보이게 하는 코드 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
	<c:import url="../templetes/header.jsp"></c:import>
		<section class="" style="background-color: #eee;">
		  <div class="container h-100">
		    <div class="row d-flex justify-content-center align-items-center h-100">
		      <div class="col-lg-12 col-xl-11">
		        <div class="card text-black" style="border-radius: 25px;">
		          <div class="card-body p-md-5">
		            <div class="row justify-content-center">
		              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
		
		                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>
		
		                <form class="mx-1 mx-md-4" action="./join.mg" method="post" enctype="multipart/form-data" id="joinForm">
							
						<div>
						<input type="file" name="photo" class="form-control" >
						</div>
		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <label class="form-label" for="id">Your ID</label>
		                      <input type="text" name="id" class=" form-control" id="id"/>
		                      <div id="lid" class=""></div>
		                    </div>
		                  </div>

		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <label class="form-label" for="form3Example4c">Password</label>
		                      <input type="password" name="pw" class=" form-control" id="pw" />
		                      <div id="lpw" class=""></div>
		                    </div>
		                  </div>
		                  
		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <label class="form-label" for="form3Example4c">Password 확인</label>
		                      <input id="pwchk" type="password" name="" class=" form-control" />
		                      <div id="lpwchk" class=""></div>
		                    </div>
		                  </div>
		                  
		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <label class="form-label" for="name">Your Name</label>
		                      <input id="name" type="text" name="name" class="joinIp form-control" />
		                      <div id="lname" class="joinMsg"></div>
		                    </div>
		                  </div>
		
		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <label class="form-label" for="form3Example3c">Your Email</label>
		                      <input id="email" required type="email" name="email" class="joinIp form-control" />
		                      <div id="lemail" class="joinMsg"></div>
		                    </div>
		                  </div>
		
		                  <div class="d-flex flex-row align-items-center mb-4">
		                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
		                    <div class="form-outline flex-fill mb-0">
		                      <label class="form-label" for="form3Example4c">Your Phone number</label>
		                      <input id="phone" type="tel" name="phone" class="joinIp form-control" />
		                      <div id="lphone" class="joinMsg"></div>
		                    </div>
		                  </div>
		                  
		
		                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
		                    <button type="submit" id = "joinButton" class="btn btn-dark btn-lg">Register</button>
		                  </div>
		
		                </form>
		
		              </div>
		              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
		
		                <img src="/resources/img/aespa.jpg"
		                  class="img-fluid" alt="멋진 사진">
		
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>
   
    
    <div class="container"></div>
    <c:import url="../templetes/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/member.js"></script>
	<script>
		<!--joinjs()-->
	</script>
</body>
</html>