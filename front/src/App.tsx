import React from "react";
import { RecoilRoot } from "recoil";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import GlobalStyles from "@styles/global-style";

import Main from "@pages/main";
import SearchResult from "@pages/search-result";

const App = () => {
  return (
    <RecoilRoot>
      <Router>
        <GlobalStyles />
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/film/title/:title" element={<SearchResult />} />
        </Routes>
      </Router>
    </RecoilRoot>
  );
};

export default App;
