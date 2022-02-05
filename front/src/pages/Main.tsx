import React, { useState, useEffect } from "react";

const Main = () => {
  const [message, setMessage] = useState("");
  useEffect(() => {
    fetch(`${process.env.REACT_APP_API_URL}/user`)
      .then((response) => response.text())
      .then((message) => {
        setMessage(message);
      });
  }, []);
  return <div>{message}</div>;
};
export default Main;
