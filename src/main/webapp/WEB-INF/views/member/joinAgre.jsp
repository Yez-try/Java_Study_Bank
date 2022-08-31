<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용약관 동의 페이지</title>
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
	
	                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">이용약관 동의</p>
	
	                <form id="agreform" class="mx-1 mx-md-4" action="./join.mg" method="get" enctype="multipart/form-data" >
						
					<div>
					<input class="form-check-input me-2" type="checkbox" value="" id="all" name=""/>
						<label class="form-check-label" for="form2Example3">
	                      <a href="#!">서비스약관</a>의 모든 내용에 동의합니다.
	                    </label>
					</div>
	                  <div class="form-check d-flex justify-content-center mb-5">
	                    <input class="req cb form-check-input me-2" type="checkbox" value="true" id="" name="agre1"/>
	                    <label class="agrechk form-check-label" for="form2Example3">
	                      (필수) 이용약관 동의
	                    </label>
	                  </div>
	
	                  <div class="form-check d-flex justify-content-center mb-5">
	                    <input class="req cb form-check-input me-2" type="checkbox" value="true" id="" name="agre2"/>
	                    <label class="form-check-label" for="form2Example3">
	                      (필수) 이용약관 동의2
	                    </label>
	                  </div>
	                  
	                  <div class="form-check d-flex justify-content-center mb-5">
	                    <input class="cb form-check-input me-2" type="checkbox" value="" id="" name=""/>
	                    <label class="form-check-label" for="form2Example3">
	                      (선택) 이용약관 동의3
	                    </label>
	                  </div>
	
	                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
	                    <button type="button" class="btn btn-dark btn-lg" id="joinAgrebtn">회원가입</button>
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
	
	
	
	
	
    <c:import url="../templetes/footer.jsp"></c:import>
    <script src="/resources/js/member.js"></script>
	<script>
		joinAgrejs()
	</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>