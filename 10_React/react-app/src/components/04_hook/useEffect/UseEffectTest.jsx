import React, { useEffect, useState } from 'react'

/*
    useEffect
    컴포넌트가 렌더링 될 때 특정 작업을 실행할 수 있도록 하는 react hook
    클래스형 컴포넌트의 생명주기 메소드의 역할을 대체한다.

    컴포넌트가 마운트됐을 때(처음 나타났을 떄), 언마운트 됐을 떄(사라질 때)
    업데이트 되었을 떄(특정 state, props가 바뀌었을 때)

    [사용법]
    useEffect(effect, [])
    첫번째 인자(effect) : 함수 -> 특정 상황이 왔을 때 실행이되는 함수
    두번째 인자 : 배열 -> 의존성 배열
*/
const useEffectTest = () => {
  const [name, setName] = useState("김개똥");
  const [num, setNum] = useState(0);

  const handleKeyUpName = (ev) => {
    setName(ev.target.value)
  }

  const handleClickNum = () => {
    setNum(num + 1)
  }

  // 렌더링이 되었을 때, 그리고 state가 변경될 떄 마다 console.log가 실행 되었다.
  // componentDidMount & componentDidUpdate(어떤 props, state가 바뀌던 전부 다)의 역할을 대체할 수 있다.
  useEffect(() => {
    console.log("의존성 배열이 없는 useEffect 호출")
  })

  // 랜더링 되었을 때 한번만 실행이 된다. (최초 마운트) => componentDidMount 역할
  // 의존성 배열 전달시, 배열 내에 있는 요소의 값이 변할때만 componentDidUpdate 실행
  // 따라서 빈 배열을 넣으면 어떠한 요소도 추적하지 않아 componentDidMount만 수행하는것과 같은 효과
  useEffect(() => {
    console.log("빈 배열을 의존성 배열로 가진 useEffect 호출")
  }, [])

  // 랜더링이 되었을 때, 그리고 name state가 변경되었을 때 호출
  // => componentDidMount & componentDidUpdate의 역할을 대체할 수 있다.
  // 의존성 배열 안에 있는 state가 변하면 해당 effect 함수를 호출해준다.
  useEffect(() => {
    console.log(`${name}의존성 배열로 가진 useEffect 호출`)
  }, [name])

  // 함수를 return하면 해당 함수는 컴포넌트가 제거되기 직전에 호출된다.
  // => componentWillUnmount
  useEffect(() => {
    // 마찬가지로 componentDidMount 실행이 된다
    return () => {
      console.log(`${name}함수를 리턴하는 useEffect 호출`)
    }
  }, [name])
  
  return (
    <div>
        <p>안녕하세요. {name}입니다.</p>
        <input type="text" onChange={handleKeyUpName}  value={name}/>
        <p>{num}번 클릭</p>
        <button onClick={handleClickNum}> + </button>
    </div>
  )
}

export default useEffectTest