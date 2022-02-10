import React from "react";
import styled from "styled-components";

import Header from "@components/header/header";
import WholeFilm from "@components/film-row/whole-film";
import OttBtn from "@src/components/common/ottBtn";

const Main = () => {
  const ott = ["Netflix", "Watcha", "Wavve", "Tving", "Disney"];
  return (
    <Wrapper>
      <Header />
      <FilterWrapper>
        {ott.map((ele, idx) => (
          <OttBtn name={ele} opt="" key={idx} />
        ))}
      </FilterWrapper>
      <WholeFilm />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

const FilterWrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin: 2% 2% 0 2%;
`;

export default Main;
