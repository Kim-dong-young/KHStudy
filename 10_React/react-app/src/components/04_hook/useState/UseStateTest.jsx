import React, { useState } from 'react'

/*
    Hook이란
    함수형 컴포넌트에서 react state와 life-cycle 메소드의 기능을 사용할 수 있게 해주는 함수이다.
    hook은 class 안에서는 동작하지 않는다. 대신 class 없이 react를 사용할 수 있게 해준다

    state : 컴포넌트의 상태값
    useState : 컴포넌트의 상태를 생성하고 관리할 수 있게 해주는 react hook

    -> 컴포넌트는 state 값이 변경되면 이를 확인하고 요소를 리렌더링 해준다.

    const [ 변수명, setState변수명 ] = useState(초기값);
    변수명 : 원하는 state명
    set변수명 : 해당 statea값을 변경할 함수
*/

const UseStateTest = () => {
  // let num = 0; 으로 변수는 만들수 있지만, 함수가 종료되면 사라짐
  const [num, setNum] = useState(0); // num이라는 변수와, state를 변경하는 setNum이라는 setter 생성

  const onClick1 = () => {
    // num += 1;
    setNum(num + 1)
    console.log("num : " + num)
  }

  const onClick2 = () => {
    // num -=1;
    setNum(num - 1)
    console.log("num : " + num)
  }

  return (
    <div>
        <span>COUNT : {num}</span>
        <button onClick={onClick1}> + </button>
        <button onClick={onClick2}> - </button>
    </div>
  )
}

export default UseStateTest