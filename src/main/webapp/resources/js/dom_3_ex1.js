const d1 = document.getElementById("d1")
const d2 = document.getElementById("d2")
const d3 = document.getElementById("d3")
const btn = document.getElementById("btn")
const btn2 = document.getElementById("btn2")
const btn3 = document.getElementById("btn3")
const select = document.getElementById("select")
const btn4 = document.getElementById("btn4")
//id는 getElement 한개만 가져올 수 있다.
//classname은 getElements 여러개를 가져올 수 있다.
const c1  = document.getElementsByClassName("c1")

btn.addEventListener("click", function(){

    let result =0;
    if(select.value=='+'){
        result =Number.parseInt(d1.value)+(d2.value*1)
    }else if(select.value=='-'){
        result = Number.parseInt(d1.value)-(d2.value*1)
    }else if(select.value=='/'){
        result = Number.parseInt(d1.value)/(d2.value*1)
    }else if(select.value=='*'){
        result = Number.parseInt(d1.value)*(d2.value*1)
    }else if(select.value=='%'){
        result = Number.parseInt(d1.value)%(d2.value*1)
    }

    d3.setAttribute("value", result)
    

    // 곱하기 할 때는 잘 계산되는데 , 더하기 연산을 하면 문자열처럼 연산된다.
    // 숫자로 형변환 방법
    // Number.parseInt를 해도 되고, 곱하기 하면 숫자로 변환되므로 *1 해줘도 된다.
})

btn2.addEventListener("click", function(){
    alert("버튼 2 클릭, 이벤트 발생")
})

btn3.addEventListener("click", function(){
    btn2.click();
})

btn4.onclick = function(){
    alert(c1)
    // console.log(c1) //c1은 입력태그를 모아놓은 배열
    // console.log(c1.value) //배열이므로 value속성이 없다.

    for(let i=0;i<c1.length;i++){
        console.log(c1[i].value+"의 selected값: "+c1[i].selected)
    }
    
}
