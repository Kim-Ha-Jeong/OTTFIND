import React from "react";
import styled from "styled-components";

const OttBtn = (props: PropsType) => {
  return (
    <Wrapper>
      <Img src={`/ott/${props.name}.png`} />
      <P>{props.opt !== "정기권" ? props.opt : ""}</P>
    </Wrapper>
  );
};

type PropsType = {
  name: string;
  opt: string | undefined;
};
const Wrapper = styled.div`
  margin-right: 30px;
`;

const P = styled.p`
  margin-bottom: 20px;
  font-size: 15px;
  text-align: center;
`;

const Img = styled.img`
  width: 75px;
  margin-bottom: 10px;
`;

export default OttBtn;
