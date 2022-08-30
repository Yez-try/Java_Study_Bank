let d1 = document.getElementById("d1");

//element의 속성값을 가지고오는 방법 2가지
//1.선택자.getAttribute(속성명)
window.alert(d1.getAttribute("value"));
//2.선택자.속성명
window.alert(d1.value);


//element 의 속성값을 변경하는 방법 2가지
let d2 = document.getElementById("d2");
d2.type = "button"
let d2_1 = document.getElementById("d2_1");
d2_1.setAttribute("type","button")

const d3 = document.getElementById("d3");

let count = window.prompt("숫자를 입력하세요");

let html_text ='';
for(let i = 0;i<count;i++){
    html_text +='<input type="text">';
}
d3.innerHTML = html_text;

//년
let year = document.getElementById("year");

let optionY = "";
for(let i=2022;i>=1900;i--){
    optionY += "<option>"+i+"년</option>";
}
year.innerHTML = optionY;

//월
let month = document.getElementById("month");

let optionM = "";
for(let i=1;i<=12;i++){
    optionM += "<option>"+i+"월</option>";
}
month.innerHTML = optionM;

//일
let date = document.getElementById("date");
let optionD = "";
for(let i=1;i<=31; i++){
    optionD +="<option>"+i+"일</option>";
}
date.innerHTML = optionD;

let row = window.prompt("row입력")
let col = window.prompt("col입력")

let textR ="";
for(let i=0;i<row;i++){
    textR = textR+ "<tr>"
    for (let j=0;j<col;j++){
        textR = textR +"<td>"+(i+1)+"행"+(j+1)+"열</td>";
    }
    textR = textR+"</tr>"
}
let d4 = document.getElementById("d4");
d4.innerHTML = textR;
