package UI;

public class UI {

    int position;

    public UI() {
        position = 7;
    }

    // Get and Set position
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public void display(char e0, char e1, char e2, char e3, char e4, char e5, char e6, char e7, char e8, char e9, char e10, char e11, char e12, char e13, char e14){
        System.out.println("" +
                "---------------------------------------------------\n" +
                "|         |         |         |         |         |\n" +
                "|         |         |         |         |         |                          o Key symbols :\n" +
                "|    "+e0+"    |    "+e1+"    |    "+e2+"    |    "+e3+"    |    "+e4+"    |    => Enclosure\n" +
                "|         |         |         |         |         |                          - X : Player\n" +
                "|         |         |         |         |         |                          - ? : Empty enclosure\n" +
                "---------------------------------------------------                          - ~ : Dirty enclosure\n" +
                "(         (         (         (         (         (                          - ! : Hungry creatures\n" +
                " )         )         )         )         )         )\n" +
                "(    "+e5+"    (    "+e6+"    (    "+e7+"    (    "+e8+"    (    "+e9+"    (    => Aquarium\n" +
                " )         )         )         )         )         )\n" +
                "(         (         (         (         (         (\n" +
                "---------------------------------------------------\n" +
                "<         >         <         >         <         >\n" +
                ">         <         >         <         >         <\n" +
                "<    "+e10+"    >    "+e11+"    <    "+e12+"    >    "+e13+"    <    "+e14+"    >    => Aviary\n" +
                ">         <         >         <         >         <\n" +
                "<         >         <         >         <         >\n" +
                "---------------------------------------------------\n" +
                "\n" +
                "o Selected enclosure :\n" +
                "- enclosure type\n" +
                "- creatures type\n" +
                "- x/10\n" +
                "- show creatures\n" +
                "- enclosure dirtiness\n" +
                "\n" +
                "o Actions :\n" +
                "- Move (Z,Q,S,D)\n" +
                "- Clean (or C)\n" +
                "- Feed (or F)\n" +
                "\n" +
                "- - - - - - - - - -\n" +
                "*Licorn noises*");
    }
}
