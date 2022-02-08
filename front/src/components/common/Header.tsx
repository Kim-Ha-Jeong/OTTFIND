import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import logo from "@images/logo.png";
import userIcon from "@images/user-icon.png";

import Link from "@components/header/Link";
import SearchBar from "@components/header/SearchBar";

const Header = () => {
  const [current, setCurrent] = useState("전체");
  const navigate = useNavigate();
  const moveHome = () => {
    navigate("/");
  };

  const moveHandler = () => {
    navigate("/user");
  };

  return (
    <Wrapper>
      <LogoImg src={logo} onClick={moveHome} />
      <LinkWrapper>
        <Link id="전체" type="홈" current={current} setCurrent={setCurrent} />
        <Link id="영화" type="영화" current={current} setCurrent={setCurrent} />
        <Link
          id="드라마"
          type="드라마"
          current={current}
          setCurrent={setCurrent}
        />
      </LinkWrapper>
      <SearchBar />
      <UserImg src={userIcon} onClick={moveHandler} />
    </Wrapper>
  );
};
export default Header;

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
`;

const LinkWrapper = styled(Wrapper)`
  width: 20%;
`;

const LogoImg = styled.img`
  width: 280px;
  &: hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;

const UserImg = styled.img`
  width: 50px;
  height: 50px;
  &: hover {
    cursor: pointer;
    opacity: 0.5;
  }
`;
