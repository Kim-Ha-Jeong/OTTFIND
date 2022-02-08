import React from "react";
import ReactDOM from "react-dom";
import { RecoilRoot } from "recoil";
import App from "@src/App";
import reportWebVitals from "@src/reportWebVitals";

ReactDOM.render(
  <RecoilRoot>
    <React.StrictMode>
      <App />
    </React.StrictMode>
  </RecoilRoot>,
  document.getElementById("root")
);

reportWebVitals();
