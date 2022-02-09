import React from "react";
import styled from "styled-components";

import Header from "@components/header/header";
import WholeFilm from "@components/film-row/whole-film";

const Main = () => {
  return (
    <Wrapper>
      <Header />
      <WholeFilm />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default Main;
