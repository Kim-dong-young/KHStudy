console.log('hello world')

/**
 * js의 변수 선언
 * 
 * 1) var - 안씁니다.
 * 2) let
 * 3) const
 */

var name = '최지원';
var age = 55;
var height = 190.7;
var isTrue = true;

var name = '김수민'; // 이미 선언된 변수를 또 선언되도 오류가 없음
console.log(name + " " + age + " " + height + " " + isTrue)

/**
 * let은 var에서 같은이름의 중복생성을 하지 못하게 만든 자료형이다.
 * 다만 let과 var는 모두 값을 변경하는 것은 가능하다.
 */

let name2 = '최지원';
// let name2 = '김수민'; => SyntaxError: Identifier 'name' has already been declared

/**
 * const는 상수를 표현하기위한 자료형
 * 값을 변경할 수 없음
 */

const name3 = '최지원';
//name3 = '김지원'; // TypeError: Assignment to constant variable.

/**
 * js네이밍 규칙
 * 
 * 변수이름 지을 때
 * 1) 일반적으로 영어를 사용하며 문자와 숫자 모두 사용할 수 있음
 * 2) 특수문자는 언더스코어(_)와 달러($)를 사용할 수 있음
 * 3) 숫자로 시작하면 안됨
 * 4) 키워드를 변수명으로 사용하면 안됨
 * 
 * 네이밍 타입
 * 1) camelCase -> 대부분의 언어에서 많이 사용하며 단어의 시작마다 대문자로 구분해준다.
 * 2) snake_case -> 파이썬에서 주로 사용하며 단어의 시작마다 _로 구분해준다.
 * 3) PascalCase -> c#및 ms계열 언어에서 많이 사용하며, 매 단어 시작은 무조건 대문자
 */

let $name = '김민수';
let _name = '최민수';

/**
 * Data Types
 * 
 * 6개의 원시타입, 1개의 Object 타입이 있음.
 * 
 * 1) Number
 * 2) String
 * 3) Boolean
 * 4) undefined - 개발자가 값을 아예 넣은적이 없을 때
 * 5) null - 개발자가 의도적으로 값이 없다 표기
 * 6) Symbol - 유일한 수를 표현할?때, 잘 안쓰는듯 몰?루
 * 
 * 7) Object
 *      - Function
 *      - Array
 *      - Object
 *      - 등등...
 */

// Number 타입
const age2 = 55;
const temperature = -10;
const pi = 3.14;

// console.log(age2, temperature, pi)
// typeof : 변수 타입 확인
console.log(typeof age2, typeof temperature, typeof pi)

// Infinity : 무한(엄청 큰)값
console.log(typeof Infinity)
console.log(typeof -Infinity)

// String타입
const num1 = 55
console.log(num1 == "55") // 값만 같은가?
console.log(num1 === "55") // 값 + 타입까지 같은가?

// escape문자 존재
console.log('안녕하세요 저는 최지원입니다.\n\t 나이는 51살입니다.')

// Boolean 타입
const isTrue2 = true;
const isFalse = false;
console.log(typeof isTrue2)
console.log(typeof isFalse)

/**
 * undefined
 * 개발자가 직접 값을 초기화하지 않았을 때
 * 지정되는 값이다.
 * 
 * undefined를 직접 넣어주는 것은 지양해야한다.
 */

let num2;
console.log(num2 === undefined);

/**
 * null 타입
 * undefined와 동일하게 값이 없음을 표시
 * 다만 js에서는 개발자가 직접 명시적으로 없는 값을 초기화 할 때 사용
 */

let init = null;
console.log(null)

if(!init){
    console.log('null이다.')
}

/**
 * Symbol 타입
 * 
 * 유일무이한 값을 생성할 때
 * 다른 원시값들과 다르게 Symbol함수를 호출해서 사용
 */

const tmp1 = '1';
const tmp2 = '1';

console.log(tmp1 === tmp2)

const symbol1 = Symbol('1');
const symbol2 = Symbol('1');
console.log(symbol1, symbol2)
console.log(symbol1 === symbol2)

/**
 * Object타입
 * 
 * 키 : 밸류 쌍으로 이루어져있다.
 * key : value
 */

// 자바스크립트에선 객체, json과 형태만 비슷할 뿐, 보낼때 json으로 변형함.
const man = {
    name : '최지원',
    age : 47,
    address : '경기도',
    value : '강사',
    printInfo : function(){
        console.log(this.name + '입니다.')
        return "10";
    }
}

man.value = '무직';
let func1 = man.printInfo();
let func2 = man.printInfo;
let value2 = func2();

console.log(typeof man)

/**
 * Array타입
 * 
 * 값을 리스트로 나열할 수 있는타입
 */

const arr = [];
arr.push('빨간색')
arr.push('주황색')
arr.push('파란색')

console.log(arr.pop()); // 꺼내고 사라짐

console.log(arr[0], arr[1])