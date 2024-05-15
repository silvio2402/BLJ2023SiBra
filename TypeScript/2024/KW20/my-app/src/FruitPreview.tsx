import React from "react";
import { Fruit } from "./types";

type FruitProp = Fruit & {
  count: number;
  onAdd: () => void;
  onRemove: () => void;
};

function FruitPreview({
  name,
  image,
  price,
  count,
  onAdd,
  onRemove,
}: FruitProp) {
  return (
    <div className="flex border border-gray-200 rounded-lg p-2 shadow-md">
      <div className="flex gap-4 border-r-2 border-gray-200 pr-4">
        <img src={image} className="h-16" />
        <div>
          <h1 className="text-lg">{name}</h1>
          <p>{price} CHF</p>
        </div>
      </div>
      <div className="flex-grow"></div>
      <div className="flex flex-col gap-2 items-center border-l-2 border-gray-200 pl-2">
        <p>{count}x</p>
        <div className="flex gap-2">
          <button
            onClick={onAdd}
            className="hover:bg-gray-200 active:bg-gray-300 rounded-md"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M12 6v6m0 0v6m0-6h6m-6 0H6"
              />
            </svg>
          </button>
          <button
            onClick={onRemove}
            className="hover:bg-gray-200 active:bg-gray-300 rounded-md"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M20 12H4"
              />
            </svg>
          </button>
        </div>
      </div>
    </div>
  );
}

export default FruitPreview;
