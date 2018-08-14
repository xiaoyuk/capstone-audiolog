package org.launchcode.capstone.models;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Audio {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3)
    private String name;

    @NotNull
    @Size(min=1, message="Filepath must not be empty")
    private String filepath;

    @ManyToOne
    private User user;

    public Audio(String name, String filepath) {
        this.name = name;
        this.filepath = filepath;
    }

    public Audio() { }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
