import React from "react";
import styled from "styled-components";

const Film = (props: propsType) => {
  return (
    <Wrapper>
      <Poster src={`/poster/${props.src}`} />
    </Wrapper>
  );
};

type propsType = {
  src: string;
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
