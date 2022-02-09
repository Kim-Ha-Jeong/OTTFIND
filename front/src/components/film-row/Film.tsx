import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const Film = (props: propsType) => {
  const nav = useNavigate();
  const onClickHandler = (e: any) => {
    const ele = e.currentTarget as HTMLImageElement;
    nav(`/film/${ele.id}`);
  };

  return (
    <Wrapper id={props.id} onClick={onClickHandler}>
      <Poster src={`/poster/${props.src}`} />
    </Wrapper>
  );
};

type propsType = {
  src: string;
  id: string | undefined;
};

const Wrapper = styled.div`
  width: 18%;
  margin: 0% 1% 2% 1%;
`;

const Poster = styled.img`
  object-fit: contain;
  width: 100%;
`;

export default Film;
