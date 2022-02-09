import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

import get from "@ts/get";
import Header from "@components/header/header";
import FilmPreviewBox from "@components/film-preview/film-preview-box";

const SearchResult = () => {
  const param = useParams();
  const [data, setData] = useState([]);

  const getFilms = async () => {
    console.log(param.title, "dfjlakjsd");
    const film = await get({
      pathname: "film",
      params: { title: param.title },
    });

    if (film.status === 200) {
      if (film.data.length > 0) {
        console.log(film.data);
        setData(film.data);
      }
    }
  };

  useEffect(() => {
    getFilms();
  }, []);

  return (
    <Wrapper>
      <Header />
      <FilmPreviewBox page="search" data={data} />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default SearchResult;
