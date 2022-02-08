import React from "react";
import { RecoilRoot } from "recoil";
import styled from "styled-components";

import Header from "@components/header/Header";
import WholeFilm from "@components/film-row/WholeFilm";

const Main = () => {
  return (
    <Wrapper>
      <RecoilRoot>
        <Header />
        <WholeFilm />
      </RecoilRoot>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default Main;
