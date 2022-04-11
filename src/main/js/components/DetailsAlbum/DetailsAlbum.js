import React, {Component} from "react";
import './DetailsAlbum.css';

export default class DetailsAlbum extends Component {

    constructor(props) {
        super(props);
    }

    addAlbumToCollection() {
        if (this.props.user_id != -1) {
            const axios = require("axios");
            console.log(this.props.album);
            axios.get("/api/addAlbumToUser?id_user=" + this.props.user_id + "&id_album=" + this.props.album.id_album).then((response) => {
                if (response.data == false) {
                    alert("Erreur sur l'ajout");
                }
            });
        }
    }

    render() {
        return (
            <div class="divDetailsAlbum">
                <img src={this.props.album.img}/>
                <div id="divInfosAlbum">
                    <h1>{this.props.album.title}</h1>
                    <p>Série : {this.props.album.serie}</p>
                    <p>Numéro de série : {this.props.album.num_serie}</p>
                    <p>ISBN : {this.props.album.isbn}</p>
                    {
                        this.props.user_id != -1 ?
                            <button onClick = {() => this.addAlbumToCollection()}>Ajouter à ma collection</button>
                            :
                            null
                    }
                    <br/>
                </div>
            </div>
        );
    }

}
