//ajax study
//json 더미를 요청해보자
//https://jsonplaceholder.typicode.com/
const d1 = document.getElementById("d1")
const num = document.querySelector("#num")
const result = document.querySelector("#result")



d1.addEventListener("click",function(){
    console.log("d1 클릭")

    //1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();
    
    //2. 요청 발생시 필요한 정보(url, 메서드 형식)
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+num.value);
    //외부 서버로 요청
    
    //(POST방식인 경우) 파라미터 전송
    //xhttp.send("replyNum="+replyNum+"&contents="+contents);
    
    //3. 요청발생
    xhttp.send(); //get방식은 파라미터를 넣지 않음

    //4. 응답결과 처리
    //readystatechange 는 요청단계와 상태번호를 의미함
    //요청은4단계로 나눌수 있는데 (1.접속해도돼요? 2.여기로 들어오세요 3.찐 요청함 4.리턴을 줌)
    //200은 정상 응답이라는 의미
    xhttp.onreadystatechange = function(){
        //여기서 this는 xhttp 객체를 의미한다.
        if(this.readyState == 4 && this.status == 200){
            //응답의 결과물이 responseText에 들어가게 된다. 하나의 긴 문자열 형태
            let response = this.responseText.trim(); 
            //JSON.parse는 문자열을 JSON 객체로 바꿔준다
            //json이란 데이터를 주고 받는 방식 //대부분의 곳에 다 통용된다.
            //Javascript객체 문법을 따르는 문자 기반의 데이터 포맷으로 다수의 프로그래밍 환경에서 제공됨.
            console.log("responseText"+this.responseText);
            response = JSON.parse(response); 

            //h1태그를 만들어 각각 보여주자
            let h1 = document.createElement("h1")
            let t = document.createTextNode("response.userId: "+ response.userId)
            h1.appendChild(t)

            result.append(h1)

            h1 = document.createElement("h1")
            t = document.createTextNode("response.id: "+ response.id)
            h1.appendChild(t)

            result.append(h1)

            h1 = document.createElement("h1")
            t = document.createTextNode("response.title: "+ response.title)
            h1.appendChild(t)

            result.append(h1)

            h1 = document.createElement("h1")
            t = document.createTextNode("response.body: "+ response.body)
            h1.appendChild(t)

            result.append(h1)
            

            console.log(response.userId);
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);

        }
    }

    console.log("Ajax 발생") //맨마지막에 실행이 되나요?
    //답 : 아니요!
    //왜용? 요청을 보내고, 답변을 기다리는 동안 하단의 스크립트들을 실행을 합니당..
    //요청에 대한 응답이 오면! status...등등등을 실행합니다.
    //이런형태가 비동기 방식입니다.

})