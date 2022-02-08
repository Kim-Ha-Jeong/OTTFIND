import axios from "axios";

const get = (link: GetType) => {
  try {
    const result = axios.get(
      `${process.env.REACT_APP_API_URL}/${link.pathname}`,
      {
        params: link.params,
      }
    );
    return result;
  } catch (err) {
    throw err;
  }
};

type GetType = {
  pathname: string;
  params?: Object | null;
};

export default get;
