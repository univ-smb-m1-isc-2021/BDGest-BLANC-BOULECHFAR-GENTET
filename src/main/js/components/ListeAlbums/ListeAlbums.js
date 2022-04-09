import React, {Component} from "react";
import Album from "../Album/Album.js";

class ListeAlbums extends Component {

    render() {
        return (
            <Album>
                {this.props.children}
            </Album>
        );
    }
}

export default ListeAlbums;