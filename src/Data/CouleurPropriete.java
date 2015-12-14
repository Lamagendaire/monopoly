package Data;

public enum CouleurPropriete {
	bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge;
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
        if (this == bleuFonce) { couleur = "34"; } else
            if (this == rouge) { couleur = "31"; } else
                if (this == vert) { couleur = "32"; } else
                    if (this == jaune) { couleur = "33"; } else
                        if (this == mauve) { couleur = "35"; } else
                            if (this == bleuCiel) { couleur = "36"; } 
                            else { couleur = "30"; } 

       
        return "\033[" + couleur + "m" + infos + "\033[0m";
}

}