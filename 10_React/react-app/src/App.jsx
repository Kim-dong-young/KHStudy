import logo from './logo.svg';
import './App.css';
import Menu from './components/01_components/Menu'
import Comments from './components/02_props/Comments'
import Comment from './components/03_classComponent/Comment'
import CommentList from './components/03_classComponent/CommentList'

function App() {
  return (
    <div className="App">
      {/* <Menu/> */}
      {/* <Comments /> */}
      {/* <Comment/> */}
      <CommentList />
    </div>
  );
}

export default App;
