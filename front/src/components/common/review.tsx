import React from "react";
import styled from "styled-components";

const Review = (props: PropsType) => {
  return (
    <Wrapper>
      <User>{props.user}</User>
      <P>{props.content}</P>
    </Wrapper>
  );
};

type PropsType = {
  content: string;
  user: string;
};

const Wrapper = styled.div`
  margin-right: 30px;
  padding: 10px 10px 0 10px;
  background-color: #222222;
`;

const P = styled.p`
  background-color: #222222;
  margin-bottom: 20px;
  font-size: 14px;
`;

const User = styled(P)`
  font-size: 17px;
  font-weight: 900;
`;
export default Review;
