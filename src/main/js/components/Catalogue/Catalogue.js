import React, {Component} from "react";
import "./Catalogue.css";
import Album from "../Album/Album";

export default class Catalogue extends Component {

    constructor(props) {
        super(props);
        this.state = {
            albumList: []
        }
    }

    componentWillMount() {
        const axios = require("axios");
        axios.get("/api/getAllAlbums")
            .then(response => {
                this.setState({albumList: response.data});
            });
    }

    render() {
        return (
            <div id="listeAlbumsWrapper">

                <h1>Catalogue :</h1>

                <div id="divBarreDeRecherche">
                    <input id="inputRecherche" type="text" placeholder="Rechercher un album par titre..."/>
                    <img id="imageLoupe" src="./search.png"/>
                </div>

                <div id="divListeAlbums">
                    {this.state.albumList.map(album => <Album album={album} user_id={this.props.user_id}/>)}
                </div>

            </div>

        );
    }
}
