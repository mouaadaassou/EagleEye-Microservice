package io.nodom.service;


import io.nodom.client.OrganizationFeignClient;
import io.nodom.domain.License;
import io.nodom.domain.Organization;
import io.nodom.repository.LicenseRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

  private LicenseRepository licenseRepository;


  private OrganizationFeignClient organizationFeignClient;

  public LicenseService(LicenseRepository licenseRepository,
      OrganizationFeignClient organizationFeignClient) {
    this.licenseRepository = licenseRepository;
    this.organizationFeignClient = organizationFeignClient;
  }


  private Organization retrieveOrgInfo(String organizationId, String clientType) {
    Organization organization = null;

    switch (clientType) {
      case "feign":
        System.out.println("I am using the feign client");
        organization = organizationFeignClient.getOrganization(organizationId);
        break;
//      case "rest":
//        System.out.println("I am using the rest client");
//        organization = organizationRestClient.getOrganization(organizationId);
//        break;
//      case "discovery":
//        System.out.println("I am using the discovery client");
//        organization = organizationDiscoveryClient.getOrganization(organizationId);
//        break;
      default:
//        organization = organizationRestClient.getOrganization(organizationId);
    }

    return organization;
  }


  public License getLicense(String organizationId, String licenseId, String clientType) {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

    Organization org = retrieveOrgInfo(organizationId, clientType);

    license.setContactName(org.getContactName());
    license.setOrganizationName(org.getName());
    license.setContactPhone(org.getContactPhone());

    return license;
//        .setComment(config.getExampleProperty());
  }

  public List<License> getLicensesByOrg(String organizationId) {
    return licenseRepository.findByOrganizationId(organizationId);
  }

  public void saveLicense(License license) {
    license.setLicenseId(UUID.randomUUID().toString());

    licenseRepository.save(license);

  }

  public void updateLicense(License license) {
    licenseRepository.save(license);
  }

  public void deleteLicense(License license) {
    licenseRepository.deleteById(license.getLicenseId());
  }


}
