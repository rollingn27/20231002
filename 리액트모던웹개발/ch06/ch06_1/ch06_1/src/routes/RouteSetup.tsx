import { Routes, Route } from 'react-router-dom';
import NoMatch from './NoMatch';
import Home from './Home';
import Board from './Board';
import Card from './Card';

export default function RouteSetup() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/welcome" element={<Home title="Welcome to our site" />} />
      <Route path="/board" element={<Board />} />
      <Route path="/board/card/:cardid" element={<Card />} />
      <Route path="*" element={<NoMatch />} />
    </Routes>
  );
}
