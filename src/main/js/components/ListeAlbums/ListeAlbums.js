import React, {Component} from "react";
import "./ListeAlbums.css";

export default class ListeAlbums extends Component {

    render() {
        return (
            <div id="listeAlbumsWrapper">

                <div id="divBarreDeRecherche">
                    <input id="inputRecherche" type="text" placeholder="Rechercher un album par titre, ISBN..."/>
                    <img id="imageLoupe" src="./search.png"/>
                </div>

                <div id="divListeAlbums">
                    {this.props.children}
                </div>

            </div>

        );
    }
}
