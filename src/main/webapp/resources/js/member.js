//login버튼을 클릭하면 form에 있는 submit 이벤트를 강제로 발생시키기
function loginjs(){

    const loginbtn = document.getElementById("loginbtn")
    const loginform = document.getElementById("loginform")
    const inputid = document.getElementById("inputid")
    const inputpw = document.getElementById("inputpw")
    const validation = document.getElementById("validation")
    
    loginbtn.addEventListener("click",function(){
     
        if(inputid.value==""){
            validation.innerHTML="아이디를 입력해주세요"
        }else if(inputpw.value==""){
            validation.innerHTML="비밀번호를 입력해주세요"
        }else{
            loginform.submit()
        }
    })
    
    
    
    // loginbtn.onclick = function(){
    //     if(inputid.value==""){
    //                 alert("아이디를 입력해주세요")
    //             }else if(inputpw.value==""){
    //                 alert("비밀번호를 입력해주세요")
    //             }else{
    //                 loginform.submit()
    //             }
    // };
}

function joinAgrejs(){
    const all = document.getElementById("all");
    // const cb = document.getElementsByClassName("cb");
    const cb = document.querySelectorAll(".cb"); //클래스를 의미하는 .을 붙여준다.
    const joinAgrebtn = document.getElementById("joinAgrebtn");
    const agreform = document.getElementById("agreform");
    const req = document.getElementsByClassName("req");

	console.log("foreach"); 
	//클래스 네임으로 가져온 cb변수는 배열이 아닌 유사배열임.(실제 배열이 아님) 그러므로 forEach가 없음
	//getElementsByClassName 말고 querySelectorAll을 사용하면 배열로 리턴해줌
	cb.forEach(function(v,i,ar){ 
		console.log(v);
	});

	//전체동의체크 및 해제
    all.addEventListener("click", function(){
        for(let i=0;i<cb.length;i++){
            cb[i].checked=all.checked;
        }
    })

	//개별동의버튼 클릭해제시
    for(let i=0;i<cb.length;i++){
        cb[i].addEventListener("click", function(){
            if(!cb[i].checked){
                all.checked=false
            }
        })
    }

    joinAgrebtn.addEventListener("click", function(){
        let agrechk = true
        for(let i=0;i<req.length;i++){

            if(!req[i].checked){
                alert("필수약관에 동의해주세요.")
                agrechk = false;
                break;
            }
        }
        if(agrechk){
            agreform.submit()
        }
    })

}


function joinjs(){
    const id = document.getElementById("id")
    const lid = document.getElementById("lid")
    const pw = document.getElementById("pw")
    const lpw = document.getElementById("lpw")
    const pwchk = document.getElementById("pwchk")
    const lpwchk = document.getElementById("lpwchk")
    const joinIp = document.getElementsByClassName("joinIp")
    const joinMsg = document.getElementsByClassName("joinMsg")
    const name = document .getElementById("name")
    const lname = document .getElementById("lname")
    const email = document.getElementById("email")
    const lemail = document.getElementById("lemail")
    const phone = document.getElementById("phone")
    const lphone = document.getElementById("lphone")
    const joinButton = document.getElementById("joinButton")
    const joinForm = document.getElementById("joinForm")

    //chk결과
    let idCheck = false
    let pwCheck = false
    let pwchkCheck = false
    let nameCheck = false
    let emailCheck = false
    let phoneCheck = false

    id.focus()

    //joinButton CLICK
    joinButton.addEventListener("click", function(){

        if(idCheck&&pwCheck&&chkpwCheck&&nameCheck&&emailCheck&&phoneCheck){
            joinForm.submit()
        }else{
            alert("회원가입 폼을 전부 작성해주세요")
        }
    })



    //idCheck하기
    id.addEventListener("blur",function(){
        let t = id.value
        let msg = ""
        
        if(t.length<2){
            msg = "ID는 2글자 이상이어야 합니다"
            id.focus()
            idCheck = false
        }else{
            idCheck = true
        }
        lid.innerText= msg
    })
    
    //pwCheck하기
    pw.addEventListener("keyup", function(){
        let t = pw.value
        let msg = ""

        if(false){
            //정규표현식을 사용해서 비밀번호 검사
        }

        if(t.length<6){
            msg = "비밀번호는 6글자 이상이어야 합니다."
            pwCheck = false
        }else{
            //숫자포함, 대문자포함, 소문자포함
            const regex1 = /[0-9]/
            const regex2 = /[a-z]/
            const regex3 = /[A-Z]/

            console.log("숫자"+ regex1.test(t))
            console.log("소문자"+regex2.test(t))
            console.log("대문자"+regex3.test(t))
            if(regex1.test(t)&&regex2.test(t)&&regex3.test(t)){
                msg = "숫자는 입력할 수 없습니다."
                nameCheck = false
            }else{
                nameCheck = true
            }
        }

        lpw.innerHTML = msg
    })
    //pwCheck하기 , 6글자 이상이면 pwchk폼으로 강제 이동(pw확인 절차를 강제하기 위함)
    pw.addEventListener("blur", function(){
        let t = pw.value
        
        if(t.length<6){
            pw.focus()
        }else{
            pwchk.focus()
        }
    })

    //pwchk Check
    pwchk.addEventListener("blur", function(){
        let t = pwchk.value
        let msg = ""
        
        if(t!=pw.value){
            console.log("chkpw"+pw.value)
            console.log(""+t)
            msg = "비밀번호가 다릅니다."
            pwchk.focus()
            pwchkCheck = false
        }else{
            msg = "비밀번호를 확인했습니다"
            pwchkCheck = true
        }
        lpwchk.innerHTML = msg            
    })

    //nameCheck하기
    name.addEventListener("blur",function(){
        let t = id.value
        let msg = ""
        
        if(t.length<2){
            msg = "필수입력값입니다"
            name.focus()
            nameCheck = false
        }else{
            //숫자제외
            const regex = /[^0-9]/;
            if(!regex.test(t)){
                msg = "숫자는 입력할 수 없습니다."
                nameCheck = false
            }else{
                nameCheck = true
            }
        }
        lname.innerText= msg
    })

    //emailCheck하기
    email.addEventListener("blur",function(){
        let t = id.value
        let msg = ""
        
        if(t.length<2){
            msg = "필수입력값입니다"
            email.focus()
            emailCheck = false
        }else{
            const regex = /\d{3}-\d{4}-\d{4}/;
            if(!regex.test(t)){
                msg = "000-0000-0000형식으로 입력해주세요"
                nameCheck = false
            }else{
                phoneCheck = true
            }
        }
        lemail.innerText= msg
    })

    //phoneCheck하기
    phone.addEventListener("blur",function(){
        let t = id.value
        let msg = ""
        
        if(t.length<2){
            msg = "필수입력값입니다"
            phone.focus()
            phoneCheck = false
        }else{
            const regex = /\d{3}-\d{4}-\d{4}/;
            if(!regex.test(t)){
                msg = "000-0000-0000형식으로 입력해주세요"
                nameCheck = false
            }else{
                phoneCheck = true
            }
        }
        lphone.innerText= msg
    })



}

