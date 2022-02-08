import React from "react";
import { useRecoilState } from "recoil";
import styled from "styled-components";

import { currentState } from "@ts/state";

interface HighlightProps {
  current: string;
}

const Link = (props: LinkType) => {
  const [current, setCurrent] = useRecoilState(currentState);

  const changeTypeHandler = async (e: React.MouseEvent<HTMLDivElement>) => {
    const element = e.currentTarget as HTMLDivElement;
    setCurrent(element.id);
  };

  return (
    <Wrapper onClick={changeTypeHandler} id={props.id} current={current}>
      {props.type}
    </Wrapper>
  );
};

type LinkType = {
  id: string;
  type: string;
};

const Wrapper = styled.div<HighlightProps>`
  border-bottom: ${(props) =>
    props.id === props.current ? "3px solid white" : "none"};
  font-size: 23px;
  font-weight: bold;
  opacity: 1;
  padding: 10px;

  &:hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;

export default Link;
