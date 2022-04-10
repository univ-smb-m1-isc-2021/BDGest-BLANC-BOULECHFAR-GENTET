import React, {Component} from "react";
import './Album.css';
import DetailsAlbum from "../DetailsAlbum/DetailsAlbum";

export default class Album extends Component {

    constructor(props) {
        super(props);
        let finalTitle = this.props.album.title;
        if (this.props.album.title.length > 15) {
            this.finalTitle = this.props.album.title.substring(0, 15) + "...";
        }
        this.state = {
            showDetails: false
        }
    }

    afficherDetails() {
        console.log("Afficher détails !");
        this.setState({
            showDetails: true
        })
    }

    masquerDetails() {
        console.log("Masquer détails")
        this.setState({
            showDetails: false
        })
    }

    render() {
        return (
            <div id="divVignetteAlbum">
                <img alt={this.props.album.title} src={this.props.album.img} onClick={() => this.afficherDetails()}/>
                <div id="titreAlbum" onClick={() => this.afficherDetails()}>
                    <span title={this.props.album.title}>{this.finalTitle}</span>
                </div>
                {
                    this.state.showDetails ?
                        <div class="popupDetailsAlbum">
                            <DetailsAlbum album={this.props.album}/>
                            <button onClick={() => this.masquerDetails()}>Fermer</button>
                        </div>
                        :
                        null
                }
            </div>
        );
    }
}
