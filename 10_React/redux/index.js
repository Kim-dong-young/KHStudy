// import { createStore } from "redux";  <== ES6 모듈 문법(최신)
const { createStore } = require('redux'); // Common JS 모듈

// 리듀서의 정의
// 액션이 발생했을 때 새로운 상태로 기존상태를 업데이트해주는 역할을 함
const reducer = (prevState, action) => {
    switch(action.type){
        case 'CHANGE_AGE':
            return {
                ...prevState,
                age: action.data,
            };
        case 'LOG_IN':
            return {
                ...prevState,
                isLoading: false,
                loginUser: action.data,
            };
        case 'LOG_OUT':
            return {
                ...prevState,
                loginUser: null,
            };
        case 'ADD_BOARD':
            return {
                ...prevState,
                // ...prevState.boardList = 기존 게시판 데이터
                // 거기에 , action.data = 기존 게시판 데이터 + 새로 작성한 게시판 데이터 추가 
                boardList : [...prevState.boardList, action.data]
            };
        case 'LOG_IN_REQUEST':
            return {
                ...prevState,
                isLoading: true,
            };
        case 'DELETE_BOARD' :
            return {
                boardList : prevState.boardList.filter((board) => board.id !== action.data)
            }
        default:
            return prevState; // 지정한 액션이 아니면 state를 그대로
    }
}

// 전역 state
const initialState = {
    loginUser: null,
    isLoading: false,
    boardList:[],
}

// 스토어 생성
// 전역 state가 저장된 저장소
const store = createStore(reducer, initialState)

// 액션 생성 함수
const changeAge = (data) => {
    return {
        type: 'CHANGE_AGE',
        data: data
    }
}

const logIn = (data) => {
    return {
        type: 'LOG_IN',
        data: data
    }
}

const logOut = (data) => {
    return {
        type: 'LOG_OUT',
    }
}

const addBoard = (data) => {
    return {
        type: 'ADD_BOARD',
        data: data
    }
}

const deleteBoard = (data) => {
    return {
        type: 'DELETE_BOARD',
        data: data
    }
}

//--------------------------------------------

// 로그인 하는 시나리오: 로그인 요청
store.dispatch({
    type: "LOG_IN_REQUEST"
})

// 로그인 요청중
console.log("로그인 요청중...")
console.log(store.getState())

// 로그인 처리
store.dispatch(logIn({
    userId: "user01",
    id: 1,
    name: "김지수"
}))

// 로그인 완료
console.log("로그인 완료...")
console.log(store.getState())

// 게시글 작성
store.dispatch(addBoard({
    id: 1,
    title: "안녕 리덕스...",
    content: "리덕스 너무 쉬워요."
}))

console.log("게시글 작성...")
console.log(store.getState())

store.dispatch(addBoard({
    id: 2,
    title: "잘있어 리덕스...",
    content: "리덕스 쉽지 않아요."
}))

console.log("게시글 작성...")
console.log(store.getState())

// 로그아웃
store.dispatch(logOut())

console.log("로그아웃...")
console.log(store.getState())

// ---- 게시판 삭제 ( DELETE_BOARD ) 만들기
store.dispatch(deleteBoard(1))

console.log("게시글 삭제...")
console.log(store.getState())