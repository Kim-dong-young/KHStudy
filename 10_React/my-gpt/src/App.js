import logo from './logo.svg';
import './App.css';
import styled from 'styled-components'
import { Title, DescriptText } from './components/CommonsStyles';
import SearchBar from './components/SearchBar';
import { useState } from 'react';
import { CallGPT, CallGptAxios } from './service/gptAPI';

function App() {
  const [searchText, setSearchText] = useState("");

  const changeSearchText = (ev) => {
    setSearchText(ev.target.value)
  }

  const clickSearchIcon = async () => {
    if(searchText.trim() === "")
      return;

    const chatData = {
      date: new Date(),
      question: searchText
    }

    const message = await CallGPT({
        prompt: searchText
    })
    console.log(message);
  }

  return (
    <AppContainer className="App">
      <Header>
        <Title>나만의 GPT</Title>
      </Header>
      <Content>

      </Content>
      <Footer>
        <SearchBar
          searchText={searchText}
          changeSearchText={changeSearchText}
          clickSearchIcon={clickSearchIcon}
        />
        <DescriptText>
          ChatGPT는 실수를 할 수 있습니다. 중요한 정보를 확인하세요.
        </DescriptText>
      </Footer>
    </AppContainer>
  );
}

export default App;

const AppContainer = styled.div`
    display: flex;
    flex-direction: column;
    height: 100vh;
    width: 100%;
    max-width: 720px;
    margin: 0 auto;
`
const Header = styled.div`
    padding: 5px;
    height: 56px;
    width: 100%;
    background: white;
`
const Content = styled.div`
    padding: 60px 0 0 0;
    flex: 1;
    overflow-y: scroll;
`
const Footer = styled.div`
    height: 86px;
    display: flex;
    flex-direction: column;
`
