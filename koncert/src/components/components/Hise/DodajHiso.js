import React from 'react';
import { TextField } from "@mui/material";
import { CheckBox } from '@mui/icons-material';
import api from '../../../services/api';
import { useNavigate } from 'react-router-dom';


export default function DodajHiso(){
    const [naslov, setNaslov] = usestate("to je zacetna vrednost"); 
    const [hisnaSt, setHisnaSt] = usestate(0);
    const [velikost, setVelikost] = usestate(0);
    const [vrt, setVrt] = usestate(false);

    let navigate = useNavigate();
    
//function preveri(event){}   - lahko kao tak naredis namesto tam event

function dodajHiso(){
    api.post("/hise", {
        naslov: naslov,
        hisnaSt: hisnaSt,
        velikost: velikost,
        vrt: vrt
    }).then((result) => console.log(result))
}

function pojdiDomov(){
    navigate("/hise");
}

    return (
    <>
        <Button onClick={pojdiDomov}>Domov</Button>
        <br></br> 
        <TextField value={naslov} onChange={(event) => setNaslov(event.target.value)} label="naslov" variant="outlined"/>
        <TextField value={hisnaSt} onChange={(event) => setHisnaSt(event.target.value)} label="hisnaSt" variant="outlined"/>
        <TextField value={velikost} onChange={(event) => setVelikost(event.target.value)} label="velikost" variant="outlined"/>
        <CheckBox checked={vrt} onChange={(event) => setVrt(event.target.checked)} label="vrt"/> vrt

        <Button onClick={dodajHiso}>Dodaj</Button>
    </>
    );
}