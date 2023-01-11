/*
 * The Boeing Company. Confidential & Proprietary
 *
 * This work contains valuable confidential and proprietary information.
 *
 * Disclosure, use or reproduction outside of The Boeing Company
 * is prohibited except as authorized in writing.  This unpublished work
 * is protected by the laws of the United States and other countries.
 * In the event of publication, the following notice shall apply:
 *
 * Copyright (c) 2023 The Boeing Company. All Rights Reserved.
 *
 */

package com.lomasz.spring.boot.kt.template

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.junit.jupiter.api.Test

class PackageStructureValidationTest {

    private val classes = ClassFileImporter().importPackages(mainPackage)

    companion object {
        private const val mainPackage = "com.lomasz.spring.boot.kt.template"
        private const val domainPackage = "$mainPackage.(*)..domain.."
        private const val applicationPackage = "$mainPackage.(*)..application.."
        private const val apiPackage = "$mainPackage.(*)..api.."
        private const val infrastructurePackage = "$mainPackage.(*)..infrastructure.."
    }

    @Test
    fun `should check dependencies for package - domain`() {
        val domainRules = ArchRuleDefinition.noClasses()
            .that()
            .resideInAPackage(domainPackage)
            .should()
            .accessClassesThat()
            .resideInAPackage(applicationPackage)
            .orShould()
            .accessClassesThat()
            .resideInAPackage(apiPackage)
            .orShould()
            .accessClassesThat()
            .resideInAPackage(infrastructurePackage)

        domainRules.check(classes)
    }

    @Test
    fun `should check dependencies for package - application`() {
        val applicationRules = ArchRuleDefinition.noClasses()
            .that()
            .resideInAPackage(applicationPackage)
            .should()
            .accessClassesThat()
            .resideInAPackage(apiPackage)
            .orShould()
            .accessClassesThat()
            .resideInAPackage(infrastructurePackage)

        applicationRules.check(classes)
    }

    @Test
    fun `should check dependencies for package - api`() {
        val apiRules = ArchRuleDefinition.noClasses()
            .that()
            .resideInAPackage(apiPackage)
            .should()
            .accessClassesThat()
            .resideInAPackage(infrastructurePackage)

        apiRules.check(classes)
    }
}
