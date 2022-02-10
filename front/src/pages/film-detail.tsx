import React, { useEffect, useState } from "react";
import { useSetRecoilState } from "recoil";
import { useParams } from "react-router-dom";
import styled from "styled-components";

import get from "@ts/get";
import { currentState } from "@ts/state";
import Header from "@components/header/header";
import FilmDetailBox from "@components/film-detail/film-detail-box";

const FilmDetailPage = () => {
  const param = useParams();
  const [data, setData] = useState<any>([]);
  const [ott, setOtt] = useState<any>([]);
  const [review, setReview] = useState<any>([]);
  const setCurrent = useSetRecoilState(currentState);

  const getFilms = async () => {
    const film = await get({
      pathname: "film",
      params: { id: param.id },
    });

    const ott = await get({
      pathname: "ott",
      params: { film_id: param.id },
    });

    const review = await get({
      pathname: "review",
      params: { film_id: param.id },
    });

    if (film.status === 200) {
      setData(film.data);
      setOtt(ott.data);
      setReview(review.data);
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
      {data && ott && review && (
        <FilmDetailBox data={data} ott={ott} review={review} />
      )}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  margin: 1%;
`;

export default FilmDetailPage;
