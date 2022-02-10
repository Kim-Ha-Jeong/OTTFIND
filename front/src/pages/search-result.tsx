import React, { useEffect, useState } from "react";
import { useSetRecoilState } from "recoil";
import { useParams } from "react-router-dom";
import styled from "styled-components";

import get from "@ts/get";
import { currentState } from "@ts/state";
import Header from "@src/components/header/header";
import FilmPreviewBox from "@components/film-preview/film-preview-box";

const SearchResult = () => {
  const param = useParams();
  const [data, setData] = useState([]);
  const setCurrent = useSetRecoilState(currentState);

  const getFilms = async () => {
    const film = await get({
      pathname: "film",
      params: { title: param.title },
    });

    if (film.status === 200) {
      if (film.data.length > 0) {
        setData(film.data);
      }
    }
  };

  useEffect(() => {
    setCurrent("결과");
  }, []);

  useEffect(() => {
    getFilms();
  }, [param]);

  return (
    <Wrapper>
      <Header />
      <FilmPreviewBox title="" page="search" data={data} />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default SearchResult;
