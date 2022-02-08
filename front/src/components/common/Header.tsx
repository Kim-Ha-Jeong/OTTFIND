import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import logo from "@images/logo.png";
import userIcon from "@images/user-icon.png";

import Link from "@components/header/Link";
import SearchBar from "@components/header/SearchBar";

const Header = () => {
  const navigate = useNavigate();
  const moveHome = () => {
    navigate("/");
  };

  return (
    <Wrapper>
      <LogoImg src={logo} onClick={moveHome} />
      <LinkWrapper>
        <Link id="" link="홈" />
        <Link id="movie" link="영화" />
        <Link id="drama" link="드라마" />
      </LinkWrapper>
      <SearchBar />
      <UserImg src={userIcon} />
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
  }
`;

const UserImg = styled.img`
  width: 50px;
  height: 50px;
`;
