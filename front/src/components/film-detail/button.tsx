import React, { useRef, useState } from "react";
import styled from "styled-components";

import checkColor from "@images/check-color.png";
import heartColor from "@images/heart-color.png";
import xColor from "@images/x-color.png";

const Button = (props: PropsType) => {
  const btnRef = useRef(null);
  const [change, setChange] = useState(false);
  const colorChangeArr = [
    { src: checkColor, color: "#00FB00" },
    { src: heartColor, color: "#FF6243" },
    { src: xColor, color: "#FF0000" },
  ];

  const onClickHandler = (e: React.MouseEvent<HTMLElement>) => {
    const target = e.target as HTMLElement;
    const button = target.closest("button");
    const img = button!.firstChild as HTMLImageElement;
    const p = button!.lastChild as HTMLElement;
    const id = Number(button!.id);

    if (change) {
      img!.src = props.src;
      p.style.color = "white";
      setChange(false);
    } else {
      img!.src = colorChangeArr[id].src;
      p.style.color = colorChangeArr[id].color;
      setChange(true);
    }
  };

  return (
    <Btn ref={btnRef} id={`${props.id}`}>
      <Img src={props.src} onClick={onClickHandler} />
      <p>{props.text}</p>
    </Btn>
  );
};

type PropsType = {
  text: string;
  src: string;
  id: number;
};

const Img = styled.img`
  padding-bottom: 5px;
`;
const Btn = styled.button`
  margin-bottom: 20px;
  font-size: 15px;
  width: 33%;
  padding: 3% 0;
  border: none;
`;

export default Button;
