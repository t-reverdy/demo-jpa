package fr.sdv.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE_DEBUT")
    private LocalDateTime date_debut;

    @Column(name = "DELAI")
    private int delai;

    @Column(name = "DATE_FIN")
    private LocalDateTime date_fin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
        joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
        inverseJoinColumns =@JoinColumn(name="ID_LIV", referencedColumnName = "ID"))
    private Set<Livre> livres;

    public Emprunt() {}

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", date_debut=").append(date_debut);
        sb.append(", delai=").append(delai);
        sb.append(", date_fin=").append(date_fin);
        sb.append('}');
        return sb.toString();
    }
}
