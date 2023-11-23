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

    public void updateEnclosure() {
        char e0=' ', e1=' ', e2=' ', e3=' ', e4=' ', e5=' ', e6=' ', e7=' ', e8=' ', e9=' ', e10=' ', e11=' ', e12=' ', e13=' ', e14=' ';

        // Player position
        if(position==0){e0 = 'X';}if(position==1){e1 = 'X';}if(position==2){e2 = 'X';}if(position==3){e3 = 'X';}if(position==4){e4 = 'X';}if(position==5){e5 = 'X';}if(position==6){e6 = 'X';}if(position==7){e7 = 'X';}if(position==8){e8 = 'X';}if(position==9){e9 = 'X';}if(position==10){e10 = 'X';}if(position==11){e11 = 'X';}if(position==12){e12 = 'X';}if(position==13){e13 = 'X';}if(position==14){e14 = 'X';}

        // Display
        display(e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14);
    }

    public void move(char playerInput) {
        if (playerInput == 'Z' || playerInput == 'z') {
            if(getPosition() >= 0 && getPosition() <= 4) {
                setPosition(getPosition()+10);
            }
            else {
                setPosition(getPosition()-5);
            }
        }
        if (playerInput == 'Q' || playerInput == 'q') {
            if(getPosition() == 0 || getPosition() == 5 || getPosition() == 10) {
                setPosition(getPosition()+4);
            }
            else {
                setPosition(getPosition()-1);
            }
        }
        if (playerInput == 'S' || playerInput == 's') {
            if(getPosition() >= 10 && getPosition() <= 14) {
                setPosition(getPosition()-10);
            }
            else {
                setPosition(getPosition()+5);
            }
        }
        if (playerInput == 'D' || playerInput == 'd') {
            if(getPosition() == 4 || getPosition() == 9 || getPosition() == 14) {
                setPosition(getPosition()-4);
            }
            else {
                setPosition(getPosition()+1);
            }
        }
        updateEnclosure();
    }

}
