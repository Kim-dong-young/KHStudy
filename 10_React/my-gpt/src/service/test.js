// const testAPI = (data, callback) => {
//     setTimeout(() => { // 비동기 실행
//         callback("안녕")
//     }, 2000)
// }

// testAPI({prompt: "안녕?"}, (response) => {
//     console.log(response)
// })

// ajax는 어떻게 동작할까?
// const data = {
//     data: ~~~,
//     method: post,
//     url: ~~~,
//     success: function(res){

//     },
//     error: function(){

//     }
// }

// $.ajax(data)

// function ajax(requestJson){
//     let xhr = new XMLHttpRequest();

//     requestJson.method = requestJson.method ? requestJson.method : "GET";
//     xhr.open(requestJson.method, requestJson.url, true);

//     // 응답이 왔을 떄 실행하는 이벤트 핸들러
//     xhr.onreadystatechange = function(){
//         if(xhr.readyState === XMLHttpRequest.DONE) {
//             if(xhr.status === 200){
//                 let result = JSON.parse(xhr.responseText)
//                 requestJson.success(result)
//             } else {
//                 requestJson.error(xht.status)
//             }
//         }
//     }
// }

const getPromise = function(seconds){
    return new Promise((resolve, reject)=>{
        setTimeout(() => {
            resolve("완료")
        }, seconds * 1000)
    })
}

// 가독성이 떨어지고 복잡해진다
// getPromise(2).then((res)=> {
//     console.log(res)
//     console.log("도착")
// })

// async 키워드가 선언된 함수에서는 await을 사용할 수 있음
// await 키워드를 사용하면 비동기통신을 마치 동기코드처럼 사용할 수 있음.
const runner = async() => {
    const res1 = await getPromise(1); // 실행될 때 까지 기다림, 밑에 실행 X
    console.log(res1)

    const res2 = await getPromise(2); // 실행될 때 까지 기다림, 밑에 실행 X
    console.log(res2)

    const res3 = await getPromise(3); // 실행될 때 까지 기다림, 밑에 실행 X
    console.log(res3)
}

runner();

// const testAPI2 = new Promise((resolve, reject) => {
//     setTimeout(() => { // 비동기 실행
//         resolve("안녕~ 나야 GPT")

//         // 실패시 reject();
//     }, 2000)
// })
// // Depth를 깊게 하지 않고 계속 체인이 가능
// testAPI2.then((res)=>{
//     console.log(res)
// }).catch(() => {

// })