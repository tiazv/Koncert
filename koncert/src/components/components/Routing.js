import React from "react";
import {Route, Routes} from "react-router-dom";
import DodajHiso from "./Hise/DodajHiso";
import PageNotFound from "./PageNotFound/PageNotFound";
//kateri url me pelje na katero pot
export default function Routing(){
    return(
        <Routes>
            <Route path="/" element={<Hise/>} />
            <Route path="/hise" element={<Hise/>} />
            <Route path="/hise/dodaj" element={<DodajHiso/>} />
            <Route path="*" element={<PageNotFound/>} />
        </Routes>
    );
}