import { Switch, Route, Redirect } from 'react-router-dom';
import Sidebar from 'components/Sidebar';
import Dashboard from 'pages/Dashboard';
import Settings from 'pages/Settings';
import Tables from 'pages/Tables';
import Maps from 'pages/Maps';
import Footer from 'components/Footer';
import LoginCard from 'components/LoginCard';
import RegisterCard from 'components/RegisterCard';
import ActivityForm from 'components/ActivityForm';

// Tailwind CSS Style Sheet
import 'assets/styles/tailwind.css';
import {useEffect} from "react";

function App() {

    return (
        <>
            <Sidebar />
            <div className="md:ml-64">
                <Switch>
                    {/*<Route exact path="/dashboard" component={Dashboard} />*/}
                    {/*<Route exact path="/settings" component={Settings} />*/}
                    <Route exact path="/activity" component={Tables} />
                    <Route exact path="/add-data" component={ActivityForm} />
                    <Route exact path="/login" component={LoginCard} />
                    <Route exact path="/register" component={RegisterCard} />
                </Switch>
                <Footer />
            </div>
        </>
    );
}

export default App;
