import { useWindowResize } from '../hooks';
import { Title, Subtitle } from '../components';

export default function WindowResizeTest() {
  const [width, height] = useWindowResize();

  return (
    <section className="mt-4">
      <Title>WindowResizeTest</Title>
      <Subtitle className="mt-4">
        width: {width}, height: {height}
      </Subtitle>
    </section>
  );
}
