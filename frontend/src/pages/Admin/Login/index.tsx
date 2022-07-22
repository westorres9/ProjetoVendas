import { Link } from 'react-router-dom';
import './styles.css';

const Login = () => {
  return (
    <div className="base-card login-card">
      <h1>LOGIN</h1>
      <div className="alert alert-danger">Erro ao tentar fazer Login</div>
      <form>
        <div className="mb-4">
          <input
            type="text"
            className="form-control base-input"
            placeholder="Email"
            name="username"
          />
          <div className="invalid-feedback d-block"></div>
        </div>

        <div className="mb-2">
          <input
            type="password"
            className="form-control base-input"
            placeholder="Password"
            name="password"
          />
          <div className="invalid-feedback d-block"></div>
        </div>
        <div className="login-submit">
          <button className="btn btn-primary">Fazer login</button>
        </div>
      </form>
    </div>
  );
};

export default Login;
