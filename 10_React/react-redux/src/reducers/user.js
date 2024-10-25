import { produce } from 'immer' // 자동 불변성 라이브러리

const initialState = {
    isLoading: false, // 사용자가 로그인 중인지를 판단할 변수
    data: null, // 로그인 사용자 정보
}

// immer 또한 prevState로 nextState를 만들어주는 라이브러리
// draft -> prevState의 복사본
// const nextState = produce(prevState, (draft) => {})

const userReducer = (prevState = initialState, action) => {
    // prevState의 복사본인 draft를 가지고 nextState를 만들어준다.
    return produce(prevState, (draft) => {
        switch(action.type){
            // case "LOG_OUT":
            //     return {
            //         ...prevState,
            //         data: null,
            //     }
            // case "LOG_IN_SUCCESS":
            //     return {
            //         ...prevState,
            //         data: action.data,
            //         isLoading: false,
            //     }
            // case "LOG_IN_FAIL":
            //     return {
            //         ...prevState,
            //         data: null,
            //         isLoading: false,
            //     }
            // case "LOG_IN_REQUEST":
            //     return {
            //         ...prevState,
            //         data: null,
            //         isLoading: true,
            //     }
            case "LOG_OUT":
                draft.data = null;
                break;
            case "LOG_IN_SUCCESS":
                draft.data = action.data;
                draft.isLoading = false;
                break;
            case "LOG_IN_FAIL":
                draft.data = null;
                draft.isLoading = false;
                break;
            case "LOG_IN_REQUEST":
                draft.data = null;
                draft.isLoading = true;
                break;
            default:
                break;
        }
    })
}

export default userReducer