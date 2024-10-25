import { combineReducers } from "redux";
import userReducer from "./user";
import boardReducer from "./board";

// 자동으로 reducer 라는 이름으로 return 됨
export default combineReducers({
    user: userReducer,
    board: boardReducer,
})