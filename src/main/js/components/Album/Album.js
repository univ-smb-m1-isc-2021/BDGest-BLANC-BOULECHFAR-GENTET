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
        this.setState({
            showDetails: true
        })
    }

    masquerDetails = () => {
        this.setState({
            showDetails: false
        })
    }

    updateList = () => {
        console.log("UpdateList dans Album");
        this.props.updateAlbumList();
    }

    render() {
        return (
            <div id="divVignetteAlbum">
                <img id="imgVignetteAlbum" alt={this.props.album.title} src={this.props.album.img} onClick={() => this.afficherDetails()}/>
                <div id="titreAlbum" onClick={() => this.afficherDetails()}>
                    <span title={this.props.album.title}>{this.finalTitle}</span>
                </div>
                {
                    this.state.showDetails ?
                        <div class="popupDetailsAlbumWrapper">
                            <div className="popupDetailsAlbum">
                                <DetailsAlbum album={this.props.album} user_id={this.props.user_id}
                                              userAlbumList={this.props.userAlbumList} updateAlbumList={this.updateList}
                                              inCollection={this.props.inCollection}
                                              masquerDetails={this.masquerDetails}/>
                                <button id="boutonFermerPopup" onClick={() => this.masquerDetails()}>X</button>
                            </div>
                        </div>
                        :
                        null
                }
            </div>
        );
    }
}
