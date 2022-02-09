import React from "react";
import { useRecoilValue } from "recoil";
import styled from "styled-components";

import { prevState } from "@ts/state";
import FilmPreview from "@components/film-preview/film-preview";
import More from "@components/film-preview/more";
import None from "@components/film-preview/none";

const FilmPreviewBox = () => {
  const prev = useRecoilValue(prevState);

  return (
    <Wrapper>
      {prev.find ? (
        prev.data.map((ele, idx) => <FilmPreview film={ele} key={idx} />)
      ) : (
        <None />
      )}
      {prev.find ? <More /> : ""}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 96%;
  margin: 2%;
`;

export default FilmPreviewBox;
