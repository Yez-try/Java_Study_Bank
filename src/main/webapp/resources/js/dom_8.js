const count = document.getElementById("count")
const btn = document.getElementById("btn")
const result = document.getElementById("result")
const c1 = document.getElementById("c1")
const d1 = document.getElementById("d1")
const d1_1 = document.getElementById("d1_1")
const d1_1_1 = document.getElementById("d1_1_1")
const google = document.getElementById("google")

google.addEventListener("click", function(event){
    alert("Go google")  //알럿이 먼저 실행된 후에 google로 이동한다
    // event.preventDefault(); //이코드를 사용하면 기본 a 태그에 적용된 이벤트 (구글로 이동)이 실행되지 않는다.
})

// 캡쳐링 테스트
// d1.addEventListener("click", function(event){
//     event.stopPropagation(); //캡쳐링 이벤트 중단
//     console.log("d1 click")
//     // event.stopImmediatePropagation(); //해당 Element에 있는 모든 이벤트 전달을 중단할 때(click뿐 아니라 blur등 다른 이벤트도 있는 경우)
// }, true)
// d1_1.addEventListener("click", function(){
//     console.log("d1_1 click")
// }, true)
// d1_1_1.addEventListener("click", function(){
//     console.log("d1_1_1 click")
// }, true)
        
// 버블링 테스트(default) 
d1.addEventListener("click", function(event){
    console.log("d1 click")
    console.log(event) //target실제 누른 영역이 어디냐
    console.log(event.currentTarget) //부모영역
    console.log(event.target) //내가 누른영역

    if(event.target.className=="buttons"){ //이벤트 위임 (부모영역에 click 이벤트를 주고 , 내부에 자식 내용을 만든다)
        alert("button")
        console.log("this:", this)//this는 부모영역
        alert(event.target.innerHTML);
    }
}, false)
// d1_1.addEventListener("click", function(){
//     console.log("d1_1 click")
// }, false)
// d1_1_1.addEventListener("click", function(event){
//     console.log("d1_1_1 click")
//     // event.stopPropagation(); //버블링 이벤트 중단 (이벤트 전달을 막아버린다.)
// }, false)

btn.addEventListener("click", function(){
    
    let cnt = count.value
    
    for(let i =0; i<cnt; i++){
        console.log("for"+i)
        let button = document.createElement("button")
        let t = document.createTextNode("click"+i)
        button.appendChild(t)
        let clas = document.createAttribute("class")
        clas.value = "c1"
        button.setAttributeNode(clas)

        result.append(button)
    }

    // for(let i =0; i<c1.length; i++){
    //     c1[i].addEventListener("click", function(){
    //         alert(c1[i].innerHTML)
    //     })
    // }

    // for(c of c1){
    //     c.addEventListener("click", function(){
    //         alert(c1[i].innerHTML)
    //     })
    // }
})

//--
result.addEventListener("click", function(event){
    if(event.target.className=='c1'){
        alert(event.target.innerHTML)
    }
})

