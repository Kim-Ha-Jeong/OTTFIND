import React from "react";
import { useNavigate } from "react-router-dom";
import { RecoilRoot } from "recoil";
import styled from "styled-components";

import logo from "@images/logo.png";
import userIcon from "@images/user-icon.png";

import Link from "@components/header/Link";
import SearchBar from "@components/header/SearchBar";

const Header = () => {
  const linkArr = ["홈", "영화", "드라마"];
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
        <RecoilRoot>
          {linkArr.map((ele, idx) => (
            <Link key={idx} id={ele} type={ele} />
          ))}
        </RecoilRoot>
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
