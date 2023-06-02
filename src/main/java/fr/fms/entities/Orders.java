package fr.fms.entities;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private int totalAmount;

    @OneToMany(mappedBy = "order")
    private Collection<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
