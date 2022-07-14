import 'bootstrap/js/src/collapse.js';
import './styles.css';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-md navbar-dark bg-primary main-nav">
      <div className="container-fluid">
        <a href="#" className="nav-logo-text">
          <h4>DS Vendas</h4>
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#dsvendas-navbar"
          aria-controls="dsvendas-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
      </div>
      <div className="collapse navbar-collapse" id="dsvendas-navbar">
        <ul className="navbar-nav offset-md-2 main-menu">
          <li>
            <a href="#">LOGIN</a>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
