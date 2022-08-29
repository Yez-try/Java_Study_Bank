console.log('dom_1');

let result = window.confirm("확인????"); //버튼이 확인, 취소가 나오는 알럿
console.log("result : ", result);

result = window.prompt("이름을 입력하세요");
console.log("result :", result);

//dom_1.html의 태그의 id에 'd1'을 지정
let d1 = window.document.getElementById("d1");
window.alert(d1); //object HTMLHeadingElement 이다. 라고 
window.console.log(d1); // 자세한 내용

d1.innerHTML = '<h1>'+result+'</h1>';

document.getElementById("d2");
console.log(d2.innerHTML); //콘솔에 id = d2의 사이에 있는 contents를 출력해준다.(HTML태그까지 가져온다.)
console.log(d2.innerText); //순수한 텍스트만 가져온다

//d3내부의 태그를 d4에 넣자
let d3 = document.getElementById("d3");
let d4 = document.getElementById("d4");
d4.innerHTML = d3.innerHTML;
