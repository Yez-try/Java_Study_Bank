const d2 = document.getElementById("d2")
const d1 = document.querySelector("#d1")
const d4 = document.querySelector("#d4")


//마우스 이벤트

d2.addEventListener("mouseenter", function(){
    console.log("Enter");
    console.log(d1.class); //제대로작동하지 않는다. 왜냐하면 class는 예약어이기 때문이다.
    console.log(d1.getAttribute("class")) //여러개의 클래스명은 문자열로 가져온다.
    // d1.className = "c2";
    d1.classList.replace("c3","c2")
})

d2.addEventListener("mouseleave", function(){
    console.log("leave")
    console.log(d1.className)
    console.log(d1.classList)
    d1.classList.add("c4")
})


//class 알아보기

//class값 가져오기
//class값 변경하기
//


d3.addEventListener("click",function(){
    console.log("toggle")
    d2.classList.toggle("c2")
    console.log(d2.classList.contains("c2"))
})

d4.addEventListener("click", function(){
    console.log("request")
    console.log("pathname"+location.pathname) //ip뒤에 나오는 경로
    console.log("origin"+location.origin) //ip주소
    console.log("search"+location.search) // 파라미터를 의미
    console.log("hostname"+location.hostname) //ip
    // location.href="./dom_9.html"
})

//window의 location 알아보기 : url, 주소창을 관리하는 location
//https://www.w3schools.com/jsref/obj_location.asp
//href: 주소창에 입력해준다.
//Location 변수가 주소창을 관리한다. get방식으로 요청하는 경우
