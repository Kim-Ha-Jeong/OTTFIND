import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import Button from "@components/film-detail/button";
import OttBtn from "@components/common/ottBtn";
import Review from "@components/common/review";

import x from "@images/x.png";
import heart from "@images/heart.png";
import check from "@images/check.png";

const FilmDetailBox = (props: DataType) => {
  const nav = useNavigate();
  const btnArr = [
    { text: "봤어요", src: check },
    { text: "좋아요", src: heart },
    { text: "싫어요", src: x },
  ];

  const film = props.data;
  const ottArr = props.ott;
  const reviewArr = props.review;

  const onClickHandler = (e: React.MouseEvent<HTMLButtonElement>) => {
    //nav("/");
  };

  return (
    <Wrapper>
      <PosterWrapper>
        <Img src={`/poster/${film.poster_url}`} />
        <ButtonWrapper>
          {btnArr.map((ele, idx) => (
            <Button text={ele.text} src={ele.src} id={idx} key={idx} />
          ))}
        </ButtonWrapper>
      </PosterWrapper>
      <ContentWrapper>
        <Title>
          {film.title}({film.year})
        </Title>
        <SubTitle>{film.country}</SubTitle>
        <SubTitle>{film.genre?.name}</SubTitle>
        <P>줄거리</P>
        <Desc>{film.content}</Desc>
        <P>시청 가능</P>
        <OttWrapper>
          {ottArr.map((ele, idx) => (
            <OttBtn name={ele.name} opt={ele.opt} key={idx} />
          ))}
        </OttWrapper>
        <ReviewTitleWrapper>
          <ReviewTitle>리뷰</ReviewTitle>
          <ReviewBtn onClick={onClickHandler}>리뷰 작성하기</ReviewBtn>
        </ReviewTitleWrapper>
        {reviewArr.map((ele, idx) => (
          <Review content={ele.content} user={ele.user} key={idx} />
        ))}
      </ContentWrapper>
    </Wrapper>
  );
};

type DataType = {
  data: FilmType;
  ott: any[];
  review: any[];
};

type FilmType = {
  country: string;
  director: string;
  id: number;
  genre: { id: number; name: string };
  poster_url: string;
  season: number;
  time: number;
  title: string;
  type: string;
  year: number;
  content: string;
};

const Wrapper = styled.div`
  width: 80%;
  margin: 2% 10%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

const Img = styled.img`
  width: 100%;
`;

const PosterWrapper = styled.div`
  width: 25%;
`;

const ButtonWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  padding-top: 6%;
`;

const ContentWrapper = styled.div`
  width: 70%;
  display: flex;
  flex-direction: column;
`;

const Title = styled.div`
  font-size: 30px;
  font-weight: bold;
  margin-bottom: 20px;
`;
const P = styled.p`
  font-size: 20px;
  font-weight: 600;
  margin: 25px 0 8px 0;
`;

const SubTitle = styled.p`
  font-size: 17px;
  font-weight: bold;
  margin: 3px 0;
`;

const ReviewTitle = styled.p`
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 20px;
`;

const ReviewTitleWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

const ReviewBtn = styled.button`
  background-color: #222222;
  margin-bottom: 5px;
  font-weight: bold;
  border-radius: 10px;
  border: 1px solid black;
  padding: 0 20px;
`;

const Desc = styled.p`
  font-size: 15px;
  line-height: 140%;
`;

const OttWrapper = styled.div`
  margin-top: 10px;
  display: flex;
  justify-content: flex-start;
`;

export default FilmDetailBox;
