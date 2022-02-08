import React from "react";
import styled from "styled-components";

import get from "@ts/get";

const Link = (props: LinkType) => {
  const changeTypeHandler = async () => {
    const apiLocation = { pathname: "film", params: { type: props.id } };
    const result = await get(apiLocation);

    if (result.status === 200) {
      console.log(result.data);
    }
  };
  return <Wrapper onClick={changeTypeHandler}>{props.link}</Wrapper>;
};

export default Link;

type LinkType = {
  id: string;
  link: string;
};

const Wrapper = styled.p`
  font-size: 23px;
  font-weight: bold;
  &:hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;
