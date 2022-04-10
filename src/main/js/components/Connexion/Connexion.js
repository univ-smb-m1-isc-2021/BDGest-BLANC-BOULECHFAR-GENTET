import React, {Component} from "react";
import './Connexion.css';

export default class Connexion extends Component {

    render() {
        return (
            <div id="divConnexion">
                <h1>Connectez-vous sur BDGest :</h1>
                <label for="inputPseudo">Nom d'utilisateur :</label>
                <br/>
                <input id="inputPseudo" type="text"/>
                <br/>
                <label for="inputPassword">Mot de passe :</label>
                <br/>
                <input id="inputPassword" type="password"/>
                <br/>
                <button>Se connecter</button>
            </div>
        );
    }

}
