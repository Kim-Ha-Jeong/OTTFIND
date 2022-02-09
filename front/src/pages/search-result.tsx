import React from "react";
import styled from "styled-components";

import Header from "@src/components/header/header";

const SearchResult = () => {
  return (
    <Wrapper>
      <Header />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default SearchResult;
