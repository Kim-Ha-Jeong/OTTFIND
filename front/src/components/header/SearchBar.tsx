import React, { useState } from "react";
import styled from "styled-components";

import get from "@ts/get";

const SearchBar = () => {
  const [title, setTitle] = useState("");

  const onKeyPressHandler = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === "Enter") search();
  };

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setTitle(e.target.value);
  };

  const search = async () => {
    const film = await get({ pathname: "film", params: { title: title } });

    if (film.status === 200) {
      //console.log(film.data);
    }
  };

  return (
    <Wrapper>
      <Input
        placeholder="영화나 드라마 제목을 입력하세요"
        onChange={onChangeHandler}
        onKeyPress={onKeyPressHandler}
      />
    </Wrapper>
  );
};

const Wrapper = styled.div``;

const Input = styled.input`
  border: none;
  background-color: white;
  height: 40px;
  width: 650px;
  padding-left: 10px;
  font-size: 15px;
  color: black;
`;

export default SearchBar;
