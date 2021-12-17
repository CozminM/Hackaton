import logo from './logo.svg';
import './App.css';
import Form from "./components/Form"
import {Routes} from "react-router";
import {BrowserRouter as Router, Route} from "react-router-dom";

function App() {
  return (
    <div className="App">
        <Router>
            <Routes>
                <Route exact path='/' element={<Form/>}/>
            </Routes>
        </Router>
    </div>
  );
}

export default App;
