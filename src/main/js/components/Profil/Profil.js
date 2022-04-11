import React, {Component} from "react";
import './Profil.css';

export default class Profil extends Component {

    removeUser() {
        const axios = require("axios");
        axios.get("/api/remUser?id_user=" + this.props.user_id).then(() => {
            this.disconnectUser();
        })
    }

    disconnectUser() {
        this.props.disconnectUser();
    }

    render() {
        return (
            <div id="divProfil">
                <img src="./account.png"/>
                <p>{this.props.user_login} ({this.props.user_role})</p>
                <button onClick={() => this.removeUser()}>Supprimer mon compte</button>
            </div>
        );
    }

}
