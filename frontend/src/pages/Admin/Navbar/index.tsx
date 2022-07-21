import './styles.css';

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul>
        <li>
          <a href="#" className="admin-nav-item active">
            <p>Gestores</p>
          </a>
        </li>
        <li>
          <a href="#" className="admin-nav-item">
            <p>Equipes</p>
          </a>
        </li>
        <li>
          <a href="#" className="admin-nav-item">
            <p>Vendedores</p>
          </a>
        </li>
        <li>
          <a href="#" className="admin-nav-item">
            <p>Vendas</p>
          </a>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
