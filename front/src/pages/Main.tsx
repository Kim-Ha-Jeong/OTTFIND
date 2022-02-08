import React from "react";
import styled from "styled-components";

import Header from "@components/header/Header";
import FilmRow from "@components/film-row/FilmRow";

const Main = () => {
  return (
    <Wrapper>
      <Header />
      <FilmRow />
    </Wrapper>
  );
};
export default Main;

const Wrapper = styled.div`
  margin: 1%;
`;
