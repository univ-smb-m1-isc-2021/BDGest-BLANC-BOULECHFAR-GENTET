import React, {Component} from "react";
import "./Collection.css";
import Album from "../Album/Album";

export default class Collection extends Component {

    constructor(props) {
        super(props);
        this.state = {
            albumList: []
        }
    }

    componentWillMount() {
        if (this.props.user_id != -1) {
            const axios = require("axios");
            axios.get("/api/albumsByUserId?id_user=" + this.props.user_id).then((response) => {
                this.setState({
                    albumList: response.data
                });
            });
        }
    }

    render() {
        return (
            <div id="listeAlbumsWrapper">

                <h1>Votre collection de BD :</h1>

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
