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

const emptyArr: any[] = [];
const prevState = atom({
  key: "prev",
  default: { find: false, data: emptyArr },
});

const clickState = atom({
  key: "click",
  default: false,
});

export { currentState, searchState, prevState, clickState };
