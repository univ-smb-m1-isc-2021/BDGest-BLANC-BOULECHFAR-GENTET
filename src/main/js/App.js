import React, {Component} from 'react';
import axios from 'axios';
import './App.css';
import Accueil from "./components/Accueil/Accueil.js";
import Album from "./components/Album/Album.js";
import ListeAlbums from "./components/ListeAlbums/ListeAlbums.js";
import DetailsAlbum from "./components/DetailsAlbum/DetailsAlbum.js";
import Connexion from "./components/Connexion/Connexion.js";
import Inscription from "./components/Inscription/Inscription.js";

export default class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentComponent: "Accueil",
            components: {},
            result: []
        }
    }

    setLinks() {
        this.setState({
            components: {
                "Accueil": <Accueil />,
                "ListeAlbums": <ListeAlbums>{this.state.result.map(a => <Album album={a}/>)}</ListeAlbums>,
                "Connexion": <Connexion />,
                "Inscription": <Inscription />
            }
        })
    }

    changeContent(contentName) {
        this.setState({currentComponent: contentName});
    }

    componentWillMount() {
        const axios = require("axios");
        axios.get("/api/getAllAlbums")
            .then(response => {
                this.setState({result: response.data});
                this.setLinks();
            });
    }

    render() {
        return (
            <div class="mainDiv">
                <header>
                    <img src="./book.png"/>
                    <h1 id="title">BDGest</h1>
                    <ul class="listeLiens">
                        <li onClick={() => this.changeContent("Accueil")}>Accueil</li>
                        <li onClick={() => this.changeContent("ListeAlbums")}>Catalogue</li>
                        <li onClick={() => this.changeContent("ListeAlbums")}>Ma collection</li>
                    </ul>
                    <span id="separator"></span>
                    <ul className="listeLiens">
                        <li onClick={() => this.changeContent("Connexion")}>Connexion</li>
                        <li onClick={() => this.changeContent("Inscription")}>Inscription</li>
                    </ul>
                </header>

                <div id="contenuPage">
                    {this.state.components[this.state.currentComponent]}
                </div>
            </div>
        );
    }

}
