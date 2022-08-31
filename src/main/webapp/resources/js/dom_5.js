//dom_5.js
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const lb = document.getElementById("lb");
const d3 = document.getElementById("d3");
const d5 = document.getElementById("d5");
const d4 = document.getElementById("d4");
const won = document.getElementById("won");

d2.addEventListener("focus", function(){
    console.log("입력준비")
})

d2.addEventListener("blur", function(){
    console.log("블러")
})

//d1에 입력하고 나왔을때 (블러발생시) 글자의 길이가 3글자 이하라면 d1에 강제로 입력 대기 상태로 변경

d1.addEventListener("blur", function () {
    let str = d1.value
    if(str.length<=3){
        d1.focus()
        lb.innerText="4글자 이상 입력해주세요"
    }else{
        lb.innerText=""
    }
    
})

d3.addEventListener("change", function(){
    //change이벤트는 내용이 변경된 후 블러됐을때 발생
    console.log("change Event 발생")
})
//select도 change이벤트가 가능할까?
d5.addEventListener("change", function(){
    console.log("select change")
})


d4.addEventListener("keyup",function(){
    console.log("keyup 키를 눌렀다 뗐을때")
    let str = d4.value
    won.innerText=str.length*1000+"원"
})

