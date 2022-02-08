import React from "react";
import styled from "styled-components";

import get from "@ts/get";

interface HighlightProps {
  current: string;
}

const Link = (props: LinkType) => {
  const changeTypeHandler = async (e: React.MouseEvent<HTMLDivElement>) => {
    const element = e.currentTarget as HTMLDivElement;
    props.setCurrent(element.id);

    const apiLocation = { pathname: "film" };
    if (props.id !== "전체") {
      Object.assign(apiLocation, { params: { type: props.id } });
    }
    const result = await get(apiLocation);

    if (result.status === 200) {
      console.log(result.data);
    }
  };

  return (
    <Wrapper onClick={changeTypeHandler} id={props.id} current={props.current}>
      {props.type}
    </Wrapper>
  );
};

export default Link;

type LinkType = {
  id: string;
  type: string;
  current: string;
  setCurrent: (current: string) => void;
};

const Wrapper = styled.div<HighlightProps>`
  border-bottom: ${(props) =>
    props.current === props.id ? "solid 3px white" : "none"};
  font-size: 23px;
  font-weight: bold;
  opacity: 1;
  padding: 10px;

  &:hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;
