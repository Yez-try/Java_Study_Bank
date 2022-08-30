const d1 = document.getElementById("d1")
const d2 = document.getElementById("d2")
const d3 = document.getElementById("d3")
const btn = document.getElementById("btn")
const btn2 = document.getElementById("btn2")
const btn3 = document.getElementById("btn3")

btn.addEventListener("click", function(){
    d3.setAttribute("value", 
    Number.parseInt(d1.value)+(d2.value*1))

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

