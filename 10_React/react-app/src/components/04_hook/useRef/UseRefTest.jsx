import React, { useState, useRef } from 'react'

// react는 virtual DOM 조작하면 real DOM을 바꿔줌
// 그러나 real DOM을 조작한다고 virtual DOM을 바꾸진 않음 => jQuery와 같이 못쓴다

/*
    useRef는 React에서 DOM 요소에 직접 접근하거나 컴포넌트 랜더링 간 상태 변화 없이 값을
    저장하는데 사용된다. state와 다르게 값이 변경되어도 컴포넌트가 리렌더링 되지 않고
    초기화되지 않으며 참조값을 유지한다. 주로 DOM요소 포커스나 스크롤 위치를 추적하거나
    또는 이전값을 기억하는데 유용하다.
*/

const UseRefTest = () => {
    // let name = "", gender ="";
    const [name, setName] = useState("");
    const [gender, setGender] = useState("man");
    // 이전 값을 저장해야 하는 경우를 가정해보자
    // state에 이전 값을 저장하면 값을 저장할때마다 리렌더링이 발생
    // 이럴 경우 Ref를 쓰면 좋다

    // re-render 되도 useRef 값은 유지
    // const [beforeName, setBeforeName] = useState("");
    const beforeName = useRef("");
    const useInput = useRef(null);

    const handleSubmit = (ev) => {
        alert(`이름 : ${name}, 성별 : ${gender}`);

        ev.preventDefault();
    }

    const handleChangeName = (ev) => {
        // setBeforeName(name)
        beforeName.current = name;
        setName(ev.target.value);
    }

    const handleChangeGender = (ev) => {
        setGender(ev.target.value);
    }

    const handleReset = () => {
        setName("");
        setGender("man");
        useInput.current.focus();
    }

    return (
    <form onSubmit={handleSubmit}>
        <label>
            이름 :
            <input 
                type="text" 
                value={name} 
                onChange={handleChangeName}
                ref={useInput} // 실제로는 (input에서 return된 el) => { useInput = el }
            />
        </label>
        <label>
            이전 이름 : {beforeName.current}
        </label>
        <br/><br/>
        <label>
            성별 :
            <select value={gender} onChange={handleChangeGender}>
                <option value="man">남자</option>
                <option value="woman">여자</option>
            </select>
        </label>
        <br/><br/>
        <button type="submit">제출</button>
        <button type="button" onClick={handleReset} >초기화</button>
    </form>
    )
}

export default UseRefTest