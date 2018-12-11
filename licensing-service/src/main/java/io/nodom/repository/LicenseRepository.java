package io.nodom.repository;

import io.nodom.domain.License;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, String> {

  public List<License> findByOrganizationId(String organizationId);

  public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
