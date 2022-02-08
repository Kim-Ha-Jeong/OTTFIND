import React from "react";
import styled from "styled-components";

const FilmRow = () => {
  return <Wrapper></Wrapper>;
};

export default FilmRow;

const Wrapper = styled.div`
  font-size: 23px;
  font-weight: bold;
  opacity: 1;
  padding: 10px;

  &:hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;
