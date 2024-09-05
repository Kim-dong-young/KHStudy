/**
 * 클로저
 * 
 * "클로저는 어떤 함수와 해당 함수가 선언된 정적 환경의 조합"
 * 
 * 내부 함수에서 외부 함수의 변수를 사용할 때 우리는 클로저라고 한다
 * (상위 함수보다 하위 함수가 더 오래 살아있는 경우)
 */

let num = 5;
let num1 = 5;
let num2 = 5;
let num3 = 5;

function getNum(){
    let num = 5

    function inner(){
        // 이 시점에서 let num = 5가 포함되어 바인딩됨
        // 함수가 바인딩 될 떄, 외부에 있는 환경까지 포함되서
        // 같이 저장(바인딩)된다.
        num++;
        return num;
    }

    return inner;
}

let run = getNum();

console.log(run());
console.log(run());
console.log(run());
console.log(run());
console.log(run());
console.log(run());

function out(outValue){

    function inner(innerValue){
        console.log('outValue : ' + outValue)
        console.log('innerValue : ' + innerValue)
    }
    return inner;
}

const numOutFunc = out('외부함수'); // outValue까지(외부환경) 저장해서 함수를 가져온 것
numOutFunc('내부함수')

function getNumber(){
    let number = 5;

    function inner(){
        number++;
        return number
    }

    return inner;
}

let run2 = getNumber()

let run3 = getNumber()

let run4 = getNumber()

// 따로따로 변수가 저장됨을 확인 가능
console.log('run2')
console.log(run2())
console.log(run2())
console.log(run2())

console.log('run3')
console.log(run3())
console.log(run3())

console.log('run4')
console.log(run4())
console.log(run4())
console.log(run4())
console.log(run4())
