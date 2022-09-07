const commentbtn = document.querySelector("#commentbtn");
const commentList = document.querySelector("#commentList");
const cmtmore = document.querySelector("#cmtmore");
const upCmt = document.querySelector("#update")

let cmtPage = 1;
getCommentList();

//코멘트 추가 버튼 클릭
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
            //페이지값 초기화
            cmtPage = 1;      

            let result = xhttp.responseText; 
            console.log(result) 

            //json형식으로 받아와보자
            result = JSON.parse(result)
            
            if(result.result == 1){
                //div 내의 내용(테이블) 없애기
                let len = commentList.childNodes.length;
                for(let i = 0; i<len; i++){
                    console.log(commentList.childNodes[0])
                    commentList.removeChild(commentList.childNodes[0]);
                }
                //input내의 값 없애기
                contents.value = '';
                writer.value='';
                
                //table 가져오기
                getCommentList()
                alert("댓글 입력 성공")
            }
            //modelandview로 jsp경로를 리턴하면 ajaxResult.jsp 페이지의 html 코드 전체가 result로 들어옴
            //@responsebody를 어노테이션으로 주고 string을 리턴해줄수있다.
        }
    }
})


//코멘트 리스트 받아오기
function getCommentList(){ 
    console.log("getcommentlist")
    //1. XMLHttpRequest 생성
    const xhttp = new XMLHttpRequest();

    xhttp.open("GET", "./commentList?page="+cmtPage+"&booknum="+commentbtn.getAttribute("data-booknum"));

    //3. GET인 경우 Enctype없어도 됨 //    xhttp.setRequestHeader() 안써줘도 됨


    xhttp.send()

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            //1. JSP 사용해 받아왔을때
            // commentList.innerHTML = xhttp.responseText.trim();

            //2. JSON 사용해 받아왔을때
            let cmtMap = JSON.parse(xhttp.responseText.trim());

            let cmtlist = cmtMap.list;
            let cmtPager = cmtMap.pager;
            
            //현재페이지수가 전체페이지수와 동일하면 disabled되도록한다.
            if(cmtPager.totalPage <= cmtPage){
                cmtmore.classList.add("disabled");
            }else{
                cmtmore.classList.remove("disabled");
            }
            
            //이걸 이제 element 만들어서 일일히 넣어주자
            for(let i = 0; i<cmtlist.length; i++){
                let tr = document.createElement("tr")


                let td = document.createElement("td")
                let tt = document.createTextNode(cmtlist[i].contents)

                td.appendChild(tt)
                tr.appendChild(td)

                
                td = document.createElement("td")
                tt = document.createTextNode(cmtlist[i].writer)

                td.appendChild(tt)
                tr.appendChild(td)

                td = document.createElement("td")
                tt = document.createTextNode(cmtlist[i].regDate)

                td.appendChild(tt)
                tr.appendChild(td)

                //span element 수정
                td = document.createElement("td")
                tt = document.createTextNode("수정")

                let at = document.createAttribute("class")
                at.value = "update";
                td.setAttributeNode(at)

                at = document.createAttribute("data-num")
                at.value = cmtlist[i].num;
                td.setAttributeNode(at)

                td.appendChild(tt)
                tr.appendChild(td)

                //span element 삭제
                td = document.createElement("td")
                tt = document.createTextNode("삭제")
                at = document.createAttribute("class")
                at.value = "delete";
                td.setAttributeNode(at)

                at = document.createAttribute("data-num")
                at.value = cmtlist[i].num;
                td.setAttributeNode(at)

                td.appendChild(tt)
                tr.appendChild(td)

                commentList.appendChild(tr)
            }   
        }
    })
} //코멘트리스트 1p받아오기 끝

//더보기 버튼 클릭하면 코멘트 리스트 추가하기
cmtmore.addEventListener("click", function(){
    cmtPage +=1;
    console.log(cmtPage)

    getCommentList()
})

//수정이나 삭제를 누르면!
commentList.addEventListener("click",function(event){
    console.log(event.target)

    if(event.target.getAttribute("class") =="delete"){
        let check = window.confirm("삭제하시겠습니까?")

        //삭제하겠습니까 에 네를 누르면
        if(check==true){
            
            //DB에 연결해 삭제
            cmtDel(event.target.getAttribute("data-num"));

            // 프론트 삭제방법1. remove로 해당 부분만 삭제하기
            // commentList.removeChild(event.target.parentNode)
    
            // 프론트 삭제방법2. 해당cmt페이지 다시 리로드하기
            cmtPage = 1
            getCommentList()

        }
    }
    else if(event.target.className =="update"){
        alert("수정")

        console.log(upCmt)
        upCmt.click();

        let con = event.target.previousSibling.previousSibling.previousSibling
        let conV = con.innerHTML;

        con.innerHTML = "<textarea>"+conV+"</textarea>"

    }
})


//댓글 삭제 DB연결
function cmtDel(num){
    const xhttp = new XMLHttpRequest();

    xhttp.open("POST", "./commentDelete");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")

    xhttp.send("num="+num);

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            if(xhttp.responseText.trim() == "1"){
                alert("삭제완료")
            }else{
                alert("삭제실패")
            }
        }
    })
}