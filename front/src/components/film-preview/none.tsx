import React from "react";
import styled from "styled-components";

const None = () => {
  return <Wrapper>해당 검색 결과가 없습니다 다시 검색해보세요</Wrapper>;
};

const Wrapper = styled.div`
  width: 100%;
`;

export default None;
