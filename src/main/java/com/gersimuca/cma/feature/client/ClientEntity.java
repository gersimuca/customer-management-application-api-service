package com.gersimuca.cma.feature.client;

import com.gersimuca.cma.feature.admin.AdminEntity;
import com.gersimuca.cma.feature.company.CompanyEntity;
import com.gersimuca.cma.feature.lead.LeadEntity;
import com.gersimuca.cma.feature.people.PeopleEntity;
import com.gersimuca.cma.feature.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "client")
public class ClientEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean removed = false;
    private boolean enabled = true;

    @Column(nullable = false)
    private String type = "company";

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private PeopleEntity people;

    @ManyToOne
    @JoinColumn(name = "converted_from_id")
    private LeadEntity convertedFrom;

    @ManyToMany
    @JoinTable(
            name = "client_product",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> interestedIn;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private AdminEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "assigned_id")
    private AdminEntity assigned;

    private String source;
    private String category;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

}
