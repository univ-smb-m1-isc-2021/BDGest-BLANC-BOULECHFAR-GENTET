import React, {Component} from "react";
import './Accueil.css';
import Album from "../Album/Album";

export default class Accueil extends Component {

    constructor(props) {
        super(props);
        this.state = {
            albums: []
        }
    }

    componentWillMount() {
        const axios = require("axios");
        axios.get("/api/getThreeAlbums").then((response) => {
            this.setState({
                albums: response.data
            });
        })
    }

    render() {
        return (
            <div id="divAccueilWrapper">
                <div id="divAccueil">
                    <h1>Bienvenue sur BDGest</h1>
                    <p>Voici 3 albums parmis notre catalogue :</p>
                    <div id="divAlbumsAccueilWrapper">
                        <div id="divAlbumsAccueil">
                            {this.state.albums.map(a => <Album album={a} user_id={null} userAlbumList={null} updateAlbumList={null} inCollection={false}/>)}
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
