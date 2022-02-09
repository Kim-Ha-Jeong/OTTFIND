import React from "react";
import { useRecoilState } from "recoil";
import styled from "styled-components";

import { searchState, clickState } from "@ts/state";

const SearchBar = () => {
  const [search, setSearch] = useRecoilState(searchState);
  const [click, setClick] = useRecoilState(clickState);

  const onKeyPressHandler = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === "Enter") setSearch({ enter: true, title: search.title });
  };

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearch({ enter: false, title: e.target.value });
  };

  const onClickHandler = (e: React.MouseEvent<HTMLInputElement>) => {
    setClick(true);
  };

  const onBlurHandler = (e: React.FocusEvent<HTMLInputElement>) => {
    setClick(false);
  };

  return (
    <Wrapper>
      <Input
        placeholder="영화나 드라마 제목을 입력하세요"
        onChange={onChangeHandler}
        onKeyPress={onKeyPressHandler}
        onClick={onClickHandler}
        onBlur={onBlurHandler}
      />
    </Wrapper>
  );
};

const Wrapper = styled.div``;

const Input = styled.input`
  background-color: black;
  border: 1px solid rgba(255, 255, 255, 0.2);
  height: 40px;
  width: 650px;
  padding-left: 10px;
  font-size: 15px;
  color: white;
  font-weight: bold;
`;

export default SearchBar;
