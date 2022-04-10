import React, {Component} from "react";
import './DetailsAlbum.css';

export default class DetailsAlbum extends Component {

    constructor(props) {
        super(props);
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
                    <button>Ajouter à ma collection</button>
                    <br/>
                </div>
            </div>
        );
    }

}
