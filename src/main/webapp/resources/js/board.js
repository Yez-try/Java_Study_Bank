
//HTML내에서는 EL코드를 쓸 수 있지만, 외부 파일에서는 EL코드를 쓸 수 없다
// let kind = '${param.kind}' //따옴표가 없으면 변수명이라고 생각한다.
// alert(kind) 

function addjs(){
    const fileAdd = document.getElementById("fileAdd")
    const addFiles = document.getElementById("addFiles")

    let countfiles = 0;

    fileAdd.addEventListener("click",function(){
        if(countfiles<5){

            //라벨만들기
            let lb = document.createElement("label")
            let al = document.createAttribute("for")
            al.value = "files"
            lb.setAttributeNode(al)
            lb.innerText="파일첨부"
    
            addFiles.append(lb)
            //input 태그 만들기
            let inputfile = document.createElement("input")
            let typei = document.createAttribute("type")
            typei.value="file"
            let typei2 = document.createAttribute("name")
            typei2.value="files"
            let typei3 = document.createAttribute("class")
            typei3.value = "form-control"
    
            inputfile.setAttributeNode(typei)
            inputfile.setAttributeNode(typei2)
            inputfile.setAttributeNode(typei3)
            
            addFiles.append(inputfile)
            countfiles = countfiles + 1;
        }else{
            alert("파일추가는 5개까지만 가능합니다.")
        }

    })


}