import type { ISourceOptions } from "@tsparticles/engine";

export const particleOptions: ISourceOptions = {
  key: "images",
  name: "Images",

  interactivity: {
    events: {
      // onClick: {
      //   enable: true,
      //   mode: "push",
      // },
      // onHover: {
      //   enable: true,
      //   mode: "bubble",
      // },
    },
    modes: {
      // bubble: {
      //   distance: 400,
      //   duration: 2,
      //   opacity: 0.8,
      //   size: 40,
      // },
      // push: {
      //   quantity: 4,
      // },
    },
  },
  particles: {
    // color: {
    //   value: "#ffffff",
    // },
    move: {
      enable: true,
      speed: 2,
      direction: "bottom",
      straight: true,
    },
    number: {
      density: {
        enable: true,
      },
      value: 80,
    },
    opacity: {
      value: 1,
    },
    rotate: {
      // animation: {
      //   enable: true,
      //   speed: 5,
      //   sync: false,
      // },
      // direction: "random",
      // value: {
      //   min: 0,
      //   max: 360,
      // },
    },
    shape: {
      options: {
        image: [
          {
            name: "assugrin",
          },
        ],
      },
      type: "image",
    },
    size: {
      value: 16,
    },
  },
  // background: {
  //   color: "#fff",
  // },
  preload: [
    {
      src: "/assugrin-particle.png",
      name: "assugrin",
      width: 39,
      height: 30,
    },
  ],
};
