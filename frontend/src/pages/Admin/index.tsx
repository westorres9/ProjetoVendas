
import { Route, Switch } from 'react-router-dom';
import Navbar from './Navbar';
import Sales from './Sales';
import './styles.css';

const Admin = () => {
  return (
    <div className="admin-container">
      <Navbar/>
      <div className="admin-content">
         <Switch>
          <Route path="/admin/sales">
            <Sales/>
          </Route>
          <Route path="/admin/sellers">
            <h1>Vendedores</h1>
          </Route>
          <Route path="/admin/teams">
            <h1>Equipes</h1>
          </Route>
          <Route path="/admin/users">
            <h1>Gestores</h1>
          </Route>
         </Switch>
      </div>
    </div>
  );
};

export default Admin;
