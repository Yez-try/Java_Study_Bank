const d1 = document.querySelector("#d1")


//childNodes 실습
console.log(d1.childNodes) //공백도 자식으로 포함한다
console.log(d1.childNodes[3].innerHTML) //div태그의 innerHTML을 꺼내온다

console.log(d1.children) //공백은 포함하지 않는다
//1이라는 innerText를 출력하기
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML)
console.log(d1.children[1].children[0].children[0].innerHTML)

console.log(d1.children[1].children[0].childNodes)

// d1영역 클릭했을 때 li태그들을 전부 삭제 ul은 두고
d1.addEventListener("click", function(){
    let ul = d1.children[1].children[0]

    let len = ul.childNodes.length
    for(let i =0 ; i< len ; i++){
        ul.removeChild(ul.childNodes[0])
    }
})

// 위와 동일 문제, remove만 사용(removeCild x)
// d1.addEventListener("click", function(){

//     let li = d1.children[1].children[0].children
//     console.log(li)

//     let ar = []
//     for(l of li){
//         ar.push(l)
//     }
//     for(i of ar){
//         i.remove();
//     }
// })



//parentNode 실습
console.log("---------------------------------------------------")
const d1_2_1_3 = document.querySelector("#d1_2_1_3")

console.log(d1_2_1_3.parentNode.parentNode.parentNode)


//btn 버튼을 누르면 #d1_2 div태그를 지우려고 한다. d1_2_1_3 li태그부터 시작해 부모를 찾아올라가자
const btn = document.querySelector("#btn")

btn.addEventListener("click", function(){
    d1_2_1_3.parentNode.parentNode.remove() 

})


//sibling 실습
console.log("-----------------------------------------------------")
console.log(d1_2_1_3.previousSibling) //엔터키때문에 #text가 나온다
console.log(d1_2_1_3.previousSibling.previousSibling.innerHTML) //내 바로 옆(왼쪽)에 있는 애들을 가져온다.

console.log(d1_2_1_3.nextSibling.nextSibling.innerHTML) //내 바로 옆(오른쪽)에 있는 애들을 가져온다.


