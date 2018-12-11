package io.nodom.controller;


import io.nodom.domain.Organization;
import io.nodom.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationController {


  private OrganizationService organizationService;

  public OrganizationController(OrganizationService organizationService) {
    this.organizationService = organizationService;
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
  public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
    System.out.println(organizationId);
    System.out.println(organizationId);
    return this.organizationService.getOrganizationById(organizationId);
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
  public void updateOrganization(@PathVariable("organizationId") String orgId,
      @RequestBody Organization org) {
    this.organizationService.updateOrganization(org);
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.POST)
  public void saveOrganization(@RequestBody Organization org) {
    this.organizationService.saveOrganization(org);
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrganization(@PathVariable("orgId") String orgId,
      @RequestBody Organization org) {
    this.organizationService.deleteOrganization(org);
  }
}
