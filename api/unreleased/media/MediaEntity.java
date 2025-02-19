package com.gersimuca.cma.unreleased.media;

import com.gersimuca.cma.unreleased.lead.LeadEntity;
import com.gersimuca.cma.unreleased.offer.OfferEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lead")
public class MediaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String path;
  private String description;
  private Boolean isPublic = true;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "offer_id")
  private OfferEntity offer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lead_id")
  private LeadEntity lead;
}
