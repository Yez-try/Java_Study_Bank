//dom_7.js

const remove1 = document.getElementById("remove1"); //button#remove1
const remove2 = document.getElementById("remove2"); //button#remove2
const d1 = document.getElementById("d1");//div#d1
const d2 = document.getElementById("d2");//div#d2
let d2_1 = document.getElementById("d2_1");
const d2_child = document.getElementsByClassName("d2_child");

//d1포함 삭제
remove1.addEventListener("click", function(){
    
    d1.remove()
})

//d2는 남기고 자식 태그만 삭제
remove2.addEventListener("click", function(){

    // d2.removeChild(d2_1) //child중에 누구를 삭제할지 지정해주어야 함
    let len = d2_child.length

    for(let i=0; i<5; i++){

        //id로 지우는 방법
        // const d2_1 = document.getElementById("d2_"+i)

        // d2.removeChild(d2_1)

    }

    //id로 배열만들어 push 사용하기
    let ar = []
    for(let i=0;i<d2_child.length;i++){
        ar.push(d2_child[i].id)
    }
    for(i of ar){
        let d = document.getElementById(i)
        d2.removeChild(d)
    }

    // //내방법
    // for(let i = d2_child.length-1; i>=0 ; i--){
    //     d2.removeChild(d2_child[i])
    // }

})