package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<Article> articles;
}
