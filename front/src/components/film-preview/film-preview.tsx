import React from "react";
import { useRecoilValue } from "recoil";
import styled from "styled-components";

import { prevState } from "@ts/state";

const FilmPreview = () => {
  const prev = useRecoilValue(prevState);
  return <Wrapper>{prev.find ? "맞아 있어" : "없음"}</Wrapper>;
};

const Wrapper = styled.div`
  width: 100%;
  margin: 2% 0;
`;

export default FilmPreview;
