import Navbar from 'components/Navbar';
import Admin from 'pages/Admin';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

const Routes = () => (
  <BrowserRouter>
    <Navbar/>
    <Switch>
      <Route path="/" exact>
        <Admin />
      </Route>
    </Switch>
  </BrowserRouter>
);

export default Routes;
