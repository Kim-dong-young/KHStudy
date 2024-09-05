/**
 * 형변환
 * 
 * 1. 명시적
 * 2. 묵시적
 */

let age = 45;
console.log(typeof age)

// 명시적
let strAge = age.toString();
console.log(typeof strAge)

// 묵시적
let tmp = age + "";
console.log(typeof tmp)

/*
    명시적 형변환
*/
console.log((100).toString())
console.log((true).toString())
console.log((Infinity).toString())

// 숫자타입으로 변환
console.log(parseInt('0'))
console.log(parseFloat('3.14'))
console.log(+'0')

// boolean
console.log(!!'true') // js에선 뭔가 결과값이 있다면 다 true
let isTrue = 'false'
if(isTrue == 'true'){ // false구분을 위해 == 로 비교하면 된다

}

let member = {
    name: 'jiwon'
}

console.log(member == {name : 'jiwon'}) // Object 비교는 무조건!! False!!
console.log({name : 'jiwon'} == {name : 'jiwon'})


