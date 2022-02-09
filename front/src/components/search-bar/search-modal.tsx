import React, { useEffect } from "react";
import { useRecoilValue, useRecoilState } from "recoil";
import styled from "styled-components";

import get from "@ts/get";
import { searchState, prevState } from "@ts/state";
import FilmPreview from "@components/film-preview/film-preview";

const SearchModal = () => {
  const search = useRecoilValue(searchState);
  const [prev, setPrev] = useRecoilState(prevState);

  const getFilms = async () => {
    const film = await get({
      pathname: "film",
      params: { title: search.title },
    });

    if (film.status === 200) {
      if (film.data.length > 0) {
        setPrev({ find: true, data: film.data });
      }
    }
  };

  useEffect(() => {
    getFilms();
  }, [search]);

  return (
    <Wrapper>
      <FilmPreview />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  width: 662px;
  position: absolute;
  background-color: black;
  top: 76px;
  left: 729px;
`;

export default SearchModal;
