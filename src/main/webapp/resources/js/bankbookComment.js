const commentbtn = document.querySelector("#commentbtn");
const commentList = document.querySelector("#commentList");
getCommentList();

commentbtn.addEventListener("click", function(){
    //-------------필요한 element 가져오기
    //- HTML5에 추가된 Element의 속성   - 개발자가 element의 속성값으로 data를 넣고 싶을 때 사용
    const writer = document.querySelector("#writer");
    const contents = document.querySelector("#contents")
    console.log(writer.value)
    console.log(contents.value)
    console.log(commentbtn.getAttribute("data-booknum"))
    let booknum = commentbtn.getAttribute("data-booknum");

    //------------ajax----------------------------
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. url을 준비 (메서드와 URL준비)
    xhttp.open("POST","./commentAdd")

    //3. post방식인 경우 Enctype을 준비
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 발생 과 파라미터 전달(post인 경우 파라미터를 추가해준다. 주소창 뒤에 파라미터 보낼때와 같은 형식으로 보내준다)
    xhttp.send("writer="+writer.value+"&contents="+contents.value+"&bookNum="+booknum)

    //5. 응답처리
    //요청이 4번 왔다갔다 할 때 마다 (이벤트 걸어주기)
    xhttp.onreadystatechange = function(){
        //그중에서 마지막 응답이 오고 정상응답인 경우에
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText; 
            console.log(result) 

            //json형식으로 받아와보자
            result = JSON.parse(result)
            
            if(result.result == 1){
                //혹시 기존에 table있으면 지우자
                console.log(commentList.childNodes[0]) //콘솔창에 아무것도 안나옴 .. 원인 찾아야함
                commentList.removeChild(commentList.childNodes[0]);
                
                //table 가져오기
                getCommentList()
                alert("댓글 입력 성공")
            }
            //modelandview로 jsp경로를 리턴하면 ajaxResult.jsp 페이지의 html 코드 전체가 result로 들어옴
            //@responsebody를 어노테이션으로 주고 string을 리턴해줄수있다.
        }
    }
})

function getCommentList(){
    console.log("getcommentlist")
    //1. XMLHttpRequest 생성
    const xhttp = new XMLHttpRequest();

    xhttp.open("GET", "./commentList?page=1&booknum="+commentbtn.getAttribute("data-booknum"));

    //3. GET인 경우 Enctype없어도 됨 //    xhttp.setRequestHeader() 안써줘도 됨


    xhttp.send()

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            //1. JSP 사용해 받아왔을때
            // commentList.innerHTML = xhttp.responseText.trim();

            //2. JSON 사용해 받아왔을때
            console.log(xhttp.responseText.trim())
            let comlist = JSON.parse(xhttp.responseText.trim());

            

            //이걸 이제 element 만들어서 일일히 넣어주자
            let tb = document.createElement("table")
            let at = document.createAttribute("border")
            at.value = "1";

            tb.setAttributeNode(at) //<table border="1">

            for(let i = 0; i<comlist.length; i++){
                let tr = document.createElement("tr")


                let td = document.createElement("td")
                let tt = document.createTextNode(comlist[i].contents)

                td.appendChild(tt)
                tr.appendChild(td)

                
                td = document.createElement("td")
                tt = document.createTextNode(comlist[i].writer)

                td.appendChild(tt)
                tr.appendChild(td)

                td = document.createElement("td")
                tt = document.createTextNode(comlist[i].regDate)

                td.appendChild(tt)
                tr.appendChild(td)

                tb.appendChild(tr)
            }   
            commentList.appendChild(tb)
        }
    })
}