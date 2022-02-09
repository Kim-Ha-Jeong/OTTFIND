import { atom } from "recoil";

const currentState = atom({
  key: "current",
  default: "홈",
});

const searchState = atom({
  key: "search",
  default: {
    enter: false,
    title: "",
  },
});

const prevState = atom({
  key: "prev",
  default: { find: false, data: [] },
});

export { currentState, searchState, prevState };
