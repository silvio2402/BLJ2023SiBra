import "./App.css";
import FruitPreview from "./FruitPreview";
import { Fruit } from "./types";

const fruits: Fruit[] = [
  {
    name: "Apple",
    image:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg",
    price: 35,
  },
  {
    name: "Banana",
    image:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg",
    price: 12,
  },
  {
    name: "Grapes",
    image:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Table_grapes_on_white.jpg/320px-Table_grapes_on_white.jpg",
    weight: 0.1,
    price: 45,
  },
  {
    name: "Pineapple",
    image:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Pineapple_and_cross_section.jpg/286px-Pineapple_and_cross_section.jpg",
    price: 200,
  },
];

function App() {
  return (
    <>
      {fruits.map((fruit) => (
        <FruitPreview {...fruit} />
      ))}
    </>
  );
}

export default App;
