import { atom } from "recoil";

const currentState = atom({
  key: "current",
  default: "홈",
});

export { currentState };
