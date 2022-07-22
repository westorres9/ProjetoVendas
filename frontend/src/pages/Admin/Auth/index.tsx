import {ReactComponent as AuthImage } from 'assets/images/auth-image.svg';
import './styles.css';
import { Route, Switch } from 'react-router-dom';
import Login from '../Login';

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="auth-banner-container">
        <h1>Login</h1>
        <p>Realize o Login para acessar o sistema.</p>
        <AuthImage />
      </div>
      <div className="auth-form-container">
        <Switch>
          <Route path="/admin/auth/login">
            <Login />
          </Route>
        </Switch>
      </div>
    </div>
  );
};

export default Auth;
