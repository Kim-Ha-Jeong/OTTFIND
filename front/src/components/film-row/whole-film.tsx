import React, { useEffect, useState } from "react";
import { useRecoilValue } from "recoil";
import styled from "styled-components";

import { currentState } from "@ts/state";
import get from "@ts/get";
import Film from "@components/film-row/film";

const WholeFilm = () => {
  const current = useRecoilValue(currentState);
  const [films, setFilms] = useState<any[]>([]);

  const getFilms = async () => {
    const apiLocation = { pathname: "film" };
    if (current === "드라마" || current === "영화") {
      Object.assign(apiLocation, { params: { type: current } });
    } else if (current !== "홈") {
      Object.assign(apiLocation, { params: { ott: current } });
    }

    const result = await get(apiLocation);

    if (result.status === 200) {
      setFilms(result.data);
    }
  };

  useEffect(() => {
    getFilms();
  }, [current]);

  return (
    <Wrapper>
      {films.map((ele, idx) => (
        <Film src={ele.poster_url} key={idx} id={ele.id} />
      ))}
    </Wrapper>
  );
};

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin: 0 2% 2% 2%;
  flex-wrap: wrap;
  justify-content: flex-start;
`;

export default WholeFilm;
