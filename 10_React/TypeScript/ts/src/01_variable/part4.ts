// any
// 특정 변수의 타입을 확실하게 정할 수 없을 때

let num1: any = "10"; // any 타입이라 숫자가 들어갈 수도 있으니 typescript에서 에러가 안난다
let num2: number = 20; // 하지만 실행하면 문제가 생기겠지

num2 = num1; // 타입 안정성이 없음

// unknown : any와 기능이 동일, 그러나 unknown은 사용할때 타입검사 하라는 약속
// any와 다르게 다른 변수에 unknown 값 할당은 불가능 => 더 안전
let num3: unknown; // unknown이면 타입검사를 하라는 명시적인 약속

if(typeof num3 === "number") {
    let num4 = num3;
}

// void -> 함수가 아무것도 반환하지 않을 떄 사용함
function func01(): string{
    return "안녕~"; // 문자열 반환
}

function func02(text: string): void {
    console.log(text)
    // 함수가 아무것도 반봔하지 않음
}

// never
// never은 존재하지 않는 것
// 절대 종료되지 않거나, 값을 반환하지 않을 경우 사용

function func03(): never{
    while(true) {}
}

function func04(): never{
    throw new Error(); // 오류발생으로 인해 함수가 종료되지 않음
}

let num8: never;
// num8 = null; never타입 변수에는 어떠한 값도 넣을 수 없음