let members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남궁지원"
]

// push - 값을 넣고 길이를 반환
console.log('push')
console.log(members.push('신지원'))
console.log(members)

// slice(시작인덱스, 마지막인덱스 - 1) -> 잘라옴, 원본 영향 X
console.log('slice')
console.log(members.slice(1,3))
console.log(members)

// splice(시작인덱스, 개수) -> 잘라옴, 원본 영향 O 
console.log('splice')
console.log(members.splice(1,3))
console.log(members)

members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남궁지원"
]

let member2 = [
    ...members // 값을 그대로 복사해옴, 객체도 가능
]

console.log(member2)

let choi = {
    name : 'jiwon',
    age : 21,
    gender : '남'
}

// react는 real dom을 수정하지 않음
// 즉 수정이 없음, 값을 바꾸고 싶으면 원본을 복사하고 넣어야함

let choi2 = {
    ...choi,
    age : 20
}

console.log(choi2)

console.log("----------------------------------------------------------------")

// join('구분자') - 배열 합치기
console.log(member2.join()) // 기본값 : 쉼표(,)
console.log(member2.join('/'))
console.log(member2.join(' '))

// sort
member2.sort();
console.log(member2)
console.log(member2.reverse())

let numbers = [1,9,7,5,3]
console.log(numbers);

// a,b를 비교한다
// 1) a를 b보다 나중에 정렬하고 싶다면(뒤에두고 싶다면) 0보다 큰 수를 반환
// 2) a를 b보다 먼저 정렬하려면 (앞에두려면) 0보다 작은 숫자를 반환
// 3) 원래순서 유지하고 싶다면 0을 반환
numbers.sort( (a, b) => {
    // return a > b ? 1 : -1;  // 오름차순 정렬
    return a < b ? 1 : -1; // 내림차순 정렬
});
console.log(numbers);

console.log("----------------------------------------------------------------")

// map
// 기존배열의 요소를 전부 반복하면서
// return된 값으로 새로운 배열을 만들어주는 함수

/*
// let tmpMember = member2.map(function(m,i){return m;})
let tmpMember = member2.map(function(m, i){
    console.log(m)
    console.log(i)
    return {
        index : i,
        value : m
    }
})
console.log(tmpMember)
*/
let userList = [
    {
        userKey : 1,
        userName : '최지원',
        age : 22
    },

    {
        userKey : 2,
        userName : '김수민',
        age : 47
    },

    {
        userKey : 3,
        userName : '박지수',
        age : 35
    }
]

let buyHistory = [
    {
        userKey : 2,
        productName : 'TV',
        price : 50000
    },
    
    {
        userKey : 2,
        productName : '모니터',
        price : 20000
    },

    {
        userKey : 1,
        productName : '컴퓨터',
        price : 150000
    },

    {
        userKey : 3,
        productName : '냉장고',
        price : 10000
    },

    {
        userKey : 1,
        productName : '가습기',
        price : 7500
    }
]

buyHistory = buyHistory.map( (history) => {
    for(let user of userList){
        if(user.userKey === history.userKey){
            return {
                ...user,
                ...history
            }
        }
    }
})

console.log(buyHistory)

buyHistory = buyHistory.map((h,i) => {
    return {
        ...h,
        index : i + 1,
    }
})

console.log(buyHistory)

console.log("----------------------------------------------------------------")

// filter
// return값이 false요소를 제외하고 true인 요소만 가져올 때
let number2 = [1,6,7,9,10,21];
let tmp2 = [];

/*
for(let n of number2){
    if(n % 2 === 0){
        tmp2.push(n)
    }
}
*/

tmp2 = number2.filter(n => n%2 === 0)
console.log(tmp2)
// 내가 삭제하고자하는게 userKEy === 2 인 것

buyHistory = buyHistory.filter(h => h.userKey !== 2)
console.log(buyHistory)

// find() : 조건을 만족하는 가장 첫 원소 하나를 리턴, 조건에 맞는게 하나도 없으면 undefined
console.log(tmp2.find(n => n % 2 === 0))

// findIndex();
// return되는 조건에 값이 true인 첫 요소의 인덱스를 반환
// 모든 요소가 조건에 부합하지 않는다면(false를 리턴한다면) -1을 반환
console.log(tmp2.findIndex(n => n % 2 === 1))

