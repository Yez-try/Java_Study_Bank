
//HTML내에서는 EL코드를 쓸 수 있지만, 외부 파일에서는 EL코드를 쓸 수 없다
// let kind = '${param.kind}' //따옴표가 없으면 변수명이라고 생각한다.
// alert(kind) 

function addjs(){
    const fileAdd = document.getElementById("fileAdd")
    const addFiles = document.getElementById("addFiles")

    let countfiles = 0;
    let idx = 0;

    
    file.addEventListener("change", function(){
        const file = document.getElementById("file");
        let data = new FormData();
        data.append("file",file.files[0])
        data.append("path","resources/test")

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "http://localhost:8085/uploadFile",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log(data)
                console.log(file.files[0].name)
                alert('success')
            },
            error: function (e) {
                
                alert('fail');
            }
        });
    })
    
    fileAdd.addEventListener("click",function(){
        if(countfiles<5){
            
            //부모 Element div생성
            let pdiv = document.createElement("div")
            let c = document.createAttribute("id")
            c.value = "file"+idx
            pdiv.setAttributeNode(c)

            //라벨만들기
            let lb = document.createElement("label")
            let al = document.createAttribute("for")
            al.value = "files"
            lb.setAttributeNode(al)
            lb.innerText="파일첨부"
    
            pdiv.append(lb)
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
            
            pdiv.append(inputfile)

            //삭제 버튼 만들기
            let plusbutton = document.createElement("button")
            let btnType = document.createAttribute("type")
            btnType.value = "button"
            let btnClass = document.createAttribute("class")
            btnClass.value = "del btn-dark btn-small"
            let btnContents = document.createTextNode("삭제")
            plusbutton.setAttributeNode(btnType)
            plusbutton.setAttributeNode(btnClass)
            plusbutton.appendChild(btnContents)

            let buttonAttr = document.createAttribute("title")
            buttonAttr.value = idx;
            plusbutton.setAttributeNode(buttonAttr);

            pdiv.append(plusbutton)

            //pdiv를 addfiles div에 append
            addFiles.append(pdiv)

            //추가된 파일 갯수 cnt증가
            countfiles = countfiles + 1;
            idx++
        }else{
            alert("파일추가는 5개까지만 가능합니다.")
        }

    })//파일 추가 버튼 클릭시 이벤트 종료

    addFiles.addEventListener("click", function(event){

        let button = event.target;

        if(button.classList[0] =="del"){
            alert(event.target.title)

            const divdel = document.getElementById("file"+event.target.title)
            addFiles.removeChild(divdel)
            
            countfiles--;
            
            
        }
    })


}