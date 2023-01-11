package com.lomasz.spring.boot.kt.template.application

import com.lomasz.spring.boot.kt.template.domain.TemplateService
import org.springframework.web.bind.annotation.RestController

@RestController
class TemplateController(
    private val templateService: TemplateService
) {
}
