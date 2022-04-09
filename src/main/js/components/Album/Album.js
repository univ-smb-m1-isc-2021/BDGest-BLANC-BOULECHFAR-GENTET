import React, {Component} from "react";
import './Album.css';

class Album extends Component {

    constructor(props) {
        super(props);
        let finalTitle = this.props.album.title;
        if (this.props.album.title.length > 15) {
            this.finalTitle = this.props.album.title.substring(0, 15) + "...";
        }
    }

    render() {
        return (
            <div id="divVignetteAlbum">
                <img alt={this.props.album.title} src={this.props.album.img}/>
                <p title={this.props.album.title}>{this.finalTitle}</p>
            </div>
        );
    }
}

export default Album;