package Jeu;

public enum CouleurPropriete {
	bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge,gris;
        /*   \033[XXm
        3. = couleur texte 
        4. = couleur fond
    30, 40 : noir ;
    31, 41 : rouge ;
    32, 42 : vert ;
    33, 43 : jaune ;
    34, 44 : bleu ;
    35, 45 : rose ;
    36, 46 : cyan ;
    37, 47 : gris.*/
            public String toString(String infos) {

        String couleur = "";
        if (this == bleuFonce) { couleur = "\033[34"; } else
            if (this == rouge) { couleur = "\033[31"; } else
                if (this == vert) { couleur = "\033[32"; } else
                    if (this == jaune) { couleur = "\033[33"; } else
                        if (this == orange) { couleur = "\033[43m\033[31"; } else
                        if (this == mauve) { couleur = "\033[35"; } else
                            if (this == bleuCiel) { couleur = "\033[36"; } else
                                if (this == violet) { couleur = "\033[45"; }
                            else { couleur = "\033[47m\033[30"; } 

       
        return "" + couleur + "m" + infos + "\033[0m";
}

}