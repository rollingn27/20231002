import { Link } from '../../components';

export default function NavigationBar() {
  return (
    <div className="flex p-4 bg-gray-200">
      <Link to="/" className="btn btn-link">
        Home
      </Link>
      <Link to="/board" className="ml-4 btn btn-link">
        Board
      </Link>
    </div>
  );
}
