//dom_6.js

const btn = document.getElementById("btn")
const d1 = document.getElementById("d1")
const list = document.getElementById("list")
const addBtn = document.getElementById("addBtn")
const addBtn2 = document.getElementById("addBtn2")
const list2 = document.getElementById("list2")
const addBtn3 = document.getElementById("addBtn3")
const d2 = document.getElementById("d2")
const BtnBf = document.getElementById("BtnBf")
const BtnAf = document.getElementById("BtnAf")

btn.addEventListener("click", function(){
    d1.innerHTML='<img src="/resources/img/cuteYuri.png">'
    //안에 있는 내용이 덮어씌워진다.
})

addBtn.addEventListener("click", function(){
    // list.append('<li>test</li>') //HTML이 아닌 문자열로 인식한다.
    let li = document.createElement("li") //li태그를 하나 만든다.
    let t = document.createTextNode("test"); //텍스트노드를 생성한다 (이걸 li태그 내부에 넣어주려고 한다.)
    li.appendChild(t)   //<li>test</li>

    list.append(li);//아래로 추가
})

addBtn2.addEventListener("click", function(){
    let li = document.createElement("li") //<li></li>
    let h = document.createElement("h3"); // <h3></h3>
    let t = document.createTextNode("Hello") // Hello
    h.appendChild(t);  //<h3>Hello</h3>
    li.appendChild(h);//<li><h3>Hello</h3></li>
    list2.prepend(li) //자식 목록 중 맨 위로 추가
})

//add3을 클릭하면 div#d2 내에 input Element를 append
addBtn3.addEventListener("click", function(){
    let ip = document.createElement("input")//<input>태그 하나만 생성됨, 속성이 필요함
    let ch = document.createAttribute("type") //type=  속성만들기
    ch.value = "checkbox"; //type="checkbox"
    ip.setAttributeNode(ch) //<input type="checkbox">

    d2.append(ip)
})

//BtnBf를 클릭하면 div#d3에 before
BtnBf.addEventListener("click", function(){
    let h = document.createElement("h3")
    let t = document.createTextNode("Before")

    h.appendChild(t)
    d3.before(h); //d3의 외부의 위에 만들어진다.
})

BtnAf.addEventListener("click", function(){
    let h = document.createElement("h3")
    let t = document.createTextNode("After")

    h.appendChild(t)
    d3.after(h); //d3의 아래에 만들어진다.
})