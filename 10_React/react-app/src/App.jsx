import logo from './logo.svg';
import './App.css';
import Menu from './components/01_components/Menu'
import Comments from './components/02_props/Comments'
import Comment from './components/03_classComponent/Comment'
import CommentList from './components/03_classComponent/CommentList'
import UseStateTest from './components/04_hook/useState/UseStateTest';
import SignUp from './components/04_hook/useState/SignUp';
import Toolbar from './components/04_hook/useState/Toolbar';
import LandingPage from './components/04_hook/useState/LandingPage';
import UseEffectTest from './components/04_hook/useEffect/UseEffectTest';
import { useState } from 'react';
import UseRefTest from './components/04_hook/useRef/UseRefTest';
import UseRefScroll from './components/04_hook/useRef/UseRefScroll';

function App() {
  const [isComponent, setIsComponent] = useState(true)
  return (
    <div className="App">
      {/* <Menu/> */}
      {/* <Comments /> */}
      {/* <Comment/> */}
      {/* <CommentList /> */ }
      {/* <UseStateTest/> */}
      {/* <SignUp/> */ }
      {/* <Toolbar/> */}
      {/* <LandingPage/>*/}
      {/*
        { isComponent ? <UseEffectTest/>  : <span>사라짐</span> }
        {
          setTimeout(() => {
            setIsComponent(false)
          }, 3000)
        }
        */
      }
      {/* <UseRefTest/> */ }
      <UseRefScroll/>
    </div>
  );
}

export default App;
