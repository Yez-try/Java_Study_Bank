const ch = document.getElementsByClassName("ch");
const all = document.getElementById("all");
const cb = document.getElementsByClassName("cb");


for(let i=0;i<ch.length;i++){
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    })
}
//전체선택 체크 및 해제
// all.onclick = function(){
//     if(all.checked==true){
//         for(let i = 0; i<cb.length; i++){
//             cb[i].checked = true;
//         }
//     }
//     if(all.checked==false){
//         for(let i = 0; i<cb.length; i++){
//             cb[i].checked = false;
//         }
//     }
// }

// 일부 선택 해제시 전체선택 체크 해제
// for(let i=0;i<cb.length;i++){
//     cb[i].addEventListener("click", function(){
//         if(cb[i].checked==false){
//             all.checked=false;
//         }
//     })
// }
//강사님 코드 전체선택 체크 및 해제
all.onclick = function(){
    for(let i = 0; i<cb.length; i++){
        cb[i].checked = all.checked;
    }
}

//강사님 코드 
for(let i = 0; i<cb.length;i++){
    cb[i].addEventListener("click",check);
}
// 강사님 코드 일부 선택 해제시 전체선택 체크 해제
function check(){
    let result = true;
    for(let i=0;i<cb.length;i++){
        if(!cb[i].checked){
            result=false;
            break;
        }
    }
    all.checked=result
}