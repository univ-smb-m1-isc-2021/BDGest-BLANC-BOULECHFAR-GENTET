import React, {Component} from "react";
import './Accueil.css';

export default class Accueil extends Component {
    render() {
        return (
            <div id="divAccueilWrapper">
                <div id="divAccueil">
                    <h1>Bienvenue sur BDGest</h1>
                    <p>Voici 3 albums parmis notre catalogue :</p>
                    <div id="divAlbumsAccueil">

                    </div>
                </div>
            </div>
        );
    }
}
