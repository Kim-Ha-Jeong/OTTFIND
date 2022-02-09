import React from "react";
import { useNavigate } from "react-router-dom";
import { useSetRecoilState } from "recoil";
import styled from "styled-components";

import { searchState } from "@ts/state";

const None = (props: PropsType) => {
  const nav = useNavigate();
  const setSearch = useSetRecoilState(searchState);

  const onClickHandler = () => {
    setSearch({ enter: false, title: "" });
    nav(`/film/title/${props.title}`);
  };
  return <Wrapper onClick={onClickHandler}>검색 결과 더 보기</Wrapper>;
};

type PropsType = {
  title: string;
};

const Wrapper = styled.div`
  width: 100%;
`;

export default None;
