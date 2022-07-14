import React from 'react';
import 'assets/styles/custom.scss';
import './App.css';
import Navbar from 'components/Navbar';
import Admin from 'pages/Admin';

function App() {
  return (
    <>
      <Navbar/>
      <Admin/>
    </>
    
  );
}

export default App;
