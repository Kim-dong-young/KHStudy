import React from 'react'
import { Todo } from '../types'
import { useTodoDispatch } from '../hooks/useTodoDispatch'

// App.tsx에서 넘겨준 onClickRemove 값을 받기 위해 Props를 확장
interface Props extends Todo {}

const TodoItem = (props : Props) => {
  const dispatch = useTodoDispatch();
  const onClickButton = () => {
    dispatch.onClickRemove(props.id)
  }

  return (
    <div>
        {props.id}번 : {props.content}
        <button onClick={onClickButton}>삭제</button>
    </div>
  )
}

export default TodoItem