import React, { useState, useContext } from 'react'
import { TodoDispatchContext } from '../TodoState'
import { useTodoDispatch } from '../hooks/useTodoDispatch';

const SearchBar = () => {
  const dispatch = useTodoDispatch();
  const [text, setText] = useState("")

  // onChange의 return 값 : React.ChangeEventHandler<HTMLInputElement>
  // 그러나 React.ChangeEventHandler는 함수
  // React.ChangeEvent<HTMLInputElement>로 요소를 꺼낼 수 있다.
  const onChangeInput = (e : React.ChangeEvent<HTMLInputElement>) => {
    setText(e.target.value)
  }

  const onClickButton = () => {
    dispatch.onClickAdd(text); // context에 null값이 들어갈수도 있으니 옵셔널 체이닝 or 따로 함수파서 null 검사
  }

  return (
    <div>
        <input 
        type="text"
        value={text}
        onChange={onChangeInput}
        />
        <button onClick={onClickButton}>추가</button>
    </div>
  )
}

export default SearchBar