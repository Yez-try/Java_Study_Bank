const d1 = document.getElementById("d1")
const d2 = document.getElementById("d2")
const btn2 = document.getElementById("btn2")

d1.innerHTML = 'hello'

//function 함수명(){}
function test(){
    alert("Click Event 실행");
    //test2의 함수의 위치가 더 아래쪽이지만 이름이 있다면 찾아서 실행해준다.
    let result = test2(1,2);
    console.log(result);
    f1(); //f1이라는 함수를 호출합니다. 처럼 사용(변수에 담았지만!)
}
//이름 있는 함수
function test2(num1, num2){
    let result = num1+ num2;
    return result
}

//익명함수-함수명이 없는 함수
//변수명이 없으면 불러올 수가 없는데 어떻게 쓰지?
let f1 = function (){
    console.log("익명함수 실행")
}//함수 자체도 변수에 담을 수 있음!

//Event 적용1
// d2.onclick = test(); //클릭하지도 않았는데 함수가 실행되어 버림
//=test() 부분이 함수를 호출하세요 라는 뜻이므로 당장 실행되어버림
//정작 이미지를 눌러도 반응이 없음 (이미 실행했으므로)
//이런경우 함수 호출시 괄호를 빼고 이름만 써준다.
d2.onclick = test;

//Event 적용 2
// 콜백 함수 : 익명함수를 바로 실행하는 형태
d3.onclick = function(){
    console.log("click 콜백함수 실행")
};

//Event 적용 3 : 추천방법
//
// btn2.addEventListener("Click",f1);
btn2.addEventListener("click", function(){
    console.log("event Listner 실행")
})