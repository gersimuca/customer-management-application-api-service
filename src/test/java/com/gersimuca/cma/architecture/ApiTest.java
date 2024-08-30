package com.gersimuca.cma.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.gersimuca.cma.architecture.archunit.JavaClassesImporter;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

class ApiTest {

  @Test
  void api_facade_should_only_be_used_by_service_that_reside_in_a_feature() {
    classes()
        .that()
        .haveSimpleName("ApiFacade")
        .should()
        .onlyHaveDependentClassesThat()
        .resideInAnyPackage("com.gersimuca.cma.feature..")
        .andShould()
        .onlyHaveDependentClassesThat()
        .areAnnotatedWith(Service.class)
        .check(JavaClassesImporter.get("com.gersimuca.cma.api", "com.gersimuca.cma.feature.."));
  }
}
