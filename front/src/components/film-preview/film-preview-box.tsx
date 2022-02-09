import React from "react";
import { useRecoilValue } from "recoil";
import styled from "styled-components";

import { prevState } from "@ts/state";
import FilmPreview from "@components/film-preview/film-preview";
import More from "@components/film-preview/more";
import None from "@components/film-preview/none";

const FilmPreviewBox = (props: PropsType) => {
  const prev = useRecoilValue(prevState);
  const data = props.data !== "" ? props.data : prev.find ? prev.data : "";
  console.log(data);

  return (
    <Wrapper>
      {data !== "" ? (
        data.map((ele: any, idx: number) => (
          <FilmPreview film={ele} key={idx} />
        ))
      ) : (
        <None />
      )}
      {prev.find ? <More /> : ""}
    </Wrapper>
  );
};

type PropsType = {
  page: string;
  data: any;
};

const Wrapper = styled.div`
  width: 96%;
  margin: 2%;
`;

export default FilmPreviewBox;
