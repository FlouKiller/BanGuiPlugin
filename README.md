# BanGuiPlugin

[![Spigot](https://img.shields.io/badge/Spigot-1.20.4-orange.svg)](https://www.spigotmc.org/)
[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

**BanGuiPlugin** est un plugin Minecraft Spigot moderne qui permet aux administrateurs de gérer les sanctions (bannissements, mutes) via une interface graphique intuitive.

## 🚀 Fonctionnalités

- **Interface graphique moderne** : Gestion des sanctions via des menus Minecraft intuitifs
- **Système de bannissement** : Bannissement temporaire et permanent des joueurs
- **Système de mute** : Mute temporaire des joueurs avec gestion automatique
- **Catégories de sanctions** :
  - 📝 **Messages** : Sanctions liées au contenu des messages
  - 🛡️ **Triche** : Sanctions pour l'utilisation de cheats/mods
  - ⚡ **Abus** : Sanctions pour abus divers
- **Menu de confirmation** : Évite les sanctions accidentelles
- **Informations détaillées** : Affichage des informations du joueur (statut, santé, IP)
- **Gestion automatique** : Détection automatique des joueurs mutés et bannés

## 📋 Prérequis

- **Minecraft** : Version 1.20.4
- **Java** : Version 17 ou supérieure
- **Spigot/Paper** : Version 1.20.4 ou compatible

## 🔧 Installation

1. **Téléchargement** : Téléchargez le fichier `BanGuiPlugin-1.0-SNAPSHOT.jar` depuis les [releases](../../releases)

2. **Installation** : Placez le fichier `.jar` dans le dossier `plugins/` de votre serveur

3. **Redémarrage** : Redémarrez votre serveur ou utilisez `/reload`

4. **Configuration** : Le plugin est prêt à l'emploi !

## 🎮 Commandes

| Commande | Description | Permission | Utilisation |
|----------|-------------|------------|-------------|
| `/bangui <joueur>` | Ouvre l'interface de sanctions | `banguiplugin.bangui` | `/bangui Notch` |
| `/bg <joueur>` | Alias de `/bangui` | `banguiplugin.bangui` | `/bg Notch` |
| `/mute <joueur> <durée> <raison>` | Mute un joueur | `banguiplugin.mute` | `/mute Notch 1h Spam` |
| `/unmute <joueur>` | Démute un joueur | `banguiplugin.unmute` | `/unmute Notch` |

## 🔐 Permissions

| Permission | Description | Par défaut |
|------------|-------------|------------|
| `banguiplugin.bangui` | Accès à l'interface de sanctions | `op` |
| `banguiplugin.mute` | Pouvoir mute des joueurs | `op` |
| `banguiplugin.unmute` | Pouvoir démute des joueurs | `op` |

## 🖼️ Interface utilisateur

### Menu principal
Le menu principal affiche :
- **Tête du joueur** avec informations (statut, santé, IP si en ligne)
- **Catégories de sanctions** :
  - 📝 Messages (spam, insultes, etc.)
  - 🛡️ Triche (hacks, exploits)
  - ⚡ Abus (grief, comportement toxique)

### Menus de sanctions
Chaque catégorie propose des sanctions prédéfinies avec :
- Durées variées (temporaire/permanent)
- Raisons spécifiques
- Menu de confirmation pour éviter les erreurs

## 🏗️ Structure du projet

```
src/main/java/fr/floukiller/banguiplugin/
├── Main.java                          # Classe principale du plugin
├── commands/
│   ├── BanguiCommand.java             # Commande /bangui
│   └── MuteCommands.java              # Commandes /mute et /unmute
├── guis/
│   └── BanguiMenu.java                # Interface graphique
├── listeners/
│   ├── BanguiMainMenuListeners.java   # Gestion du menu principal
│   ├── BanguiMessagesMenuListener.java # Gestion du menu messages
│   ├── BanguiCheatMenuListeners.java  # Gestion du menu triche
│   ├── BanguiAbuseMenuListeners.java  # Gestion du menu abus
│   ├── BanGuiConfirmMenuListener.java # Gestion du menu de confirmation
│   ├── BannedPlayerLoginListener.java # Détection des joueurs bannis
│   └── MutedPlayersListener.java      # Gestion des joueurs mutés
├── managers/
│   ├── EventsManager.java             # Gestionnaire d'événements
│   └── SanctionsManager.java          # Gestionnaire de sanctions
└── utils/
    └── ItemBuilder.java               # Utilitaire de création d'items
```

## 🛠️ Développement

### Compilation

```bash
# Cloner le projet
git clone https://github.com/votre-username/BanGuiPlugin.git
cd BanGuiPlugin

# Compiler avec Maven
mvn clean package

# Le fichier .jar sera dans target/
```

### Dépendances

- **Spigot API** : 1.20.4-R0.1-SNAPSHOT
- **Java** : 17
- **Maven** : Pour la compilation

## 🤝 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Forkez le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Committez vos changements (`git commit -am 'Ajouter nouvelle fonctionnalité'`)
4. Poussez vers la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Ouvrez une Pull Request

## 📝 Changelog

### Version 1.0.0
- ✨ Interface graphique pour les sanctions
- ✨ Système de bannissement et mute
- ✨ Catégories de sanctions (Messages, Triche, Abus)
- ✨ Menu de confirmation
- ✨ Gestion automatique des joueurs sanctionnés

## 📞 Support

- **Issues** : [GitHub Issues](../../issues)
- **Wiki** : [Documentation complète](../../wiki)
- **Discord** : [Serveur de support](#)

## 📄 Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

## 👨‍💻 Auteur

**Floukiller** - Développeur principal

---

⭐ **N'hésitez pas à mettre une étoile si ce plugin vous a été utile !**