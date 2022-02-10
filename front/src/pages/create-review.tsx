import React, { useEffect } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

import Header from "@src/components/header/header";

const CreateReview = () => {
  const param = useParams();

  useEffect(() => {}, [param]);

  return (
    <Wrapper>
      <Header />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default CreateReview;
