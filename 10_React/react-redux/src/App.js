import logo from './logo.svg';
import './App.css';
import { logOut, logIn } from './actions/user'
import { useSelector, useDispatch } from 'react-redux';

function App() {
  // useSelector() 통해서 전역 state에 접근할 수 있음
  const user = useSelector((state) => state.user) // useSelector: react-redux 제공 훅 ( 함수형 컴포넌트에 기능 추가 )
  const boards = useSelector((state) => state.boards)

  const dispatch = useDispatch();

  const onClick = () => {
    dispatch(logIn({
      id: "user01",
      passwprd: "pass01",
    }))
  }

  const onLogout = () => {
    dispatch(logOut())
  }

  return (
    <div className="App">
      {user.isLoading 
        ? <h3>로그인 하는중</h3> 
        : (user.data 
            ? <h3>{user.data.nickname}님 반갑습니다.</h3>
            : <h3>로그인이 필요합니다.</h3>)}
      
      {user.data
        ? <button onClick={onLogout}>로그아웃</button>
        : <button onClick={onClick}>로그인</button>}
    </div>
  );
}

export default App;
