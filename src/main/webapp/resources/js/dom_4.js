const ch = document.getElementsByClassName("ch");
const all = document.getElementById("all");
const cb = document.getElementsByClassName("cb");


for(let i=0;i<ch.length;i++){
    ch[i].addEventListener("click", function(){
        alert(ch[i].value);
    })
}

all.onclick = function(){
    if(all.checked==true){
        for(let i = 0; i<cb.length; i++){
            cb[i].checked = true;
        }
    }
}

for(let i=0;i<cb.length;i++){
    cb[i].addEventListener("click", function(){
        if(cb[i].checked==false){
            all.checked=false;
        }
    })
}