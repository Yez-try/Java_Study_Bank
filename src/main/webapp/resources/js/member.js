//login버튼을 클릭하면 form에 있는 submit 이벤트를 강제로 발생시키기

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