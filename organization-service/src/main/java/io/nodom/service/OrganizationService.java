package io.nodom.service;


import io.nodom.domain.Organization;
import io.nodom.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

  private OrganizationRepository organizationRepository;

  public OrganizationService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  public Organization getOrganizationById(String organizationId) {
    return this.organizationRepository.findById(organizationId).get();
  }

  public void saveOrganization(Organization organization) {
    this.organizationRepository.save(organization);
  }

  public void updateOrganization(Organization organization) {
    this.organizationRepository.save(organization);
  }

  public void deleteOrganization(Organization organization) {
    this.organizationRepository.delete(organization);
  }


}
