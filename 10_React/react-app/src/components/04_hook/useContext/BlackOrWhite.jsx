import React, { useState } from 'react'
import MainContent from './MainContent';
import ThemeContext from './ThemeContext';

const BlackOrWhite = () => {
  const [theme, setTheme] = useState("white");

  const toggleTheme = () => {
    if(theme === "white"){
        setTheme("black")
    } else {
        setTheme("white")
    }
  }

  return (
    <ThemeContext.Provider value={{theme, toggleTheme}} >
        <MainContent theme = {theme} toggleTheme = {toggleTheme}/>
    </ThemeContext.Provider>
  )
}

export default BlackOrWhite