import React, {Component} from "react";
import "./Collection.css";
import Album from "../Album/Album";
import axios from "axios";

export default class Collection extends Component {

    constructor(props) {
        super(props);
        this.state = {
            albumList: []
        }
    }

    updateList = () => {
        console.log("UpdateList dans collection");
        if (this.props.user_id != -1) {
            axios.get("/api/albumsByUserId?id_user=" + this.props.user_id).then((response) => {
                this.setState({
                    albumList: response.data
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

                <h1 id="collectionH1">Votre collection de BD</h1>

                <div id="divBarreDeRecherche">
                    <input id="inputRecherche" type="text" placeholder="Rechercher un album par titre..."/>
                    <div id="divImageLoupe">
                        <img id="imageLoupe" src="./search.png"/>
                    </div>
                </div>

                <div id="divListeAlbums">
                    {this.state.albumList.map(album => <Album album={album} user_id={this.props.user_id} userAlbumList={this.state.albumList} updateAlbumList={this.updateList} inCollection={true}/>)}
                </div>

            </div>
        );
    }
}
