export const logIn = (data) => {
    // 서버에 전달해서 비동기로 처리하고싶다.
    return (dispatch, getState) => {
        try{
            dispatch(loginRequest(data))
            setTimeout(() => { // 로그인 정보 받아오는데 3초 소요
                const loginInfo = {
                    userId: 1,
                    nickname: "jiwon00",
                }

                dispatch(loginSuccess(loginInfo))
            },3000)
        }catch(e){
            dispatch(loginFail(e))
        }
    }
}

const loginRequest = (data) => {
    return{
        type: "LOG_IN_REQUEST",
        data,
    }
}

const loginSuccess = (data) => {
    return {
        type: "LOG_IN_SUCCESS",
        data,
    }
}

const loginFail = (data) => {
    return {
        type: "LOG_IN_FAIL",
        error: data,
    }
}

export const logOut = () => {
    return {
        type: "LOG_OUT",
    }
}