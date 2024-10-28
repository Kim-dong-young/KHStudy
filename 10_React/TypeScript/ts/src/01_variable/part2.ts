// 배열
let numArr: number[] = [10,20,30];

let strArr: string[] = ["my", "name", "is", "jiwon"];
let strArr2: Array<string> = ["my", "name", "is", "jiwon"];

// 배열에 들어가는 타입이 두가지 이상이다.
let multiArr: (string | number)[] = [ 10, "jiwon", 20 , 30 , "name"];

// 튜플
let tuple: [number, string, number] = [10, "two", 30]; // 원소의 갯수, 순서까지 제한

// 객체
// let user = {
//     name: "jiwon",
//     age: 20,
//     address: "경기도 안양"
// }

let user: {
    name: string,
    age: number;
    address?: string, // ? : 선택적 속성, 없을수도 있다
} = {
    name: "지원",
    age: 20
    // address: "경기도 하남시"
}

let math: {
    readonly pi: number, // 읽기만 가능, 변경불가
} = {
    pi: 3.14
}

