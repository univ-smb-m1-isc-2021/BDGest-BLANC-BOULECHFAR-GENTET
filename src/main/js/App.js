import React, {Component} from 'react';
import axios from 'axios';
import './App.css';
import Menu from "./components/Menu/Menu.js";
import Album from "./components/Album/Album.js";
import ListeAlbums from "./components/ListeAlbums/ListeAlbums.js";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: []
        }
    }

    componentWillMount() {
        const axios = require("axios");
        axios.get("/api/getAllAlbums")
            .then(response => {
                this.setState({result: response.data});
            });
    }

    render() {
        return (
            <div class="mainDiv">
                <Menu />
                {this.state.result.map(a => <Album album={a}/>)}
            </div>
        );
    }

}

export default App;
