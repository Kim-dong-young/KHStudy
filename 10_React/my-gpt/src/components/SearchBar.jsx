import React, { useState } from 'react'
import styled from 'styled-components';
import { FaArrowUp } from "react-icons/fa";

const SearchBar = ({searchText, changeSearchText, clickSearchIcon}) => {
  return (
    <SearchBarContainer>
        <SearchInput 
          type="text"
          value={searchText}
          onChange={changeSearchText}
          placeholder='궁금한 것을 물어보세요....'
        />
        <UploadIconBox
          search = {searchText}
          onClick = {clickSearchIcon}
        >
          <FaArrowUp
            style={{color:"white"}}
          />
        </UploadIconBox>
    </SearchBarContainer>
  )
}

export default SearchBar

// 외부 요소에 스타일 넣기 = const ~~~ = styled(FaArrowUp) 이런식으로

const SearchBarContainer = styled.div`
  width: 100%;
  border: 1px solid #cccccc;
  background: #f4f4f4;
  border-radius: 25px;
  height: 52px;
  position: relative;
  padding: 14px 50px 14px 14px;
  margin: 0 0 6px 0;
`
const SearchInput = styled.input`
  border: none;
  outline: none;
  background: none;
  width: 100%;
  height: 100%;
`
const UploadIconBox = styled.div`
  position: absolute;
  top: 7px;
  right: 8px;
  width: 36px;
  height: 36px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: ${(props) => props.search ? "black" : "#f4f4f4" };
  cursor: ${(props) => props.search ? "pointer" : "auto" };
  border-radius: 25px;
`