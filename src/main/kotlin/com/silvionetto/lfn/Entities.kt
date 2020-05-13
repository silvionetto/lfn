package com.silvionetto.lfn

import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
        @Version var version: Long? = null,
        @Temporal(TemporalType.DATE) var lastUpdateDate: Date = Date()
) : Serializable

@Entity
data class User(
        var login: String,
        var firstname: String,
        var lastname: String,
        var description: String? = null
) : BaseEntity()

@Entity
data class Country(
        var name: String
) : BaseEntity()

@Entity
data class State(
        var name: String,
        var country: Country
) : BaseEntity()

@Entity
data class City(
        var name: String,
        var state: State
) : BaseEntity()

@Entity
data class Address(
        var user: User,
        var street: String,
        var number: Int,
        var postCode: String,
        var city: City,
        var state: State,
        var country: Country
) : BaseEntity()

@Entity
data class Category(
        var name: String,
        @Column(nullable = true)
        @OneToMany(cascade = [CascadeType.ALL])
        var subCategories: List<Category>?
) : BaseEntity()

@Entity
data class SubCategory(
        var name: String,
        @ManyToOne
        var category: Category
) : BaseEntity()