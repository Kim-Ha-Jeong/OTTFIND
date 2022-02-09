import React, { useEffect, useState } from "react";
import { useSetRecoilState } from "recoil";
import { useParams } from "react-router-dom";
import styled from "styled-components";

import get from "@ts/get";
import { currentState } from "@ts/state";
import Header from "@components/header/header";

const FilmDetail = () => {
  const param = useParams();
  const [data, setData] = useState([]);
  const setCurrent = useSetRecoilState(currentState);

  const getFilms = async () => {
    const film = await get({
      pathname: "film",
      params: { id: param.id },
    });

    if (film.status === 200) {
      if (film.data.length === 1) {
        setData(film.data[0]);
      }
    }
  };

  useEffect(() => {
    setCurrent("상세");
  }, []);

  useEffect(() => {
    getFilms();
  }, [param]);

  return (
    <Wrapper>
      <Header />
      {param.id}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default FilmDetail;
