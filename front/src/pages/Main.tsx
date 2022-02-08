import React from "react";
import styled from "styled-components";

import Header from "@src/components/common/Header";

const Main = () => {
  return (
    <Wrapper>
      <Header />
    </Wrapper>
  );
};
export default Main;

const Wrapper = styled.div`
  margin: 1%;
`;
