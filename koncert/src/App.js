import logo from './logo.svg';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
//importaj navbar
import Routing from ".components/routing/Routing"; //tu nekaj ni prav - importaj routing

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar />
      <Routing />

      </BrowserRouter>
      {/*
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>*/}
    </div>
  );
}

export default App;
