import React from "react";
import { useSetRecoilState } from "recoil";
import styled from "styled-components";

import { currentState } from "@ts/state";

const OttBtn = (props: PropsType) => {
  const setCurrent = useSetRecoilState(currentState);

  const onClickHandler = async (e: React.MouseEvent<HTMLDivElement>) => {
    if (props.opt === "") {
      setCurrent(props.name);
    }
  };

  return (
    <Wrapper onClick={onClickHandler}>
      <Img opt={props.opt} src={`/ott/${props.name}.png`} />
      <P>{props.opt !== "정기권" ? props.opt : ""}</P>
    </Wrapper>
  );
};

type PropsType = {
  name: string;
  opt: string;
};

type SizeType = {
  opt: string;
};

const Wrapper = styled.div`
  margin-right: 30px;
`;

const P = styled.p`
  margin-bottom: 20px;
  font-size: 15px;
  text-align: center;
`;

const Img = styled.img<SizeType>`
  width: ${(p) => (p.opt === "" ? "55px" : "75px")};
  margin-bottom: 10px;
`;

export default OttBtn;
