import React, {Component} from "react";
import "./Inscription.css";

export default class Inscription extends Component {

    inscription() {
        let pseudo = document.getElementById("inputPseudo").value;
        let password = document.getElementById("inputPassword").value;
        let selectRole = document.getElementById("selectRole");
        let role = selectRole.options[selectRole.selectedIndex].value;
        console.log("Salut :" + pseudo + ", " + password + ", " + role);
        if (pseudo != "" && password != "" && role != "none") {
            const axios = require("axios");
            axios.get("/api/addUser?login=" + pseudo + "&password=" + password + "&role=" + role);
            document.getElementById("inputPseudo").value = "";
            document.getElementById("inputPassword").value = "";
            selectRole.selectedIndex = 0;
        } else {
            alert("Veuillez remplir tous les champs !");
        }
    }

    render() {
        return (
            <div id="divInscription">
                <h1>Inscrivez-vous sur BDGest :</h1>
                <label for="inputPseudo">Nom d'utilisateur :</label>
                <br/>
                <input id="inputPseudo" type="text"/>
                <br/>
                <label for="inputPassword">Mot de passe :</label>
                <br/>
                <input id="inputPassword" type="password"/>
                <br/>
                <select id="selectRole">
                    <option value="none" selected disabled="true">Sélectionnez un rôle</option>
                    <option value="Utilisateur">Utilisateur</option>
                    <option value="Administrateur">Administrateur</option>
                </select>
                <br/>
                <button onClick={() => this.inscription()}>S'inscrire</button>
            </div>
        );
    }
}
