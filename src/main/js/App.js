import React, {Component} from 'react';
import './App.css';
import Accueil from "./components/Accueil/Accueil.js";
import Catalogue from "./components/Catalogue/Catalogue.js";
import Collection from "./components/Collection/Collection.js";
import Connexion from "./components/Connexion/Connexion.js";
import Inscription from "./components/Inscription/Inscription.js";

export default class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentComponent: "Accueil",
            components: {},
            user_id: -1,
            user_login: "%null%"
        }
    }

    setLinks() {
        this.setState({
            components: {
                "Accueil": <Accueil />,
                "Catalogue": <Catalogue user_id={this.state.user_id} />,
                "Collection": <Collection user_id={this.state.user_id} />,
                "Connexion": <Connexion onLogin={this.getUserInfos} />,
                "Inscription": <Inscription />
            }
        })
    }

    changeContent(contentName) {
        this.setState({currentComponent: contentName});
    }

    getUserInfos = (user_id, user_login) => {
        this.setState({
            user_id: user_id,
            user_login: user_login,
            currentComponent: "Accueil"
        });
        this.setLinks();
    }

    disconnectUser() {
        this.setState({
            user_id: -1,
            user_login: "%null%",
            currentComponent: "Accueil"
        });
        setTimeout(() => {
            console.log(this.state.user_id);
            this.setLinks();
        }, 50);
    }

    componentWillMount() {
        this.setLinks();
    }

    render() {
        return (
            <div class="mainDiv">
                <header>
                    <img src="./book.png"/>
                    <h1 id="title">BDGest</h1>
                    <ul class="listeLiens">
                        <li onClick={() => this.changeContent("Accueil")}>Accueil</li>
                        <li onClick={() => this.changeContent("Catalogue")}>Catalogue</li>
                        {
                            this.state.user_id != -1 ?
                                <li onClick={() => this.changeContent("Collection")}>Ma collection</li>
                                :
                                null
                        }
                    </ul>
                    <span id="separator"></span>
                    {
                        this.state.user_id != -1 ?
                            <ul className="listeLiens">
                                <li>{this.state.user_login}</li>
                                <li onClick={() => this.disconnectUser()}>Déconnexion</li>
                            </ul>
                            :
                            <ul className="listeLiens">
                                <li onClick={() => this.changeContent("Connexion")}>Connexion</li>
                                <li onClick={() => this.changeContent("Inscription")}>Inscription</li>
                            </ul>
                    }

                </header>

                <div id="contenuPage">
                    {this.state.components[this.state.currentComponent]}
                </div>
            </div>
        );
    }

}
