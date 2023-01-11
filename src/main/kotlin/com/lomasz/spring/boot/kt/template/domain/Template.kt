package com.lomasz.spring.boot.kt.template.domain

import jakarta.persistence.*

@Entity
data class Template(
    @Id
    @SequenceGenerator(name = "template_seq", sequenceName = "template_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_seq")
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(length = 5, nullable = false)
    val acronym: String,

    @Column(length = 5, nullable = false)
    val budget: Long
)
