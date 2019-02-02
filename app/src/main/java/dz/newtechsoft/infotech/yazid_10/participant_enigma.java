package dz.newtechsoft.infotech.yazid_10;

public class participant_enigma {
    private String nom,prenom,age,ville,willaya,tel,anser,email,enigma_id;

    public participant_enigma(String nom, String prenom, String age, String ville, String willaya, String tel, String anser, String email, String enigma_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ville = ville;
        this.willaya = willaya;
        this.tel = tel;
        this.anser = anser;
        this.email = email;
        this.enigma_id = enigma_id;
    }

    public participant_enigma() {
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getWillaya() {
        return willaya;
    }

    public void setWillaya(String willaya) {
        this.willaya = willaya;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAnser() {
        return anser;
    }

    public void setAnser(String anser) {
        this.anser = anser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnigma_id() {
        return enigma_id;
    }

    public void setEnigma_id(String enigma_id) {
        this.enigma_id = enigma_id;
    }
}
