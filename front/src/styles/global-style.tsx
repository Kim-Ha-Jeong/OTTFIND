import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const globalStyles = createGlobalStyle`
    ${reset}

    * {
        background-color: black;
        color : white;
    }
`;

export default globalStyles;
