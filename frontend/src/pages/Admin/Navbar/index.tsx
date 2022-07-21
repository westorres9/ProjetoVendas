import { NavLink } from 'react-router-dom';
import './styles.css';

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul>
        <li>
          <NavLink to="/admin/sales" className="admin-nav-item">
            <p>Vendas</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/sellers" className="admin-nav-item">
            <p>Vendedores</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/teams" className="admin-nav-item">
            <p>Equipes</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/users" className="admin-nav-item">
            <p>Gestores</p>
          </NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
