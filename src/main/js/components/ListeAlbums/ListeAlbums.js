import React, {Component} from "react";
import "./ListeAlbums.css";

class ListeAlbums extends Component {

    render() {
        return (
            <div id="divListeAlbums">
                {this.props.children}
            </div>
        );
    }
}

export default ListeAlbums;