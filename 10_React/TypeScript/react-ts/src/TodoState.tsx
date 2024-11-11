import React from "react";
import { Todo } from "./types";

// 값 변경을 위해 state를 이용해 props로 하위 요소까지 전달하면 변경값 추적이 안된다.
// 따라서 전역으로 선언해서 관리해준다.
export const TodoStateContext = React.createContext<Todo[] | null>(null);
// 전역으로 변경하는 함수도 등록해준다.
export const TodoDispatchContext = React.createContext<{
    onClickAdd : (text: string) => void;
    onClickRemove : (id: number) => void;
} | null >(null);