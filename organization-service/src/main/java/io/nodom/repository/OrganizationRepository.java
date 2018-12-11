package io.nodom.repository;


import io.nodom.domain.Organization;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {

  public Optional<Organization> findById(String orgamizationId);

}
