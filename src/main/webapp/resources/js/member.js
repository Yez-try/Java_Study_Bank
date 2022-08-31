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
    const cb = document.getElementsByClassName("cb");
    const joinAgrebtn = document.getElementById("joinAgrebtn");
    const agreform = document.getElementById("agreform");
    const req = document.getElementsByClassName("req");

    all.addEventListener("click", function(){
        for(let i=0;i<cb.length;i++){
            cb[i].checked=all.checked;
        }
    })

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