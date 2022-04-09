import React from 'react'
import "./Menu.css"

export default function Menu() {
    return (
        <header>
            <h1 id="title">BDGest</h1>
            <ul id="listeLiens">
                <li><a>Accueil</a></li>
                <li><a>Catalogue</a></li>
                <li><a>Ma collection</a></li>
            </ul>
            <span id="separator"></span>
            <span><a>Se connecter</a> / <a>S'inscrire</a></span>
        </header>
    )
}
