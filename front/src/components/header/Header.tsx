import React from "react";
import { useRecoilState } from "recoil";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import logo from "@images/logo.png";
import userIcon from "@images/user-icon.png";

import { currentState } from "@ts/state";
import Link from "@components/header/link";
import SearchBar from "@components/search-bar/search-bar";
import SearchModal from "@components/search-bar/search-modal";

const Header = () => {
  const linkArr = ["홈", "영화", "드라마"];
  const [current, setCurrent] = useRecoilState(currentState);
  const navigate = useNavigate();
  const moveHome = () => {
    setCurrent("홈");
    navigate("/");
  };

  const moveHandler = () => {
    navigate("/user");
  };

  return (
    <Wrapper>
      <LogoImg src={logo} onClick={moveHome} />
      <LinkWrapper>
        {linkArr.map((ele, idx) => (
          <Link key={idx} id={ele} type={ele} />
        ))}
      </LinkWrapper>
      <SearchBar />
      <UserImg src={userIcon} onClick={moveHandler} />
      <SearchModal />
    </Wrapper>
  );
};

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  flex-wrap: wrap;
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

export default Header;
