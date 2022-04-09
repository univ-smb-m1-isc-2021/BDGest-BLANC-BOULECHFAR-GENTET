import React, {Component} from "react";
import './Album.css';

class Album extends Component {

    constructor(props) {
        super(props);
        if (this.props.album.title.length > 15) {

        }
    }

    componentWillMount() {

    }

    render() {
        return (
            <div id="divVignetteAlbum">
                <img src={this.props.album.img}/>
                <p>{this.props.album.title}</p>
            </div>
        );
    }
}

export default Album;