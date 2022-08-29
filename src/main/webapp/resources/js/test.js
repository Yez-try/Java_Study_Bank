

var num=1; //var의 경우, 지역변수, 전역변수시 문제가 발생할 수 있어 let사용을 권장한다.
num ='hello';

alert(num);

var num1=1;
let num2 = '1';

console.log(num1==num2);  //true//System.out.println() 과 같이 콘솔에 찍어주세요 라는 뜻
console.log(num1===num2); //false //값도 같고 타입도 같아야 true

console.log("----------------var---------------")
for(var i=0;i<10;i++){
    console.log(i);
}
console.log("----------------------------")
console.log(i);

console.log("------------let------------")
for(let j=0;j<10;j++){
    console.log(j);
}

console.log("----------------------------")
// console.log(j);


console.log("------------------Array------------")
let ar = [1,'2',3.12, true];
console.log(ar[0]);
console.log(ar[1]);
ar.push(5);
console.log(ar);
ar.unshift('9');
ar.sort(); //오름차순
console.log(ar);
console.log("-------------------reserse--------------");
ar.reverse();
console.log(ar);

ar.forEach(function(v, i, ar){
    window.console.log("v: ",v );
    console.log("i: ",i);
    console.log("----------------------------");
})