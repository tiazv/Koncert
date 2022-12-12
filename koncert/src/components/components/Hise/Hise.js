import React, { useEffect, useState } from "react";
import api from "../../../services/api";

export default function Hise(){
    const [hise, setHise] = useState([]); //zacetno stanje je prazen seznam
    useEffect(() =>{ //vsakic ko se osvezi stran
        api.get("/hise").then((result) => {
            setHise(result.data); //.data da pridemo do dejanskih podatkov ki jih je server vrnil
            console.log(result.data); //ni fajn met tega? zacasna resitev
        })
    }, []); //npr samo ko se idHise spremeni, ce hoces vsakic das to stran ampak ni ravno fajn - ciklično
    return(
        <>
            <h1>Hise stran</h1>
            <Link to="/hise/dodaj"><Button>Dodaj hišo</Button></Link>
            {
                hise.map((hisa) => (<p key={hisa.id} >{hisa.naslov} - {hisa.hisnaSt}</p>))
            }
        </> //samo ena znacka se more vrnit
    );
}