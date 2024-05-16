import React, { useState } from "react";
import assugrin from "./assets/assugrin-transparent.png";

function Clicker() {
  const [count, setCount] = useState(0);

  function click() {
    setCount((prevCount) => prevCount + 1);
  }

  return (
    <div className="text-white w-screen h-screen flex justify-center p-24 bg-[#e1251b]">
      <div className="max-w-3xl flex flex-col items-center">
        <h1 className="text-3xl">Assugrin Clicker</h1>
        <h2 className="text-3xl">{count} assugrinos</h2>

        <div className="max-w-40 mt-10 scale-100 hover:scale-110 active:scale-105 transition-transform">
          <img
            src={assugrin}
            onClick={click}
            className="shadow-white shadow-2xl"
          />
        </div>
      </div>
    </div>
  );
}

export default Clicker;
