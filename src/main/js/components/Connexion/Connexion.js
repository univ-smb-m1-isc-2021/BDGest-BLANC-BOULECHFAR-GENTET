import React, {Component} from "react";
import './Connexion.css';
import axios from "axios";

export default class Connexion extends Component {

    getUserInfos = () => {
        let login = document.getElementById("inputPseudo").value;
        let password = document.getElementById("inputPassword").value;
        if (login != "" && password != "") {
            const axios = require("axios");
            axios.get("/api/check?login=" + login + "&password=" + password).then((response) => {
                let user_id = response.data.id;
                if (user_id != -1) {
                    let user_login = response.data.login;
                    this.props.onLogin(user_id, user_login);
                } else {
                    alert("Nom d'utilisateur ou mot de passe incorrect.")
                }
            });
        } else {
            alert("Veuillez remplir tous les champs !");
        }
    }

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
                <button onClick={() => {this.getUserInfos()}}>Se connecter</button>
            </div>
        );
    }

}
