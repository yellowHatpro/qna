import {FaGithub, FaLinkedinIn, FaTwitter} from "react-icons/fa";

export const Footer = () => {
    return (
       <div className={"flex flex-col justify-center items-center p-4"}>
           <div className={"text-md"}>
               Made by yellowhatpro
           </div>
           <div className={"flex flex-row text-4xl child:mx-4"}>
               <FaGithub/>
               <FaTwitter/>
               <FaLinkedinIn/>
           </div>
       </div>
    );
};
