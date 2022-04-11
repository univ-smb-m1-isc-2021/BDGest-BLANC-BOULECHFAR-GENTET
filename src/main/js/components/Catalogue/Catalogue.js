import React, {Component} from "react";
import "./Catalogue.css";
import Album from "../Album/Album";
import axios from "axios";

export default class Catalogue extends Component {

    constructor(props) {
        super(props);
        this.state = {
            albumList: [],
            userAlbumList: []
        }
    }

    updateList = () => {
        console.log("UpdateList dans catalogue");
        const axios = require("axios");
        axios.get("/api/getAllAlbums")
            .then(response => {
                this.setState({albumList: response.data});
            });
        if (this.props.user_id != -1) {
            axios.get("/api/albumsByUserId?id_user=" + this.props.user_id).then((response) => {
                this.setState({
                    userAlbumList: response.data
                });
            });
        }
    }

    componentWillMount() {
        this.updateList();
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
                    {this.state.albumList.map(album => <Album album={album} user_id={this.props.user_id} userAlbumList={this.state.userAlbumList} updateAlbumList={this.updateList} inCollection={false}/>)}
                </div>

            </div>

        );
    }
}
