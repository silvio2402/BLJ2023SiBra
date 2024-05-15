import React from "react";
import { Fruit } from "./types";

type FruitProp = Fruit;

function FruitPreview({ name, image, price }: FruitProp) {
  return (
    <div>
      <h1>{name}</h1>
      <img src={image} />
      <p>Price: {price}</p>
    </div>
  );
}

export default FruitPreview;
