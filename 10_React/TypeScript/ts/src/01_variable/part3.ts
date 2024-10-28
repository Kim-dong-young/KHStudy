// 타입 별칭부여

type User = {
    user_id: number,
    id: string;
    password: string,
    age: number;
    address: string
}

let user1 : User = {
    user_id: 1,
    id: "user01",
    password: "pass01",
    age: 30,
    address: "울릉도 동남쪽" 
}

function test() {
    type User = string; // 이 함수 내에서만 쓰는 User타입
    let user02: User = "user02"

    type id = string;
    let user03: id = "user03"
}

type SidoCode = {
    [key : string] : string; // 키, 밸류를 모두 string으로 정의하겠다.
    seoul : string; // 키가 seoul인 값은 필수이며, 값은 string
}

let sidoCodeList: SidoCode = {
    "경기도" : "k1",
    "전라도" : "j2",
    "충청도" : "c1",
    "seoul" : "s1",
}